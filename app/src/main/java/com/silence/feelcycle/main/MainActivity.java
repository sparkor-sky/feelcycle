package com.silence.feelcycle.main;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;
import com.silence.feelcycle.R;
import com.silence.feelcycle.booking.BookingListFragment;
import com.silence.feelcycle.mapfragment.MapFragment;
import com.silence.feelcycle.selfsetting.MyWalletActivity;
import com.silence.feelcycle.selfsetting.SettingActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int isMap=0;
    TextView text_map=null;
    TextView text_list=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        ImageView imageView=findViewById(R.id.head_picture);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //浮动按钮点击函数
        findViewById(R.id.fab).setOnClickListener(v->Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar.setNavigationIcon(R.drawable.ic_menu_send);
        navigationView.setNavigationItemSelectedListener(this);
        text_list=findViewById(R.id.text_switch_list);
        text_map=findViewById(R.id.text_switch_map);
        text_map.setOnClickListener(v->switchToMap());
        text_list.setOnClickListener(v->switchToList());
        switchToMap();
    }

    public void switchToMap(){
        if(isMap==0){
            isMap=1;//设置当前为地图界面
            text_map.setTextColor(Color.parseColor("#3fa0e4"));//替换输入文字颜色
            text_list.setTextColor(Color.parseColor("#ffffff"));//替换地图文字颜色
            MapFragment map=new MapFragment();//替换下面的Frgment
            getFragmentManager().beginTransaction().replace(R.id.frame_content, map).commit();
        }
        else {;//如果不是地图点击了没有任何响应
        }
    }
    public void switchToList(){
        if(isMap==1){
            isMap=0;//设置当前为输入状态
            text_list.setTextColor(0xff3fa0e4);//改变字体颜色
            text_map.setTextColor(Color.parseColor("#ffffff"));//改变字体颜色
            BookingListFragment input=new BookingListFragment();//替换下面的Fragment
            getFragmentManager().beginTransaction().replace(R.id.frame_content,input).commit();
        }else{}
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_health_data) {
            // Handle the camera action
        } else if (id == R.id.nav_wallet) {
            Intent intent=new Intent(MainActivity.this, MyWalletActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_vip) {

        } else if (id == R.id.nav_course) {

        } else if (id == R.id.nav_setting) {
            Intent intent=new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_exit) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

