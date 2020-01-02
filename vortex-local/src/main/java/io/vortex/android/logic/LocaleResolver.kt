package io.vortex.android.logic

import io.vortex.android.logic.impl.MatchingAlgorithm
import io.vortex.android.logic.utils.DefaultResolvedLocalePair
import io.vortex.android.logic.utils.MatchingLocales
import io.vortex.android.logic.utils.VortexUnsupportedLocaleException
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 1/2/2020
 * Time : 2:39 PM
 */

class LocaleResolver {

    private var supportedLocales: List<Locale> = arrayListOf()
    private var systemLocales: List<Locale> = arrayListOf()
    private lateinit var matchingAlgorithm: MatchingAlgorithm
    private lateinit var preference: LocalePreference

    fun resolveDefault(): DefaultResolvedLocalePair? {
        val matchingPair = matchingAlgorithm.findDefaultMatch(supportedLocales, systemLocales);
        return if(matchingPair != null) {
            matchingPair.getPreferredLocale(preference)?.let {
                DefaultResolvedLocalePair(matchingPair.supportedLocale,
                    it
                )
            }
        } else {
            DefaultResolvedLocalePair(supportedLocales[0], supportedLocales[0])
        }
    }

    @Throws(VortexUnsupportedLocaleException::class)
    fun resolve(supportedLocale: Locale): Locale? {
        if (!supportedLocales.contains(supportedLocale))
            throw VortexUnsupportedLocaleException("This Locale ${supportedLocale.language} is Not Supported");

        var matchingPair: MatchingLocales? = null
            if (preference.equals(LocalePreference.PreferSystemLocale)) {
                matchingPair = matchingAlgorithm.findMatch(supportedLocale, systemLocales);
        }

        return if(matchingPair != null) {
            matchingPair.getPreferredLocale(preference)
        } else {
            supportedLocale
        }
    }

}