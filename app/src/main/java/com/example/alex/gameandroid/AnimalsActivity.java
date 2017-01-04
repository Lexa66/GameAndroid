package com.example.alex.gameandroid;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.media.MediaPlayer.*;

public class AnimalsActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animals);

        View animalButton1 = findViewById(R.id.animalButton1);
        View animalButton2 = findViewById(R.id.animalButton2);
        View animalButton3 = findViewById(R.id.animalButton3);
        View animalButton4 = findViewById(R.id.animalButton4);
        View animalButton5 = findViewById(R.id.animalButton5);
        View animalButton6 = findViewById(R.id.animalButton6);
        View animalButton7 = findViewById(R.id.animalButton7);
        View animalButton8 = findViewById(R.id.animalButton8);
        View animalButton9 = findViewById(R.id.animalButton9);
        View animalButton10 = findViewById(R.id.animalButton10);
        View animalButton11 = findViewById(R.id.animalButton11);
        View animalButton12 = findViewById(R.id.animalButton12);

        animalButton1.setOnClickListener(this);
        animalButton2.setOnClickListener(this);
        animalButton3.setOnClickListener(this);
        animalButton4.setOnClickListener(this);
        animalButton5.setOnClickListener(this);
        animalButton6.setOnClickListener(this);
        animalButton7.setOnClickListener(this);
        animalButton8.setOnClickListener(this);
        animalButton9.setOnClickListener(this);
        animalButton10.setOnClickListener(this);
        animalButton11.setOnClickListener(this);
        animalButton12.setOnClickListener(this);
    }

    int iClicked = 0;

    @Override
    public void onClick(View v) {

        // Play only one sound at a time
        if (mp != null) mp.release();

        // Find which ImageButton was pressed and take appropriate action

        switch (v.getId()) {

            // The tiger button
            case R.id.animalButton1:
                iClicked++;
                if (iClicked % 2 == 0) {
                    //  play sound I
                    mp = create(this, R.raw.tiger_1);
                } else { // play sound II
                    mp = create(this, R.raw.tiger_2);
                }
                break;

            // The monkey button
            case R.id.animalButton2:
                iClicked++;
                if (iClicked % 2 == 0) {
                    //  play sound I
                    mp = create(this, R.raw.monkey_1);
                } else { // play sound II
                    mp = create(this, R.raw.monkey_2);
                }
                break;

            // The elephant button
            case R.id.animalButton3:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.elephant_1);
                } else {
                    mp = create(this, R.raw.elephant_2);
                }
                break;

            // The frog button
            case R.id.animalButton4:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.frog_1);
                } else {
                    mp = create(this, R.raw.frog_2);
                }
                break;

            // The pig button
            case R.id.animalButton5:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.pig_1);
                } else {
                    mp = create(this, R.raw.pig_2);
                }
                break;

            // The horse button
            case R.id.animalButton6:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.horse_1);
                } else {
                    mp = create(this, R.raw.horse_2);
                }
                break;

            // The cat button
            case R.id.animalButton7:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.cat_1);
                } else {
                    mp = create(this, R.raw.cat_2);
                }
                break;

            // The sheep button
            case R.id.animalButton8:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.sheep_1);
                } else {
                    mp = create(this, R.raw.sheep_2);
                }
                break;

            // The dog button
            case R.id.animalButton9:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.dog_1);
                } else {
                    mp = create(this, R.raw.dog_2);
                }
                break;

            // The chicken button
            case R.id.animalButton10:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.chicken_1);
                } else {
                    mp = create(this, R.raw.chicken_2);
                }
                break;

            // The cow button
            case R.id.animalButton11:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.cow_1);
                } else {
                    mp = create(this, R.raw.cow_2);
                }
                break;

            // The lion button
            case R.id.animalButton12:
                iClicked++;
                if (iClicked % 2 == 0) {
                    mp = create(this, R.raw.lion_1);
                } else {
                    mp = create(this, R.raw.lion_2);
                }
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
