package com.mozverse.mozimtestapp.presentation.features.session.configurator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mozverse.mozim.Mozim
import com.mozverse.mozim.domain.data.action.IMActionType
import com.mozverse.mozim.domain.data.config.IMXMLType
import com.mozverse.mozim.domain.data.trigger.IMTriggerType
import com.mozverse.mozimtestapp.data.xml.XMLConfigHelper
import com.mozverse.mozimtestapp.data.xml.XMLHelper
import com.mozverse.mozimtestapp.domain.usecase.DataState
import com.mozverse.mozimtestapp.presentation.features.session.configurator.data.ActionBuilderData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfiguredActionsViewModel @Inject constructor(
    private val mozim: Mozim,
    private val xmlConfigHelper: XMLConfigHelper,
    private val xmlHelper: XMLHelper
) : ViewModel() {

    private val _actionBuilderDataState =
        MutableStateFlow<DataState<ActionBuilderData>>(DataState.Loading())

    val configuratorSettingsState = _actionBuilderDataState.asStateFlow()

    private var actionBuilderData = ActionBuilderData()

    init {
        viewModelScope.launch {
            //todo: load and save the data
            _actionBuilderDataState.value = DataState.Success(actionBuilderData)
        }
    }

    fun startAction(actionType: IMActionType) {
        when (actionBuilderData.xmlType) {
            IMXMLType.VAST -> startImWithVast(actionType)
            IMXMLType.EXTENSION -> startImWithExtension(actionType)
        }
    }

    private fun startImWithVast(actionType: IMActionType) {

        val xml = xmlHelper.createXmlVastString(
            actionBuilderData.triggerType.trigger,
            actionType.action
        )
        val adId = if (actionBuilderData.isUsingAdId) xmlHelper.adId else null
        val config = xmlConfigHelper.createConfig(xml, adId)
        viewModelScope.launch(IO) {
            mozim.startIMWithVast(config)
        }

    }

    private fun startImWithExtension(actionType: IMActionType) {
        val xml = xmlHelper.buildXmlExtensionString(
            actionBuilderData.triggerType.trigger,
            actionType.action
        )
        val config = xmlConfigHelper.createConfig(xml)
        viewModelScope.launch(IO) {
            mozim.startIM(config)
        }

    }

    fun setSelectedTriggerType(triggerType: IMTriggerType) {
        actionBuilderData = actionBuilderData.copy(triggerType = triggerType)
        _actionBuilderDataState.value = DataState.Success(actionBuilderData)
    }

    fun setSelectedXmlType(xmlType: IMXMLType) {
        actionBuilderData = actionBuilderData.copy(xmlType = xmlType)
        _actionBuilderDataState.value = DataState.Success(actionBuilderData)
    }


    fun setIsUsingAdId(isUsingAdId: Boolean) {
        actionBuilderData = actionBuilderData.copy(isUsingAdId = isUsingAdId)
        _actionBuilderDataState.value = DataState.Success(actionBuilderData)
    }

}