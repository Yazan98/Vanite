package io.vortex.android.models

import android.content.ContextWrapper

/**
 * Created By : Yazan Tarifi
 * Date : 10/10/2019
 * Time : 10:10 PM
 */

data class VortexPrefsDetails(
    var mode: Int = ContextWrapper.MODE_PRIVATE,
    var packageName: String = ""
)
