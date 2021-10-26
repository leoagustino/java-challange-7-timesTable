package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablesListView;

    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int j = 1; j<= 100; j++){
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTablesListView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final  SeekBar timeTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTablesListView   = findViewById(R.id.timesTablesListView);

        SeekBar timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        ListView timesTablesListView = findViewById(R.id.timesTablesListView);
        int max = 20;
        int startingPosition = 10;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timeTableNumber;

                if (i < min) {
                    timeTableNumber = min;
                    timesTablesSeekBar.setProgress((min));
                } else {
                    timeTableNumber = i;
                }
                Log.i("Seekbar Value", Integer.toString(timeTableNumber));
                ArrayList<String> timesTableContent = new ArrayList<String>();
                generateTimesTable(timeTableNumber);
            }
//                for (int j = 1; j<= 10; j++){
//                    timesTableContent.add(Integer.toString(j * timesTableNumber)
//                }
//                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
//                timesTablesListView.setAdapter(arrayAdapter);
//            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
