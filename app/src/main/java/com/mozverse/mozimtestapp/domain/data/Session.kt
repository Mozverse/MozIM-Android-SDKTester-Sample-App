package com.mozverse.mozimtestapp.domain.data

import android.os.Parcelable
import com.mozverse.mozim.domain.data.config.IMXMLType
import com.mozverse.mozim.domain.data.config.IMXmlConfig
import com.mozverse.mozim.domain.data.interaction.IMInteraction
import kotlinx.parcelize.Parcelize

@Parcelize
data class Session(
    val url: String = "url",
    var xmlConfig: IMXmlConfig = IMXmlConfig(xml = "sample xml"),
    var interaction: IMInteraction = IMInteraction(xmlType = IMXMLType.VAST)
): Parcelable