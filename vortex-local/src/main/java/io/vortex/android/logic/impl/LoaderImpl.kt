package io.vortex.android.logic.impl

import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 1/2/2020
 * Time : 2:15 PM
 */

interface LoaderImpl {

    suspend fun load(): Locale

    suspend fun save(locale: Locale)

    suspend fun destroyLoader()

}
