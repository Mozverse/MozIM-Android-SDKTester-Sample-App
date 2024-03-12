package com.mozverse.mozimtestapp.domain.usecase

import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.domain.repository.SessionRepository
import javax.inject.Inject

class RemoveSessionUseCase @Inject constructor(
    private val sessionRepository: SessionRepository
) {

    fun execute(session: Session) {
        sessionRepository.remove(session)
    }
}