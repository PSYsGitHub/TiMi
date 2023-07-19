package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class OpenActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 일정 시간 후에 다음 화면으로 전환하는 코드
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 다음 화면으로 전환하는 Intent 생성
                Intent intent = new Intent(OpenActivity.this, FirstActivity.class);
                startActivity(intent);
                finish(); // 현재 화면 종료
            }
        }, 3000);

        setContentView(R.layout.openpage);
    }
}
