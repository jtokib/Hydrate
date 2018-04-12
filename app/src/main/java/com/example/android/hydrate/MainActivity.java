package com.example.android.hydrate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double waterCounter = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcWaterNeeded (View view) {
        //Get the weight use entered
        EditText weight = (EditText) findViewById(R.id.weight);
        String waterNeed = weight.getText().toString();
        //Check if the weight is less than 0lbs
        if( Integer.parseInt(waterNeed) < 0 ) {
            Toast.makeText(this, "You must be over 0 lbs to use this app", Toast.LENGTH_SHORT).show();
        }
        //Convert weight to an int and divide by two to get recommended water intake
        int waterNeeded = Integer.parseInt(waterNeed)/2;

        displayWaterNeeded(waterNeeded);
    }

    private void displayWaterNeeded (int ouncesNeeded) {
        TextView waterNeeded = (TextView) findViewById(R.id.water_needed);
        waterNeeded.setText(String.valueOf(ouncesNeeded));
    }

    private void displayWaterDrank (double ounces) {
        TextView waterCounter = (TextView) findViewById(R.id.water_counter);
        waterCounter.setText(String.valueOf(ounces));
    }


    public void smallWater(View view) {
        waterCounter += 8;
        displayWaterDrank(waterCounter);
    }

    public void mediumWater(View view) {
        waterCounter += 16.9;
        displayWaterDrank(waterCounter);
    }

    public void largeWater(View view) {
        waterCounter += 33.8;
        displayWaterDrank(waterCounter);
    }

    public void resetWeight(View view) {
        //Resets EditText
        EditText weight = (EditText) findViewById(R.id.weight);
        weight.setText(null);
        displayWaterNeeded(0);
    }

    public void resetCounter(View view) {
        waterCounter = 0;
        displayWaterDrank(waterCounter);
    }
}
