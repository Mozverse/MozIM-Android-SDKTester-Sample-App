package com.mozverse.mozimtestapp.domain.repository

import com.mozverse.mozimtestapp.domain.data.Session
import kotlinx.coroutines.flow.StateFlow

interface SessionRepository {


    fun add(session: Session)

    fun remove(session: Session)

    fun update(session: Session)

    fun addOrUpdate(session: Session)

    fun addOrUpdateAll(sessions: List<Session>)

    fun clearAndAddAll(sessions: List<Session>)
    fun getSessionByUrl(url: String): Session?

    fun getSessions(): StateFlow<List<Session>>

    fun sessionCount(): Int

    fun getNextId(): Int

}




