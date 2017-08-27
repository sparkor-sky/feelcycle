package com.silence.feelcycle.entrance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.silence.feelcycle.R;

public class LoginStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_start);
        findViewById(R.id.bt_phone_login).setOnClickListener(    //登录按钮监听
                v->startActivity(new Intent(LoginStartActivity.this,LoginActivity.class)));
        findViewById(R.id.bt_to_regist).setOnClickListener(      //注册按钮监听
                v->startActivity(new Intent(LoginStartActivity.this,RegistActivity.class)));

    }
}
