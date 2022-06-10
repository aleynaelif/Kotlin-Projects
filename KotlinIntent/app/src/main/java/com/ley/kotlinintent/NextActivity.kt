package com.ley.kotlinintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        //get intent

        val intent = intent
        val username = intent.getStringExtra("username")
        val name = intent.getStringExtra("name")

        nextUsername.text = "Username: " + username
        nextName.text = "Name: " + name
    }
}