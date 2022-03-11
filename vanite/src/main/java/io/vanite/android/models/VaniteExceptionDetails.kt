package io.vanite.android.models

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 8:48 PM
 */

interface VaniteExceptionDetails<B> {

    fun getExceptionMessage(): String

    fun getExceptionBody(): B

}