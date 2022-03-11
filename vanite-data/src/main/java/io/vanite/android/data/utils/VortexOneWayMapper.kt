package io.vanite.android.data.utils

interface VortexOneWayMapper<in From, out To> {

    fun convert(from: From): To

}
