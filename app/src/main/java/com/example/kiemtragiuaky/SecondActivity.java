package com.example.kiemtragiuaky;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Second Activity");

        //Lấy dữ liệu
        Intent getintent = getIntent();
        String name = getintent.getStringExtra("NAME");
        String birthday = getintent.getStringExtra("BIRTHDAY");

        //Chuyển đổi birthday sang định dạng ngày/tháng/năm
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date startDate = new Date();
        try {
            startDate = df.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Tính tuổi
        Calendar cal = Calendar.getInstance();
        assert startDate != null;
        cal.setTime(startDate);
        int birthyear = cal.get(Calendar.YEAR);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age = year - birthyear;

        //Ánh xạ
        TextView txtResult = findViewById(R.id.result);
        Button btnBack = findViewById(R.id.backhome);

        //Hiện thông tin
        txtResult.setText(String.format("Tên: %s\nTuổi: %s", name, age));

        //Sự kiện bấm nút BACKHOME quay trở về FirstActivity
        btnBack.setOnClickListener(view -> {
            Intent intent1 = new Intent(SecondActivity.this, FirstActivity.class);
            startActivity(intent1);
        });

    }

}