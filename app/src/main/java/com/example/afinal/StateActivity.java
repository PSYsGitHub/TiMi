package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StateActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView nameTextView, introduceTextView, endTextView, timeTextView, peopleTextView;
    private String name1, introduce, end, time, people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statepage);

        ImageView home = findViewById(R.id.home);
        ImageView full = findViewById(R.id.full);
        ImageView arrow = findViewById(R.id.arrow);
        home.setOnClickListener(this);
        full.setOnClickListener(this);
        arrow.setOnClickListener(this);

        nameTextView = findViewById(R.id.nameTextView);
        introduceTextView = findViewById(R.id.introduceTextView);
        endTextView = findViewById(R.id.endTextView);
        timeTextView = findViewById(R.id.timeTextView);
        peopleTextView = findViewById(R.id.peopleTextView);

        // 전달받은 Intent 가져오기
        Intent intent = getIntent();

        // 각각의 값을 가져와 TextView에 설정
        String name1 = intent.getStringExtra("name");
        String introduce = intent.getStringExtra("introduce");
        String end = intent.getStringExtra("end");
        String time = intent.getStringExtra("time");
        String people = intent.getStringExtra("people");

        nameTextView.setText(name1);
        introduceTextView.setText(introduce);
        endTextView.setText(end);
        timeTextView.setText(time);
        peopleTextView.setText(people);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home) {
            Intent intent = new Intent(StateActivity.this, MainActivity.class);
            intent.putExtra("name", name1);
            intent.putExtra("introduce", introduce);
            intent.putExtra("end", end);
            intent.putExtra("time", time);
            intent.putExtra("people", people);
            startActivity(intent);
        } else if (v.getId() == R.id.full) {
            Intent intent = new Intent(StateActivity.this, FullActivity.class);
            intent.putExtra("name", name1);
            intent.putExtra("introduce", introduce);
            intent.putExtra("end", end);
            intent.putExtra("time", time);
            intent.putExtra("people", people);
            startActivity(intent);
        }
        else if (v.getId() == R.id.arrow) {
            Intent intent = new Intent(StateActivity.this, MyActivity.class);
            startActivity(intent);
        }
    }
}

