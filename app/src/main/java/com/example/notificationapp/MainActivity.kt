package com.example.notificationapp

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notificationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.high.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID1)
            notification.setContentTitle(binding.eText1.text.toString())
            notification.setContentText(binding.eText2.text.toString())
            notification.setSmallIcon(R.drawable.high)
                notification.setPriority(NotificationCompat.PRIORITY_HIGH).build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1, notification.build())
        }

        binding.low.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID2)
            notification.setContentTitle(binding.eText1.text.toString())
            notification.setContentText(binding.eText2.text.toString())
            notification.setSmallIcon(R.drawable.low)
            notification.setPriority(NotificationCompat.PRIORITY_DEFAULT).build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2, notification.build())
        }
    }
}