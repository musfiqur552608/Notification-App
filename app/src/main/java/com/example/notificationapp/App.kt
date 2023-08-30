package com.example.notificationapp

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application(){
    final private val CHANNEL_ID1 = "CHANNEL_ID1"
    final private val CHANNEL_ID2 = "CHANNEL_ID2"
    override fun onCreate() {
        super.onCreate()
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID1,"Channel 1", NotificationManager.IMPORTANCE_HIGH)
            channel.description = "This my high importance channel for notification"
            val channel2 = NotificationChannel(CHANNEL_ID2,"Channel 2", NotificationManager.IMPORTANCE_DEFAULT)
            channel2.description = "This my default importance channel for notification"

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            val list = ArrayList<Notification>()
            manager.createNotificationChannel(channel)
            manager.createNotificationChannel(channel2)
        }
    }
}