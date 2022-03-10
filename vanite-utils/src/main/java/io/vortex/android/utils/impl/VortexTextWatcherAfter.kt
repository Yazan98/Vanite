package io.vortex.android.utils.impl

import android.text.Editable

interface VortexTextWatcherAfter {

    fun onTextFinished(s: Editable?)

}