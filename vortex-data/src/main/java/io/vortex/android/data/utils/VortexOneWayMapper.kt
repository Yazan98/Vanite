package io.vortex.android.data.utils

interface VortexOneWayMapper<in From, out To> {

    fun convert(from: From): To

}
