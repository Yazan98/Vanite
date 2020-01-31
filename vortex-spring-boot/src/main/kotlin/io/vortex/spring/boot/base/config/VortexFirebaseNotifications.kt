package io.vortex.spring.boot.base.config

import com.google.firebase.messaging.*

class VortexFirebaseNotifications {

    fun sendNotification(title: String, body: String) {
        val message = Message.builder()
                .putData("title", title)
                .putData("body", body)
                .setNotification(Notification(title, body))
                .build()
        val response = FirebaseMessaging.getInstance().send(message)
        println("Successfully sent message: $response")
    }

    fun sendNotificationToTopic(title: String, body: String, topic: String) {
        val message = Message.builder()
                .putData("title", title)
                .putData("body", body)
                .setTopic(topic)
                .setNotification(Notification(title, body))
                .build()
        val response = FirebaseMessaging.getInstance().send(message)
        println("Successfully sent message: $response")
    }

}