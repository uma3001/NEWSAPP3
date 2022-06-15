package com.example.newsapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId = "notification"
const val channelName = "com.example.newsapp"
@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if(remoteMessage.getNotification()!=null)
            generateNotification(remoteMessage.notification!!.title!!,remoteMessage.notification!!.body!!)
        Log.d("TAG",remoteMessage.notification!!.title!!)
    }

    fun getRemoteview(title: String,message: String):RemoteViews{
        val remoteView = RemoteViews("com.example.newsapp",R.layout.notification)

        remoteView.setTextViewText(R.id.notify_tittle,title)
        remoteView.setTextViewText(R.id.description,message)
        remoteView.setTextViewText(R.id.logo, R.drawable.logo.toString())

        return remoteView
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    fun generateNotification(title:String, message:String){

        val intent = Intent(this, News::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_ONE_SHOT)

        var builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext,
            channelId)
            .setSmallIcon(R.drawable.logo)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteview(title,message))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(channelId, channelName,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }
        notificationManager.notify(1,builder.build())
    }
}