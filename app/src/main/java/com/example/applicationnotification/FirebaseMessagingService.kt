package com.example.applicationnotification

import android.util.Log
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.FirebaseMessagingService

class FirebaseMessagingService : FirebaseMessagingService() {

    private val tag = "FirebaseMessagingServ"
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.i(tag, remoteMessage.from.toString())

        //mostra notificação recebida pelo servidor
        if (remoteMessage.notification != null){
            this.showNotification("1234", remoteMessage.notification?.title.toString(), remoteMessage.notification?.body.toString())
        }
    }

}