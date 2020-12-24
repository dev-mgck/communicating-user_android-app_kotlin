package dev.mgck.android_kotlin_tutorial_toast

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NotificationResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_result)

        // When launched from an addAction Intent, we must manually cancel
        // the notification otherwise it will stay in the status bar
        val intent = intent
        val notifyID = intent.getIntExtra("notifyID", 0)

        val mgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mgr.cancel(notifyID)
    }
}