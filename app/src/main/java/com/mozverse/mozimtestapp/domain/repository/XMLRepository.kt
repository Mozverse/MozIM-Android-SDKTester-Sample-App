package com.mozverse.mozimtestapp.domain.repository

interface XMLRepository {

    suspend fun loadXml(url: String): String

    fun getBuiltInUrls(): List<String>
}