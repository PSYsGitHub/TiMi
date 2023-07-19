package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);

        Button login = (Button) findViewById(R.id.login);
        ImageView google = (ImageView) findViewById(R.id.google);
        ImageView naver = (ImageView) findViewById(R.id.naver);
        ImageView kakao = (ImageView) findViewById(R.id.kakao);
        login.setOnClickListener(this);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Google 이미지뷰 클릭 시 처리할 동작
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);}});

        naver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naver 이미지뷰 클릭 시 처리할 동작
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);}});

        kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kakao 이미지뷰 클릭 시 처리할 동작
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);}});
    }

    public void onClick (View v){
        EditText editText = findViewById(R.id.id);
        EditText editText2 = findViewById(R.id.password);
        String enteredText = editText.getText().toString();
        String enteredText2 = editText2.getText().toString();

        if (enteredText.equals("android") && enteredText2.equals("000000")) {
            Intent intent = new Intent(FirstActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(FirstActivity.this, "입력한 내용이 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}