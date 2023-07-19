package com.example.afinal;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView nameTextView;
    private TextView nameText;
    private Dialog smallDialog;
    private TextView projectit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);


        ImageView full = findViewById(R.id.full);
        ImageView mypage = findViewById(R.id.mypage);
        full.setOnClickListener(this);
        mypage.setOnClickListener(this);

        nameTextView = findViewById(R.id.nameTextView);
        nameText = findViewById(R.id.nameText);

        // Main 화면에서 전달된 이름을 받아오는 코드
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");


        // 모집글 작성 버튼 누르면 작은 화면 뜨도록
        Button showSmallScreenButton = findViewById(R.id.roundButton);
        showSmallScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSmallScreen();
            }
        });

        projectit = findViewById(R.id.projectit);
        projectit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.full) {
            Intent intent = new Intent(MainActivity.this, FullActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.mypage) {
            Intent intent = new Intent(MainActivity.this, MyActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.projectit) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
        }
    }

    private void showSmallScreen() {
        smallDialog = new Dialog(this);
        smallDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        smallDialog.setContentView(R.layout.smallscreen);
        smallDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams layoutParams = smallDialog.getWindow().getAttributes();
        layoutParams.dimAmount = 0.5f;
        smallDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        smallDialog.getWindow().setAttributes(layoutParams);

        // 종료 버튼
        Button closeButton = smallDialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeSmallScreen();
            }
        });

        Button completeButton = smallDialog.findViewById(R.id.complete);
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completeSmallScreen();
            }
        });

        smallDialog.show();
    }

    private void closeSmallScreen() {
        if (smallDialog != null && smallDialog.isShowing()) {
            smallDialog.dismiss();
        }
    }

    public void completeSmallScreen() {
        EditText nameEditText = smallDialog.findViewById(R.id.name);
        EditText introduceEditText = smallDialog.findViewById(R.id.introduce);
        EditText endEditText = smallDialog.findViewById(R.id.end);
        EditText timeEditText = smallDialog.findViewById(R.id.time);
        EditText peopleEditText = smallDialog.findViewById(R.id.people);

        String name = nameEditText.getText().toString();
        String introduce = introduceEditText.getText().toString();
        String end = endEditText.getText().toString();
        String time = timeEditText.getText().toString();
        String people = peopleEditText.getText().toString();

        Intent intent = new Intent(MainActivity.this, StateActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("introduce", introduce);
        intent.putExtra("end", end);
        intent.putExtra("time", time);
        intent.putExtra("people", people);
        startActivity(intent);

        closeSmallScreen();
    }
}

