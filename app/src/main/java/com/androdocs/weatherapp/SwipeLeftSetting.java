package com.androdocs.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.widget.RelativeLayout;
import com.androdocs.weatherapp.Gestures.OnSwipeTouchListener;

public class SwipeLeftSetting extends AppCompatActivity {

    RelativeLayout tvSwipeMe;
    ToggleButton ImpSwitch = null, ThaiSwitch = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_left_setting);

        //SetUp View & Gesture
        tvSwipeMe = findViewById(R.id.tvSwipeMe);
        tvSwipeMe.setOnTouchListener(new MyOnSwipeTouchListener(this));
        //Setting Switch Stuff
        ImpSwitch =  findViewById(R.id.ImperialSwitch);
        ImpSwitch.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                }
                else {

                }
            }
        });
        ThaiSwitch =  findViewById(R.id.ThaiLanguageSwitch);
        ThaiSwitch.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {

                }
                else {

                }
            }
        });
    }

    private class MyOnSwipeTouchListener extends OnSwipeTouchListener {
        public MyOnSwipeTouchListener(Context c) {
            super(c);
        }

        @Override
        public void onSwipeLeft() {
            Intent i = new Intent(SwipeLeftSetting.this, MainActivity.class);
            startActivity(i);
        }
    }
}
