package io.vanite.android.data.utils

interface VaniteOneWayMapper<in From, out To> {

    fun convert(from: From): To

}
