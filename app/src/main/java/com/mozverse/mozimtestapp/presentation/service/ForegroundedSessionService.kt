package com.mozverse.mozimtestapp.presentation.service


import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.mozverse.mozim.Mozim
import com.mozverse.mozim.domain.data.config.IMXMLType
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.data.xml.XMLConfigHelper
import com.mozverse.mozimtestapp.domain.Constants
import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.presentation.MainActivity
import com.mozverse.mozimtestapp.presentation.extensions.getParcelableCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.IllegalArgumentException


class ForegroundedSessionService : Service() {

    private var jobs = mutableListOf<Job>()

    val mozim by lazy {
        Mozim.getInstance()
    }

    val xmlConfigHelper by lazy {
        XMLConfigHelper()
    }

    override fun onCreate() {
        //startInForeground()
        super.onCreate()
    }

    private fun startInForeground() {
        Timber.d("startInForeground")
        val notificationIntent = Intent(this, MainActivity::class.java)
        val requestCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
        } else {
            0
        }
        val pendingIntent = PendingIntent.getActivity(
            this,
            requestCode,
            notificationIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val notification =  NotificationCompat.Builder(this, Constants.NOTIFICATION_CHANNEL_ID)
            .setContentTitle(getString(R.string.session_foreground_service_notification_title))
            .setContentText(getString(R.string.session_foreground_service_notification_content))
            .setSmallIcon(R.drawable.ic_notification_small)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(NOTIFICATION_ID, notification)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Timber.d("onStartCommand()")
        //if (!isRunningInForeground.getAndSet(true)) startInForeground()
        startInForeground()

        val session = intent.getParcelableCompat(INTENT_EXTRA_SESSION, Session::class.java)
            ?: throw IllegalArgumentException("Missing Session in intent extras")
        val job = CoroutineScope(Dispatchers.IO).launch {
            when (session.interaction.xmlType) {
                IMXMLType.VAST -> mozim.startIMWithVast(session.xmlConfig)
                IMXMLType.EXTENSION -> mozim.startIM(session.xmlConfig)
            }
        }
        jobs.add(job)
        return START_NOT_STICKY
    }


    override fun onDestroy() {
        jobs.forEach {
            if (it.isActive) it.cancel()
        }
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        // Return null since this service does not have a binding interface
        return null
    }

    companion object {
        private const val NOTIFICATION_ID = 4101121
        private const val INTENT_EXTRA_SESSION = "session.foreground.service.extra.session"

        fun startForegroundedSession(context: Context, session: Session) {
            val intent = Intent(context, ForegroundedSessionService::class.java).apply {
                putExtra(INTENT_EXTRA_SESSION, session)
            }
            ContextCompat.startForegroundService(context, intent)
        }
    }
}

