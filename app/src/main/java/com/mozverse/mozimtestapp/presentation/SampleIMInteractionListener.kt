package com.mozverse.mozimtestapp.presentation

import com.mozverse.mozim.domain.data.action.IMAction
import com.mozverse.mozim.domain.data.permissions.IMPermissionType
import com.mozverse.mozim.domain.listener.IMInteractionListener
import timber.log.Timber

class SampleIMInteractionListener : IMInteractionListener {

    private val listenerTag = "InteractionListener"

    override fun onAction(action: IMAction) {
        Timber.tag(listenerTag).d("onAction ${action.adID}")
    }

    override fun onActionApprovalComplete(action: IMAction, isApproved: Boolean) {
        Timber.tag(listenerTag).d("onActionApprovalComplete() called with: action = ${action.adID}, isApproved = $isApproved")
    }

    override fun onNotificationAction(action: IMAction) {
        Timber.tag(listenerTag).d("onNotificationClicked ${action.adID}")
    }

    override fun onNotificationSent(action: IMAction) {
        Timber.tag(listenerTag).d("onNotificationSent ${action.adID}")
    }

    override fun onPermissionDenied(action: IMAction?, imPermissionType: IMPermissionType) {
        Timber.tag(listenerTag).d("onPermissionDenied() called with: action = ${action?.adID}, imPermissionType = $imPermissionType")
    }

    override fun onPermissionGranted(action: IMAction?, imPermissionType: IMPermissionType) {
        Timber.tag(listenerTag).d("onPermissionGranted() called with: action = ${action?.adID}, imPermissionType = $imPermissionType")
    }

    override fun onPrePermissionPromptDismissed(
        action: IMAction?,
        imPermissionType: IMPermissionType
    ) {
        Timber.tag(listenerTag).d("onPrePermissionPromptDismissed() called with: action = ${action?.adID}, imPermissionType = $imPermissionType")
    }

    override fun onPrePermissionPromptShown(action: IMAction?, imPermissionType: IMPermissionType) {
        Timber.tag(listenerTag).d("onPrePermissionPromptShown() called with: action = ${action?.adID}, imPermissionType = $imPermissionType")
    }

    override fun onRequestPermission(action: IMAction?, imPermissionType: IMPermissionType) {
        Timber.tag(listenerTag).d("onRequestPermission() called with: action = ${action?.adID}, imPermissionType = $imPermissionType")
    }

    override fun onTriggerDetected(action: IMAction) {
        Timber.tag(listenerTag).d("onTriggerDetected ${action.adID}")
    }

    override fun onTriggerDetectionStarted(action: IMAction) {
        Timber.tag(listenerTag).d("onTriggerDetectionStarted ${action.adID}")
    }
}