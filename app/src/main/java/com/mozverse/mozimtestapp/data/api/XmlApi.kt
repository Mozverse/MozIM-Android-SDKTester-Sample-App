package com.mozverse.mozimtestapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface XmlApi {

    @GET
    suspend fun fetchXml(@Url url: String): Response<String>
}