package io.vanite.android.errors

import io.vanite.android.models.VaniteExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 8:56 PM
 */

class VaniteOperationBlockedException(details: VaniteExceptionDetails<*>) : VaniteException(details)
