package com.example.applicationnotification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat.IMPORTANCE_HIGH
import androidx.core.content.getSystemService

lateinit var notificationChannel: NotificationChannel
lateinit var notificationManager : NotificationManager
lateinit var builder: NotificationCompat.Builder

fun Context.showNotification(channelId: String, title: String, body: String) {

    //gerencia todas as notificações responsaveis pelo app
    notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    //responsavel pelo evento de click da notificação
    val intent = Intent(this, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        notificationChannel = NotificationChannel(channelId, body, NotificationManager.IMPORTANCE_HIGH).apply {
            lightColor = Color.BLUE //modifica luz do celular da notificação
            enableVibration(true) //vibra o celular ao chegar notificação
        }

        notificationManager.createNotificationChannel(notificationChannel)
        builder = NotificationCompat.Builder(this, channelId).apply {
            setSmallIcon(R.drawable.ic_refresh)
            setContentTitle(title)
            setContentText(body)
            setAutoCancel(true)
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
            setContentIntent(pendingIntent)
        }

        notificationManager.notify(channelId.toInt(), builder.build())

    }

}