package com.mozverse.mozimtestapp.presentation.extensions

import android.content.Intent
import android.os.Build

fun <T> Intent.getParcelableCompat(key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        extras?.getParcelable(key, clazz)
    } else {
        @Suppress("DEPRECATION")
        extras?.getParcelable(key) as T?
    }
}
