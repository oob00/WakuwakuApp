package com.example.wakuwakuapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.wakuwakuapp.chat.ChatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.chatBtn)
        button.setOnClickListener {
            val intent = Intent(applicationContext, ChatActivity::class.java)
            startActivity(intent)
        }
    }
}