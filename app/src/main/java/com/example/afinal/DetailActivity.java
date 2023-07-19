package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView commentTextView;
    private EditText commentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailpage);

        ImageView arrow = findViewById(R.id.arrow);
        arrow.setOnClickListener(this);

        ImageView home = findViewById(R.id.home);
        ImageView mypage = findViewById(R.id.mypage);
        ImageView full = findViewById(R.id.full);

        commentTextView = findViewById(R.id.commentTextView);
        commentEditText = findViewById(R.id.commentEditText);
        Button submitCommentButton = findViewById(R.id.submitCommentButton);

        submitCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentEditText.getText().toString();

                String existingComments = commentTextView.getText().toString();
                String newComment = existingComments + "\n" + comment + "\n" ;
                commentTextView.setText(newComment);

                commentEditText.setText("");
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MyActivity.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, FullActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrow) {
            Intent intent = new Intent(DetailActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}

