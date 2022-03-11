package io.vanite.android.models.ui

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

/**
 * Created By : Yazan Tarifi
 * Date : 12/26/2019
 * Time : 9:33 PM
 */

data class VaniteAnimationSettings(
    var loopCountAnimation: Int = 1,
    @RawRes @DrawableRes var image: Int,
    var dp: Float = 200f
)