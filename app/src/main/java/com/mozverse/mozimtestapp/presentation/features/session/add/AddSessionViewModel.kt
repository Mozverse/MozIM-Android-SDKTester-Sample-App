package com.mozverse.mozimtestapp.presentation.features.session.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mozverse.mozimtestapp.domain.usecase.AddBuiltInUrlsUseCase
import com.mozverse.mozimtestapp.domain.usecase.AddXmlUrlUseCase
import com.mozverse.mozimtestapp.domain.usecase.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AddSessionViewModel @Inject constructor(
    private val addXmlUrlUseCase: AddXmlUrlUseCase,
    private val addBuiltINUrlUseCase: AddBuiltInUrlsUseCase
) : ViewModel() {

    private val _sessionState = MutableStateFlow<DataState<Any>>(DataState.EmptyData())

    val sessionState = _sessionState.asStateFlow()

    fun importUrl(url: String) {
        Timber.d("adding url to repo")
        viewModelScope.launch {
            addXmlUrlUseCase.execute(url)
                .collect {
                    _sessionState.value = it
                }
        }
    }

    fun importBuiltInUrls() {
        viewModelScope.launch {
            addBuiltINUrlUseCase.execute()
                .collect {
                    _sessionState.value = it
                }
        }
    }


}