package io.vortex.android.logic

import android.content.Context
import io.vortex.android.logic.utils.VortexUnsupportedLocaleException
import java.util.*

/**
 * Created By : Yazan Tarifi
 * Date : 1/2/2020
 * Time : 2:10 PM
 */

class VortexLocalDelegation(private val context: Context) {

    private var currentLocale: Locale? = null
    private val languageLoader: VortexLanguageLoader by lazy {
        VortexLanguageLoader(context)
    }

    private val resolver: LocaleResolver by lazy {
        LocaleResolver()
    }

    private val appLocaleChanger: VortexAppLocaleChanger by lazy {
        VortexAppLocaleChanger(context)
    }

    suspend fun initialize() {
        var persistedLocale: Locale? = languageLoader.load()
        if (persistedLocale != null)
            try {
                currentLocale = resolver.resolve(persistedLocale);
            } catch (e: VortexUnsupportedLocaleException) {
                persistedLocale = null;
            }

        if (persistedLocale == null) {
            val defaultLocalePair = resolver.resolveDefault()
            currentLocale = defaultLocalePair?.resolvedLocale
            defaultLocalePair?.supportedLocale?.let {
                languageLoader.save(it)
            }
        }

        appLocaleChanger.change(currentLocale);
    }
}
