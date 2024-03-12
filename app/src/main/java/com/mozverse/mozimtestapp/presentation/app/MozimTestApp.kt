package com.mozverse.mozimtestapp.presentation.app

import com.mozverse.mozimtestapp.domain.Constants
import android.app.Application
import com.mozverse.mozim.Mozim
import com.mozverse.mozim.domain.data.config.IMConfig
import com.mozverse.mozim.domain.data.permissions.IMPrePermissionPromptType
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.presentation.NotificationHelper
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MozimTestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initNotificationChannel()
        initializeMozim()
        initTimber()
    }

    private fun initializeMozim() {
        val imConfig = IMConfig(
            sdkID = "sdkId",
            areAnalyticsEnabled = true,
            areHapticsEnabled = true,
            shouldAskNotificationPermissions = false,
            isLoggingEnabled = true,
            notificationChannelId = Constants.NOTIFICATION_CHANNEL_ID,
            smallNotificationIconResId = R.drawable.ic_notification_small,
            prePermissionPromptType = IMPrePermissionPromptType.EXTENDED,
            shouldShowPrePermissionPrompt = true,
            backgroundActionWaitTime = 10_000
        )
        Mozim.getInstance().initialize(this, imConfig)
        Mozim.getInstance().setTheme { content -> MozimTestAppTheme { content() } }
    }


    private fun initNotificationChannel() {
        NotificationHelper.createNotificationChannel(this)
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

}