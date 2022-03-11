package io.vanite.android.ui.impl

import android.content.Context

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 10:19 PM
 */

interface MessageDelegationImpl {

    suspend fun showShortMessage(message: String , context: Context?)

    suspend fun showLongMessage(message: String , context: Context?)

    suspend fun showShortMessage(message: Int , context: Context?)

    suspend fun showLongMessage(message: Int , context: Context?)

}
