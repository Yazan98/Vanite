package io.vortex.android.logic.utils

import io.vortex.android.logic.LocalePreference
import java.util.*


/**
 * Created By : Yazan Tarifi
 * Date : 1/2/2020
 * Time : 2:43 PM
 */

data class MatchingLocales(
    val supportedLocale: Locale,
    val systemLocale: Locale
) {
    fun getPreferredLocale(preference: LocalePreference): Locale? {
        return if (preference == LocalePreference.PreferSupportedLocale) supportedLocale else systemLocale
    }
}
