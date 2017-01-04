package com.example.alex.gameandroid;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.media.MediaPlayer.*;

public class TransportActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transport);

        View transportButton1 = findViewById(R.id.transportButton1);
        View transportButton2 = findViewById(R.id.transportButton2);
        View transportButton3 = findViewById(R.id.transportButton3);
        View transportButton4 = findViewById(R.id.transportButton4);
        View transportButton5 = findViewById(R.id.transportButton5);
        View transportButton6 = findViewById(R.id.transportButton6);
        View transportButton7 = findViewById(R.id.transportButton7);
        View transportButton8 = findViewById(R.id.transportButton8);
        View transportButton9 = findViewById(R.id.transportButton9);
        View transportButton10 = findViewById(R.id.transportButton10);
        View transportButton11 = findViewById(R.id.transportButton11);
        View transportButton12 = findViewById(R.id.transportButton12);

        transportButton1.setOnClickListener(this);
        transportButton2.setOnClickListener(this);
        transportButton3.setOnClickListener(this);
        transportButton4.setOnClickListener(this);
        transportButton5.setOnClickListener(this);
        transportButton6.setOnClickListener(this);
        transportButton7.setOnClickListener(this);
        transportButton8.setOnClickListener(this);
        transportButton9.setOnClickListener(this);
        transportButton10.setOnClickListener(this);
        transportButton11.setOnClickListener(this);
        transportButton12.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Play only one sound at a time
        if (mp != null) mp.release();

        // Find which ImageButton was pressed and take appropriate action

        switch (v.getId()) {

            case R.id.transportButton1:
                mp = create(this, R.raw.police_car);
                break;

            case R.id.transportButton2:
                mp = create(this, R.raw.ambulance);
                break;

            case R.id.transportButton3:
                mp = create(this, R.raw.fire_engine);
                break;

            case R.id.transportButton4:
                mp = create(this, R.raw.rocket);
                break;

            case R.id.transportButton5:
                mp = create(this, R.raw.airplane);
                break;

            case R.id.transportButton6:
                mp = create(this, R.raw.helicopter);
                break;

            case R.id.transportButton7:
                mp = create(this, R.raw.train);
                break;

            case R.id.transportButton8:
                mp = create(this, R.raw.car);
                break;

            case R.id.transportButton9:
                mp = create(this, R.raw.motorcycle);
                break;

            case R.id.transportButton10:
                mp = create(this, R.raw.bicycle);
                break;

            case R.id.transportButton11:
                mp = create(this, R.raw.ship);
                break;

            case R.id.transportButton12:
                mp = create(this, R.raw.bus);
                break;
        }
        mp.seekTo(0);
        mp.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        // Release the MediaPlayer if going into background if it isn't null
        if (mp != null) mp.release();
    }
}