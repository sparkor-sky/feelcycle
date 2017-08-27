package com.silence.feelcycle.entrance

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.silence.feelcycle.R

class CodeGetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codeget)
        var intent= Intent(this,PhoneRegistActivity::class.java)
        findViewById<Button>(R.id.bt_codeget).setOnClickListener { v ->startActivity(intent)  }
    }
}
