package com.mozverse.mozimtestapp.data

import com.mozverse.mozim.domain.data.action.IMAction
import com.mozverse.mozim.domain.data.action.IMActionData
import com.mozverse.mozim.domain.data.action.IMActionType
import com.mozverse.mozim.domain.data.config.IMXMLType
import com.mozverse.mozim.domain.data.config.IMXmlConfig
import com.mozverse.mozim.domain.data.interaction.IMInteraction
import com.mozverse.mozim.domain.data.trigger.IMTriggerType
import com.mozverse.mozimtestapp.domain.data.Session

fun previewIMAction1() = IMAction()

fun previewSession1() = Session(
    "https:/www.example.com/1",
    interaction = previewInteractionVAST(),
    xmlConfig = IMXmlConfig(xml = "<VAST> </VAST")
)

fun previewSession2() = Session("https:/www.example.com/2")

fun previewSessionList() = listOf(previewSession1(), previewSession2())

fun previewInteractionVAST() = IMInteraction(
    xmlType = IMXMLType.VAST,
    actions = previewActionList(),
)

fun previewInteractionExtension() = IMInteraction(
    xmlType = IMXMLType.EXTENSION,
    actions = previewActionList(),
)

fun previewInteractionList() = listOf(
    previewInteractionVAST(),
    previewInteractionExtension()
)


fun previewAction1() = IMAction(
    actionType = IMActionType.WEBSITE,
    triggerType = IMTriggerType.SHAKE,
    actionData = previewActionDataWebsite()
)

fun previewAction2() = IMAction(
    actionType = IMActionType.CALL,
    triggerType = IMTriggerType.INSTANT,
    actionData = previewActionDataCall()
)

fun previewActionList() = listOf(
    previewAction1(),
    previewAction2()
)

fun previewActionDataWebsite() = IMActionData(
    url = "https://www.example.com/website"
)

fun previewActionDataCall() = IMActionData(
    phoneNumber = "+123456789"
)

fun previewAllActionData() = IMActionData(
    url = "https://www.example.com/website",
    playStoreUrl = "https://www.example.com/playStore",
    walletUrl = "https://www.example.com/wallet",
    eventICSUrl = "https://www.example.com/eventIcs",
    phoneNumber = "+19993673767",
    contactVCFUrl = "https://www.example.com/contact.vcf",
    directions = "https://www.example.com/directions",
    locations = "https://www.example.com/locations",
    imageUrl = "https://www.example.com/image.png",
    emailRecipient = "example@email.com",
    emailSubject = "Sample email Subject",
    emailBody = "Sample email body",
)