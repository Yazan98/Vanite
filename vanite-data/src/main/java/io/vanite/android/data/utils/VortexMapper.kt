package io.vanite.android.data.utils

interface VortexMapper<From, To> {

    fun from(to: To): From

    fun to(from: From): To

}
