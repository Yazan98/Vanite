package io.vortex.android.errors

import io.vortex.android.models.VortexExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 8:56 PM
 */

class VortexOperationBlockedException(details: VortexExceptionDetails<*>) : VortexException(details)
