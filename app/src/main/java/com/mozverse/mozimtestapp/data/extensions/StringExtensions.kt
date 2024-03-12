package com.mozverse.mozimtestapp.data.extensions

fun String.capitalizeFirst() = this.lowercase().replaceRange(0, 1, this[0].uppercase())
