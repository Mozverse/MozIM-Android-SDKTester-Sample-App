package com.mozverse.mozimtestapp.data.xml

import com.mozverse.mozim.domain.data.config.IMXmlConfig

class XMLConfigHelper {

    fun createConfig(
        xml: String,
        adId: String? = null
    ): IMXmlConfig {
        return IMXmlConfig(
            xml = xml,
            adID = adId,
            creativeID = "creativeId",
            userID = "userId",
            delay = 0L,
            startTime = 0L,
            endTime = 0L
        )
    }
}

