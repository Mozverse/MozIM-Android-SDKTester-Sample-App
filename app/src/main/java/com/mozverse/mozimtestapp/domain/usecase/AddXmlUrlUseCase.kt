package com.mozverse.mozimtestapp.domain.usecase

import com.mozverse.mozim.Mozim
import com.mozverse.mozimtestapp.data.xml.XMLConfigHelper
import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.domain.data.exception.VastParseException
import com.mozverse.mozimtestapp.domain.repository.SessionRepository
import com.mozverse.mozimtestapp.domain.repository.XMLRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddXmlUrlUseCase @Inject constructor(
    private val urlRepository: XMLRepository,
    private val xmlConfigHelper: XMLConfigHelper,
    private val sessionRepository: SessionRepository,
    private val mozim: Mozim
) {

    suspend fun execute(url: String) = channelFlow<DataState<Any>> {
        send(DataState.Loading())
        withContext(Dispatchers.IO) {
            try {
                val xml = urlRepository.loadXml(url)
                val xmlConfig = xmlConfigHelper.createConfig(xml)
                val interaction = mozim.parseInteraction(xmlConfig) ?: throw VastParseException()
                val session = Session(url, xmlConfig, interaction)
                sessionRepository.add(session)
                send(DataState.Success(Any()))
            } catch (ex: Exception) {
                send(DataState.Error(ex))
            }
        }
    }
}