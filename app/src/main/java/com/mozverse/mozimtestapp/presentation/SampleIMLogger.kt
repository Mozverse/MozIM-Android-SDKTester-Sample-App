package com.mozverse.mozimtestapp.presentation

import com.mozverse.mozim.domain.listener.IMLogger
import timber.log.Timber

class SampleIMLogger : IMLogger() {

    override val tag = "MozimTestApp"

    override var isEnabled = true

    override fun d(tag: String, message: String) {
        Timber.tag(tag).d("MTA - $message")
    }

    override fun e(tag: String, message: String?, ex: Throwable) {
        Timber.tag(tag).e(ex, "MTA - ${message ?: "exception:"}")
    }

    override fun i(tag: String, message: String) {
        Timber.tag(tag).i("MTA - $message")
    }

    override fun v(tag: String, message: String) {
        Timber.tag(tag).v("MTA - $message")
    }


}