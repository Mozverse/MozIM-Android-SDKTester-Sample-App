package com.mozverse.mozimtestapp.domain.usecase

import com.mozverse.mozim.Mozim
import com.mozverse.mozimtestapp.data.xml.XMLConfigHelper
import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.domain.repository.SessionRepository
import com.mozverse.mozimtestapp.domain.repository.XMLRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class AddBuiltInUrlsUseCase @Inject constructor(
    private val xmlConfigHelper: XMLConfigHelper,
    private val xmlRepository: XMLRepository,
    private val sessionRepository: SessionRepository,
    private val mozim: Mozim
) {

    suspend fun execute() = channelFlow<DataState<Any>> {
        send(DataState.Loading())
        withContext(Dispatchers.IO) {
            try {
                val getXmlJobs = mutableListOf<Deferred<String>>()
                val urls = xmlRepository.getBuiltInUrls()
                urls.forEach { url ->
                    val job = async {
                        xmlRepository.loadXml(url)
                    }
                    getXmlJobs.add(job)
                }

                val xmlList = mutableListOf<String>()

                getXmlJobs.forEach {
                    xmlList.add(it.await())
                }

                val sessions: List<Session> = xmlList.mapIndexed { index, xml ->
                    val url = urls[index]
                    val session = sessionRepository.getSessionByUrl(url)
                    val imXmlConfig = session?.xmlConfig ?: xmlConfigHelper.createConfig(xml)
                    Timber.d("parsing interaction for url $url")
                    val imInteraction = mozim.parseInteraction(imXmlConfig)
                    Triple(url, imXmlConfig, imInteraction)
                }.filter { (_, _, imInteraction) ->
                    imInteraction != null
                }.map { (xml, config, interaction) ->
                    // interactions that are null are filtered
                    Session(xml, config, interaction!!)
                }

                sessionRepository.addOrUpdateAll(sessions)

                send(DataState.Success(Any()))
            } catch (ex: Exception) {
                send(DataState.Error(ex))
            }
        }
    }
}