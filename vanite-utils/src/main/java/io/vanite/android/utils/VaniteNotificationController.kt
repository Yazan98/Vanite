package io.vanite.android.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import io.vanite.android.models.ui.VaniteNotificationDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created By : Yazan Tarifi
 * Date : 12/26/2019
 * Time : 9:51 PM
 */

class VaniteNotificationController {

    suspend fun createChannel(name: String, description: String, id: String, context: Context) {
        withContext(Dispatchers.IO) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val importance = NotificationManager.IMPORTANCE_HIGH
                val channel = NotificationChannel(id, name, importance)
                channel.description = description
                val notificationManager = context.getSystemService(NotificationManager::class.java)
                notificationManager?.createNotificationChannel(channel)
            }
        }
    }

    //NotificationManager.HIGH
    suspend fun createChannelWithImportance(
        name: String,
        description: String,
        id: String,
        context: Context,
        importance: Int
    ) {
        withContext(Dispatchers.IO) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(id, name, importance)
                channel.description = description
                val notificationManager = context.getSystemService(NotificationManager::class.java)
                notificationManager?.createNotificationChannel(channel)
            }
        }
    }

    suspend fun createMultiNotificationChannels(
        data: List<VaniteNotificationDetails>,
        context: Context
    ) {
        withContext(Dispatchers.IO) {
            data.forEach {
                createChannel(it.name, it.description, it.id, context)
            }
        }
    }

    suspend fun disableNotificationChannel(context: Context, id: String) {
        withContext(Dispatchers.IO) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
                val notificationChannel =
                    notificationManager?.getNotificationChannel(id)
                val importance = notificationChannel?.importance
                if (importance != null) {
                    if (importance < NotificationManager.IMPORTANCE_HIGH && importance > 0) {
                        notificationChannel.importance = NotificationManager.IMPORTANCE_LOW
                    }
                }
            }
        }
    }

}