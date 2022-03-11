package io.vanite.android.firebase

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import io.vanite.android.firebase.impl.FirebaseNotificationImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created By : Yazan Tarifi
 * Date : 10/26/2019
 * Time : 11:07 PM
 */

abstract class VaniteFirebaseMessaging : FirebaseMessagingService(), FirebaseNotificationImpl<VaniteNotification> {

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        onNewMessage(p0)
    }

    @SuppressLint("WrongConstant")
    override suspend fun showNotification(notification: VaniteNotification) {
        withContext(Dispatchers.Main) {
            val mBuilder = NotificationCompat.Builder(applicationContext, notification.channelId)
                .setSmallIcon(notification.smallIcon)
                .setContentTitle(notification.title)
                .setContentText(notification.body)
                .setAutoCancel(true)
            if (notification.target != null) {
                val intent = Intent(applicationContext, notification.target)
                val pi = PendingIntent.getActivity(
                    applicationContext, notification.reqCode,
                    intent, Intent.FLAG_ACTIVITY_NEW_TASK
                )
                mBuilder.setContentIntent(pi)
            }
            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.notify(notification.notificationId, mBuilder.build())
        }
    }

    @SuppressLint("WrongConstant")
    override suspend fun showNotification() {
        withContext(Dispatchers.Main) {
            val mBuilder = NotificationCompat.Builder(applicationContext, getNotificationInfo().channelId)
                .setSmallIcon(getNotificationInfo().smallIcon)
                .setContentTitle(getNotificationInfo().title)
                .setContentText(getNotificationInfo().body)
                .setAutoCancel(true)
            if (getNotificationInfo().target != null) {
                val intent = Intent(applicationContext, getNotificationInfo().target)
                val pi = PendingIntent.getActivity(
                    applicationContext, getNotificationInfo().reqCode,
                    intent, Intent.FLAG_ACTIVITY_NEW_TASK
                )
                mBuilder.setContentIntent(pi)
            }
            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.notify(getNotificationInfo().notificationId, mBuilder.build())
        }
    }

    override suspend fun showScreen(target: Class<*>) {
        withContext(Dispatchers.Main) {
            baseContext.startActivity(Intent(applicationContext, target))
        }
    }

    protected abstract fun onNewMessage(manager: RemoteMessage)
    protected abstract fun getNotificationInfo(): VaniteNotification

}
