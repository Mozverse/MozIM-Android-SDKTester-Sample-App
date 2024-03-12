package com.mozverse.mozimtestapp.presentation.features.session.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mozverse.mozim.Mozim
import com.mozverse.mozim.domain.data.config.IMXMLType
import com.mozverse.mozim.domain.data.config.IMXmlConfig
import com.mozverse.mozimtestapp.data.getRandomInteraction
import com.mozverse.mozimtestapp.data.xml.XMLConfigHelper
import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.domain.repository.SessionRepository
import com.mozverse.mozimtestapp.domain.usecase.DataState
import com.mozverse.mozimtestapp.domain.usecase.GetAllSessionsUseCase
import com.mozverse.mozimtestapp.domain.usecase.RemoveSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SessionsViewModel @Inject constructor(
    private val getAllSessionsUseCase: GetAllSessionsUseCase,
    private val removeSessionUseCase: RemoveSessionUseCase,
    private val sessionRepository: SessionRepository,
    private val mozim: Mozim
) : ViewModel() {

    private val _sessionsState = MutableStateFlow<DataState<List<Session>>>(DataState.Loading())

    val sessionsState = _sessionsState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllSessionsUseCase.execute().collect { mtaSessions ->
                _sessionsState.value = mtaSessions
            }
        }
    }

    fun onAddInteraction() {
        val urlExtra = sessionRepository.getNextId()
        sessionRepository.addOrUpdate(
            Session(
                url = "https://www.mozverse.com/alotofotherparmetersthatcomehandy/$urlExtra",
                xmlConfig = IMXmlConfig(xml = "xmlConfig"),
                interaction = getRandomInteraction()
            )
        )
    }

    fun deleteSession(session: Session) {
        Timber.d("deleting session: ${session.url}")
        removeSessionUseCase.execute(session)
    }

    fun startSession(session: Session) {
        viewModelScope.launch(IO) {
            when (session.interaction.xmlType) {
                IMXMLType.VAST -> mozim.startIMWithVast(session.xmlConfig)
                IMXMLType.EXTENSION -> mozim.startIM(session.xmlConfig)
            }
        }
    }
}