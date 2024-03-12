package com.mozverse.mozimtestapp.presentation.features.session.configurator.data

import com.mozverse.mozim.domain.data.action.IMActionType
import com.mozverse.mozim.domain.data.config.IMXMLType
import com.mozverse.mozim.domain.data.trigger.IMTriggerType

data class ActionBuilderData(
    val xmlType: IMXMLType = IMXMLType.EXTENSION,
    val isUsingAdId: Boolean = true,
    val triggerType: IMTriggerType = IMTriggerType.INSTANT,
    val actionTypes: List<IMActionType> = IMActionType.entries.filter { it != IMActionType.UNKNOWN }
)
