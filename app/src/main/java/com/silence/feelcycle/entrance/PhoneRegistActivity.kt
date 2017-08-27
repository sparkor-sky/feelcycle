package com.silence.feelcycle.entrance

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.silence.feelcycle.R

class PhoneRegistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_regist)
        val intent= Intent(this,LoginActivity::class.java)
        findViewById<Button>(R.id.bt_submit_regist).setOnClickListener { v ->startActivity(intent)  }
    }
}
