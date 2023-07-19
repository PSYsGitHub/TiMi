package com.example.afinal;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MyActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText;

    ImageView imageView;
    String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        ImageView home = findViewById(R.id.home);
        ImageView full = findViewById(R.id.full);
        ImageView prev = findViewById(R.id.prev);


        home.setOnClickListener(this);
        full.setOnClickListener(this);
        prev.setOnClickListener(this);

        imageView = findViewById(R.id.ivProfile);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);}});}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    imageView.setImageURI(uri);
                }
                break;}}

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home) {
            Intent intent = new Intent(MyActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.full) {
            Intent intent = new Intent(MyActivity.this, FullActivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.prev) {
            Intent intent = new Intent(MyActivity.this, StateActivity.class);
            startActivity(intent);
        }
    }
}
