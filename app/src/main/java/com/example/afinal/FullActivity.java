package com.example.afinal;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class FullActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView it;
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullpage);

        ImageView home = findViewById(R.id.home);
        ImageView mypage = findViewById(R.id.mypage);
        it = findViewById(R.id.it);  // it 변수에 멤버 변수로 할당
        test = findViewById(R.id.test);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullActivity.this, MyActivity.class);
                startActivity(intent);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭 시 폰트 및 스타일 변경
                changeTextStyle();

                View project1Layout = findViewById(R.id.project1);
                project1Layout.setVisibility(View.VISIBLE);
                View project2Layout = findViewById(R.id.project2);
                project2Layout.setVisibility(View.VISIBLE);
                // 기존의 다른 View들은 화면에서 감추기 위해 보이지 않도록 설정
                View project3Layout = findViewById(R.id.project3);
                project3Layout.setVisibility(View.GONE);
                View project4Layout = findViewById(R.id.project4);
                project4Layout.setVisibility(View.GONE);
                View project5Layout = findViewById(R.id.project5);
                project5Layout.setVisibility(View.GONE);
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭 시 폰트 및 스타일 변경
                changeTextStyle2();

                View project1Layout = findViewById(R.id.project1);
                project1Layout.setVisibility(View.VISIBLE);
                View project2Layout = findViewById(R.id.project2);
                project2Layout.setVisibility(View.VISIBLE);
                View project3Layout = findViewById(R.id.project3);
                project3Layout.setVisibility(View.VISIBLE);
                // 기존의 다른 View들은 화면에서 감추기 위해 보이지 않도록 설정
                View project4Layout = findViewById(R.id.project4);
                project4Layout.setVisibility(View.GONE);
                View project5Layout = findViewById(R.id.project5);
                project5Layout.setVisibility(View.GONE);
            }
        });
    }

    private void changeTextStyle() {
        Typeface font = ResourcesCompat.getFont(this, R.font.c);
        Typeface font_a = ResourcesCompat.getFont(this, R.font.a);
        it.setTypeface(font);
        it.setTextColor(Color.parseColor("#7165FF"));
        test.setTypeface(font_a);
        test.setTextColor(Color.parseColor("#000000"));
    }
    private void changeTextStyle2() {
        Typeface font = ResourcesCompat.getFont(this, R.font.c);
        Typeface font_a = ResourcesCompat.getFont(this, R.font.a);
        test.setTypeface(font);
        test.setTextColor(Color.parseColor("#7165FF"));
        it.setTypeface(font_a);
        it.setTextColor(Color.parseColor("#000000"));
    }

    @Override
    public void onClick(View v) {

    }
}


