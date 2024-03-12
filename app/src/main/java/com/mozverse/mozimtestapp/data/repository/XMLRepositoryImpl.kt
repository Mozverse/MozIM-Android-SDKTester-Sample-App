package com.mozverse.mozimtestapp.data.repository

import com.mozverse.mozimtestapp.data.api.XmlApi
import com.mozverse.mozimtestapp.domain.data.exception.EmptyXmlException
import com.mozverse.mozimtestapp.domain.data.exception.UnsuccessfulApiCallException
import com.mozverse.mozimtestapp.domain.repository.XMLRepository
import javax.inject.Inject


class XMLRepositoryImpl @Inject constructor(
    private val xmlApi: XmlApi
) : XMLRepository {

    private val _builtInUrls = listOf<String>(
        "https://vast.moz-im.com?adUnitId=302cd169-e411-43c3-b119-39deba0a8e13",
        "https://vast.moz-im.com?adUnitId=76fa0107-7107-45b0-9355-b87ca7b6932a",
        "https://vast.moz-im.com?adUnitId=2f2a1b7d-d8bc-4245-9962-84301eb4ecae",
        "https://vast.moz-im.com?adUnitId=9914cfbb-8be5-4371-9c3f-97d4afb50df6",
        "https://vast.moz-im.com?adUnitId=5cfa7ca2-d5a6-4028-ac01-cd227b4a93e9",
        "https://vast.moz-im.com?adUnitId=240fde9d-d4d1-44ed-996a-fda1528ccfb0",
        "https://vast.moz-im.com?adUnitId=01570a0e-c4c6-4923-a7d4-51cc88e4bd36",
        "https://vast.moz-im.com?adUnitId=0f61b3f0-dc23-420e-b0a5-3a057a6ba4f5",
        "https://vast.moz-im.com?adUnitId=af3d10e3-8e04-4a73-b138-2dbb3ebc9098",
        "https://vast.moz-im.com?adUnitId=5df0add1-9831-4a0f-81d3-0a444b5fef18",
        "https://vast.moz-im.com?adUnitId=67f0f7c2-f5b8-43c3-a6e3-ca36cad77f85",
        "https://vast.moz-im.com?adUnitId=bd77edea-1eba-481f-8b9c-144b9f661a95",
        "https://vast.moz-im.com?adUnitId=52fd4a67-b55c-4fcf-a183-84b59148f12a",
        "https://vast.moz-im.com?adUnitId=b8582ba5-86a9-4564-b62b-11e688712468",
        "https://vast.moz-im.com?adUnitId=30286a23-0aab-45db-a694-06bd114bc0d1",
        "https://vast.moz-im.com?adUnitId=4df36011-d15b-46c5-8c6c-84fe2a51b4e3"
    ).distinct()

    override suspend fun loadXml(url: String): String {
        val response = xmlApi.fetchXml(url)
        if (!response.isSuccessful) throw UnsuccessfulApiCallException(
            response.errorBody()?.string()
        )
        val message = response.body()
        return message?.takeIf { it.isNotEmpty() } ?: throw EmptyXmlException()
    }

    override fun getBuiltInUrls() = _builtInUrls
}