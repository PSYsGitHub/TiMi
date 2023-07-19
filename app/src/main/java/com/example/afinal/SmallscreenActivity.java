package com.example.afinal;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SmallscreenActivity extends AppCompatActivity implements View.OnClickListener{

    private Button complete;
    private EditText name, introduce, end, time, people, hash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smallscreen);

        name = findViewById(R.id.name);
        introduce = findViewById(R.id.introduce);
        end = findViewById(R.id.end);
        time = findViewById(R.id.time);
        people = findViewById(R.id.people);
        hash = findViewById(R.id.hash);
        complete = findViewById(R.id.complete);

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String introduce1 = introduce.getText().toString();
                String end1 = end.getText().toString();
                String time1 = time.getText().toString();
                String people1 = people.getText().toString();
                String hash1 = hash.getText().toString();

                Intent intent = new Intent(SmallscreenActivity.this, MainActivity.class);
                intent.putExtra("name", name1);
                intent.putExtra("introduce", introduce1);
                intent.putExtra("end", end1);
                intent.putExtra("time", time1);
                intent.putExtra("people", people1);
                intent.putExtra("hash", hash1);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
    }
}
