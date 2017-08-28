package com.silence.feelcycle.selfsetting;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;
import com.silence.feelcycle.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PersonalInformationActivity extends AppCompatActivity {
    //性别的spinner
    private Spinner sex_spinner;
    private List<String> sex_data_list;
    private ArrayAdapter<String> sex_arr_adapter;

    //HomeAsUp按钮
    ActionBar actionBar;
    //显示生日的TextView
    TextView brithText;
    //显示城市的TextView
    TextView cityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        init();//初始化的方法
    }

    private void init() {
        //HomeAsUp 按钮
        actionBar = getSupportActionBar();
        //HomeAsUp 按钮
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //性别spinner
        sex_spinner = (Spinner) findViewById(R.id.sex_spinner);
        //数据
        sex_data_list = new ArrayList<String>();
        sex_data_list.add("男");
        sex_data_list.add("女");
        sex_data_list.add("保密");
        //适配器
        sex_arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sex_data_list);

        sex_arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sex_data_list);

        //设置样式
        sex_arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        sex_spinner.setAdapter(sex_arr_adapter);


        //生日文本和监听器
        brithText = (TextView) findViewById(R.id.birthday_text);
        brithText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog();
            }
        });
        //城市文本
        cityText = (TextView) findViewById(R.id.city_text);
        cityText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCityDialog();
            }
        });
    }

    //显示城市的对话框
    private void showCityDialog() {

    }

    //显示选择生日的对话框
    private void showDataDialog() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(PersonalInformationActivity.this, AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // TODO Auto-generated method stub
                int mYear = year;
                int mMonth = month;
                int mDay = day;
                //更新EditText控件日期 小于10加0
                brithText.setText(new StringBuilder()
                        .append(mYear)
                        .append("-")
                        .append((mMonth + 1) < 10 ? 0 + (mMonth + 1) : (mMonth + 1))
                        .append("-")
                        .append((mDay < 10) ? 0 + mDay : mDay));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        //设置时间范围 截止到目前
        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        datePickerDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personal_information_actionbar_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            //保存按钮的监听
            case R.id.action_save:
                Toast.makeText(getApplicationContext(),"已保存",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
        return true;
    }

}
