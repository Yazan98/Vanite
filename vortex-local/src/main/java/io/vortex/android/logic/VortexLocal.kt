package io.vortex.android.logic

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 1/2/2020
 * Time : 2:09 PM
 */

object VortexLocal {

    suspend fun initLocalOptions(context: Context , supportedOptions: List<Locale>) {
        withContext(Dispatchers.IO) {
            val delegation = VortexLocalDelegation(context)
            delegation.initialize()
        }
    }

}