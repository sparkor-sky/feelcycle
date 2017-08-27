package com.silence.feelcycle.entrance

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.silence.feelcycle.R
import com.silence.feelcycle.main.MainActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent=Intent(this, MainActivity::class.java)
        findViewById<Button>(R.id.bt_login).setOnClickListener { v ->startActivity(intent)  }
    }
}
