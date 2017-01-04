package com.example.alex.gameandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnActListening;
    Button btnActQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActListening = (Button) findViewById(R.id.btnActListening);
        btnActListening.setOnClickListener(this);
        btnActQuiz = (Button) findViewById(R.id.btnActQuiz);
        btnActQuiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnActListening:
                Intent intent = new Intent(this, ActivityListening.class);
                startActivity(intent);
                break;
            case R.id.btnActQuiz:
                intent = new Intent(this, ActivityGame.class);
                startActivity(intent);
                break;
        }
    }
}

