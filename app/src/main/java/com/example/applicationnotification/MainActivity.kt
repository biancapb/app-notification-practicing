package com.example.applicationnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.iid.FirebaseInstanceId

class MainActivity : AppCompatActivity() {

    lateinit var buttonSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSend = findViewById(R.id.button_send_notification)
        buttonSend.setOnClickListener {
            this.showNotification("1234", "Bootcamp ANDROID", "Kotlin Developer")
        }

        Log.i("--newToken", FirebaseInstanceId.getInstance().token.toString())
    }
}