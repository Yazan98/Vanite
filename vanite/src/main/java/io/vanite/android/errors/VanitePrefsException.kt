package io.vanite.android.errors

import io.vanite.android.models.VaniteExceptionDetails

/**
 * Created By : Yazan Tarifi
 * Date : 10/18/2019
 * Time : 2:52 PM
 */

class VanitePrefsException : VaniteException(object : VaniteExceptionDetails<PrefsException> {
    override fun getExceptionMessage(): String {
        return "Maybe You Forget To Config The Prefs At VaniteApplication"
    }

    override fun getExceptionBody(): PrefsException {
        return PrefsException(
            "Maybe You Forget To Config The Prefs At VaniteApplication"
        )
    }

})

data class PrefsException(
    val message: String
)