package com.mozverse.mozimtestapp.data

import com.mozverse.mozim.domain.data.action.IMAction
import com.mozverse.mozim.domain.data.action.IMActionType
import com.mozverse.mozim.domain.data.config.IMXMLType
import com.mozverse.mozim.domain.data.interaction.IMInteraction
import com.mozverse.mozim.domain.data.trigger.IMTriggerType

fun getRandomInteraction() =
    IMInteraction(
        xmlType = IMXMLType.entries.random(),
        actions = mutableListOf(
            getRandomAction(),
            getRandomAction()
        )
    )

fun getRandomAction() = IMAction(
    actionType = IMActionType.entries.random(),
    triggerType = IMTriggerType.entries.random()
)