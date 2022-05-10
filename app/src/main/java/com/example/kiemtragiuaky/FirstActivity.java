package com.example.kiemtragiuaky;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("First Activity");

        //Ánh xạ
        EditText edtName = findViewById(R.id.name);
        EditText edtBirthday = findViewById(R.id.birthday);

        Button btnSubmit = findViewById(R.id.submit);

        //Sự kiện khi ấn vào nút Submit
        btnSubmit.setOnClickListener(view -> {

            //Lấy dữ liệu
            String name = edtName.getText().toString();
            String birthday = edtBirthday.getText().toString();

            //Gửi dữ liệu sang SecondActivity
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("BIRTHDAY", birthday);
            startActivity(intent);

        });
    }

}