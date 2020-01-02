package io.vortex.android.logic.impl

import io.vortex.android.logic.utils.MatchingLocales
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 1/2/2020
 * Time : 2:42 PM
 */

interface MatchingAlgorithm {

    fun findDefaultMatch(
        supportedLocales: List<Locale?>?,
        systemLocales: List<Locale?>?
    ): MatchingLocales?

    fun findMatch(
        supportedLocale: Locale?,
        systemLocales: List<Locale?>?
    ): MatchingLocales?
}