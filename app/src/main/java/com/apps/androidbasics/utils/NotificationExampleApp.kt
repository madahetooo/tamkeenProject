package com.apps.androidbasics.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.apps.androidbasics.R
import kotlinx.android.synthetic.main.activity_notification_example_app.*

class NotificationExampleApp : AppCompatActivity() {
    val CHANNEL_ID = "channel_ID"
    val NOTIFICATION_ID = 0
    val CHANNEL_NAME = "channel_Name"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_example_app)
        createNotificationChannel()

        val intent = Intent(this, NotificationExampleApp::class.java)
        var pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val myNotification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Doctor APP")
            .setContentText("Reminder, Please visit the doctor")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManger = NotificationManagerCompat.from(this)

        btnShowNotification.setOnClickListener {
            notificationManger.notify(NOTIFICATION_ID,myNotification)
        }


    }

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.RED
                enableLights(true)
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

        }
    }
}