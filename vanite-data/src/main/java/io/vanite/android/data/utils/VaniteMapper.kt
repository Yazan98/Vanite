package io.vanite.android.data.utils

interface VaniteMapper<From, To> {

    fun from(to: To): From

    fun to(from: From): To

}
