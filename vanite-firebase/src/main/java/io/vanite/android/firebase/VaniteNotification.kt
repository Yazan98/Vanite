package io.vanite.android.firebase

import androidx.annotation.LayoutRes

/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 11:13 PM
 */

data class VaniteNotification(
    var title: String = "",
    var body: String = "",
    @LayoutRes var smallIcon: Int,
    @LayoutRes var bigIcon: Int,
    val target: Class<*>?,
    var channelId: String = "",
    var reqCode: Int,
    var notificationId: Int
)