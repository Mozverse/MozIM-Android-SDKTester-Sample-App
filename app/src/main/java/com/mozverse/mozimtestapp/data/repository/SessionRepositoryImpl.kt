package com.mozverse.mozimtestapp.data.repository

import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.domain.repository.SessionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

//todo: refactor to use Room
class SessionRepositoryImpl @Inject constructor() : SessionRepository {

    private val _sessions = mutableListOf<Session>()

    private val _sessionsFlow = MutableStateFlow<List<Session>>(emptyList())

    private val currentId = AtomicInteger(0)

    override fun add(session: Session) {
        _sessions.add(session)
        postSessions()
    }

    override fun remove(session: Session) {
        _sessions.removeAll { it.url == session.url }
        postSessions()
    }

    override fun update(session: Session) {
        val index = _sessions.indexOfFirst { it.url == session.url }
        if (index >= 0) {
            _sessions.removeAt(index)
            _sessions.add(index, session)
        }
        postSessions()
    }

    override fun addOrUpdate(session: Session) {
        addOrUpdateSingleSession(session)
        postSessions()
    }

    override fun addOrUpdateAll(sessions: List<Session>) {
        sessions.forEach { session ->
            addOrUpdateSingleSession(session)
        }
        postSessions()
    }

    private fun addOrUpdateSingleSession(session: Session) {
        val index = _sessions.indexOfFirst { it.url == session.url }
        if (index >= 0) {
            _sessions.removeAt(index)
            _sessions.add(index, session)
        } else {
            _sessions.add(session)
        }
    }

    override fun clearAndAddAll(sessions: List<Session>) {
        _sessions.clear()
        _sessions.addAll(sessions)
        postSessions()
    }

    override fun getSessionByUrl(url: String): Session? {
        return _sessions.firstOrNull { it.url == url }
    }

    override fun getSessions(): StateFlow<List<Session>> = _sessionsFlow

    override fun sessionCount() = if (_sessions.isEmpty()) 0 else _sessions.size


    override fun getNextId() = currentId.getAndIncrement()


    private fun postSessions() {
        _sessionsFlow.value = _sessions.toList()
    }
}




