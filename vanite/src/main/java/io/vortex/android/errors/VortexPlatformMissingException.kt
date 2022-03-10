package io.vortex.android.errors

import io.vortex.android.models.VortexExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/9/2019
 * Time : 9:00 PM
 */

class VortexPlatformMissingException(details: VortexExceptionDetails<*>) : VortexException(details)
