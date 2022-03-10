package io.vortex.android.errors

import io.vortex.android.models.VortexExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/18/2019
 * Time : 2:52 PM
 */

class VortexPrefsException : VortexException(object : VortexExceptionDetails<PrefsException> {
    override fun getExceptionMessage(): String {
        return "Maybe You Forget To Config The Prefs At VortexApplication"
    }

    override fun getExceptionBody(): PrefsException {
        return PrefsException(
            "Maybe You Forget To Config The Prefs At VortexApplication"
        )
    }

})

data class PrefsException(
    val message: String
)