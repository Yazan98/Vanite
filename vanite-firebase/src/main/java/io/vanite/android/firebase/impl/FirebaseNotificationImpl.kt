package io.vanite.android.firebase.impl

/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 11:12 PM
 */

interface FirebaseNotificationImpl<Notification> {

    suspend fun showNotification(notification: Notification)

    suspend fun showNotification()

    suspend fun showScreen(target: Class<*>)

}