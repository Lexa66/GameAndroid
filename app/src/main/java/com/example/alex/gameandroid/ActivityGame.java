package com.example.alex.gameandroid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.*;

public class ActivityGame extends AppCompatActivity implements ImageButton.OnClickListener {
    private MediaPlayer sound;
    Random random = new Random();
    final Context context = this;
    int winRateCount = 0;
    ImageButton currentWinButton;
    HashMap<View, int[]> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        data = new HashMap<>();
        int[] soundOnButton1 = {R.raw.tiger_1, R.raw.tiger_2};
        int[] soundOnButton2 = {R.raw.monkey_1, R.raw.monkey_2};
        int[] soundOnButton3 = {R.raw.elephant_1, R.raw.elephant_2};
        int[] soundOnButton4 = {R.raw.frog_1, R.raw.frog_2};
        int[] soundOnButton5 = {R.raw.pig_1, R.raw.pig_2};
        int[] soundOnButton6 = {R.raw.horse_1, R.raw.horse_2};
        int[] soundOnButton7 = {R.raw.cat_1, R.raw.cat_2};
        int[] soundOnButton8 = {R.raw.sheep_1, R.raw.sheep_2};
        int[] soundOnButton9 = {R.raw.dog_1, R.raw.dog_2};
        int[] soundOnButton10 = {R.raw.chicken_1, R.raw.chicken_2};
        int[] soundOnButton11 = {R.raw.cow_1, R.raw.cow_2};
        int[] soundOnButton12 = {R.raw.lion_1, R.raw.lion_2};
        data.put(findViewById(R.id.animalButton1), soundOnButton1);
        data.put(findViewById(R.id.animalButton2), soundOnButton2);
        data.put(findViewById(R.id.animalButton3), soundOnButton3);
        data.put(findViewById(R.id.animalButton4), soundOnButton4);
        data.put(findViewById(R.id.animalButton5), soundOnButton5);
        data.put(findViewById(R.id.animalButton6), soundOnButton6);
        data.put(findViewById(R.id.animalButton7), soundOnButton7);
        data.put(findViewById(R.id.animalButton8), soundOnButton8);
        data.put(findViewById(R.id.animalButton9), soundOnButton9);
        data.put(findViewById(R.id.animalButton10), soundOnButton10);
        data.put(findViewById(R.id.animalButton11), soundOnButton11);
        data.put(findViewById(R.id.animalButton12), soundOnButton12);

        game();
    }

    @Override
    public void onClick(View view) {
        ImageButton currentButton = (ImageButton) view;
        if (currentButton.equals(currentWinButton)) {
            winRateCount++;
            game();
        } else {
            winRateCount = 0;
            dialogWindow();
        }
    }

    private void game() {

        // get all buttons, make them gone and set click listener
        for (View v : data.keySet()) {
            v.setVisibility(View.GONE);
            v.setOnClickListener(this);
        }

        // get random winning button
        List<View> keys = new ArrayList<>(data.keySet());
        currentWinButton = (ImageButton) keys.get(random.nextInt(keys.size()));

        // display buttons according to the condition
        LinkedHashSet<ImageButton> currentDataSet = fillDataSet(currentWinButton, checkStep());
        for (ImageButton button : currentDataSet) {
            button.setVisibility(View.VISIBLE);
        }

        // get one of the sounds from the winning button
        int[] value = data.get(currentWinButton);
        int randomSound = value[random.nextInt(value.length)];

        // play this sound
        sound = MediaPlayer.create(getApplicationContext(), randomSound);
        sound.start();
    }

    // filling the set of not recurring buttons
    LinkedHashSet<ImageButton> fillDataSet(ImageButton currentWinButton, int maxSetSize) {
        ImageButton randomButton;

        LinkedHashSet<ImageButton> result = new LinkedHashSet<>();
        result.add(currentWinButton);

        List<View> keys = new ArrayList<>(data.keySet());

        while (result.size() < maxSetSize) {
            randomButton = (ImageButton) keys.get(random.nextInt(keys.size()));
            result.add(randomButton);
        }
        return result;
    }

    // conditions of adding new button
    private int checkStep() {

        if (winRateCount < 3) {
            return 2;
        }

        if (winRateCount >= 3 && winRateCount < 10) {
            return 3;
        } else if (winRateCount >= 10 && winRateCount < 15) {
            return 4;
        } else if (winRateCount >= 15 && winRateCount < 20) {
            return 5;
        } else if (winRateCount == 20) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    context);

            // set title
            alertDialogBuilder.setTitle("Повідомлення");

            // set dialogWindow message
            alertDialogBuilder
                    .setMessage("Гра успішно завершена!")
                    .setCancelable(false)
                    .setPositiveButton("Перейти в головне меню", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int Button) {

                            Intent intent = new Intent(ActivityGame.this, MainActivity.class);
                            startActivity(intent);

                        }
                    });

            // create alert dialogWindow
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
            return 6;
        }
        return 6;
    }

    void dialogWindow() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle("Повідомлення");

        // set dialogWindow message
        alertDialogBuilder
                .setMessage("Неправильно вибрана тварина!")
                .setCancelable(false)
                .setPositiveButton("Спробувати знову", null);

        // create alert dialogWindow
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}