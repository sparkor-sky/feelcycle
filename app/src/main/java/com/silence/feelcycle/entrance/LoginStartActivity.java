package com.silence.feelcycle.entrance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.silence.feelcycle.R;

import static android.graphics.Paint.UNDERLINE_TEXT_FLAG;
import static java.awt.font.TextAttribute.UNDERLINE;

public class LoginStartActivity extends AppCompatActivity {
    Button login;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_start);
        itit();

    }

    @SuppressLint("ClickableViewAccessibility")
    private void itit() {
        //注册
        register = (Button) findViewById(R.id.bt_to_regist);
        register.setOnClickListener(      //注册按钮监听
                v->startActivity(new Intent(LoginStartActivity.this,RegistActivity.class)));
        register.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//添加下划线
        //登录
        login = (Button) findViewById(R.id.bt_phone_login);
        login.setOnClickListener(    //登录按钮监听
                v->startActivity(new Intent(LoginStartActivity.this,LoginActivity.class)));
        login.setOnTouchListener((v, event) -> {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                v.setBackgroundResource(R.drawable.button_onclick_login);
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                v.setBackgroundResource(R.drawable.button_login);
            }
            return false;
        });
    }
}
