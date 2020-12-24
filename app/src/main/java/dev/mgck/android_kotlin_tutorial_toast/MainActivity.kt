package dev.mgck.android_kotlin_tutorial_toast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_toast).setOnClickListener{
            startActivity(Intent(this, ToastActivity::class.java)) }

        findViewById<View>(R.id.btn_snackbar).setOnClickListener{
            startActivity(Intent(this, SnackBarActivity::class.java)) }

        findViewById<View>(R.id.btn_dialog).setOnClickListener{
            startActivity(Intent(this, DialogActivity::class.java)) }

        findViewById<View>(R.id.btn_notification).setOnClickListener{
            startActivity(Intent(this, NotificantionActivity::class.java)) }
    }
}