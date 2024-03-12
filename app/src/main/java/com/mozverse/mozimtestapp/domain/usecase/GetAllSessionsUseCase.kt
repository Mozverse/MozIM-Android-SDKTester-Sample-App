package com.mozverse.mozimtestapp.domain.usecase

import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.domain.repository.SessionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllSessionsUseCase @Inject constructor(
    private val sessionRepository: SessionRepository,
) {

    suspend fun execute() = channelFlow<DataState<List<Session>>> {
        send(DataState.Loading())
        withContext(Dispatchers.IO) {
            try {
                sessionRepository.getSessions().collect {
                    send(DataState.Success(it))
                }
            } catch (ex: Exception) {
                send(DataState.Error(exception = ex))
            }
        }
    }
}