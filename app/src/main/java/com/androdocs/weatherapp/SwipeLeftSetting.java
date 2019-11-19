package com.androdocs.weatherapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

import com.androdocs.weatherapp.Gestures.OnSwipeTouchListener;

public class SwipeLeftSetting extends AppCompatActivity {
    RelativeLayout tvSwipeMe;
    ToggleButton ImpSwitch, ThaiSwitch;
    Button ButtonCurLoc, ButtonManLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_left_setting);
        initMembers();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initMembers();
    }

    //Swipe Listener
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

    //Init the rest
    private void initMembers() {
        //SetUp View & Gesture
        tvSwipeMe = findViewById(R.id.tvSwipeMe);
        tvSwipeMe.setOnTouchListener(new MyOnSwipeTouchListener(this));

        //Setting Switch Stuff
        SharedPreferences sharedPrefs = getSharedPreferences("com.androdocs.weatherapp", MODE_PRIVATE);

        ImpSwitch =  findViewById(R.id.ImperialSwitch);
        ImpSwitch.setChecked(sharedPrefs.getBoolean("UnitPrefImp", false));
        ImpSwitch.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    All_API_Keyword.UNIT = "imperial";
                    SharedPreferences.Editor editor = getSharedPreferences("com.androdocs.weatherapp", MODE_PRIVATE).edit();
                    editor.putBoolean("UnitPrefImp", true);
                    editor.apply();
                }
                else {
                    All_API_Keyword.UNIT = "metric";
                    SharedPreferences.Editor editor = getSharedPreferences("com.androdocs.weatherapp", MODE_PRIVATE).edit();
                    editor.putBoolean("UnitPrefImp", false);
                    editor.apply();
                }
            }
        });
        ThaiSwitch =  findViewById(R.id.ThaiLanguageSwitch);
        ThaiSwitch.setChecked(sharedPrefs.getBoolean("LanguagePrefThai", false));
        ThaiSwitch.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    All_API_Keyword.LANGUAGE = "THAI";
                    SharedPreferences.Editor editor = getSharedPreferences("com.androdocs.weatherapp", MODE_PRIVATE).edit();
                    editor.putBoolean("LanguagePrefThai", true);
                    editor.apply();
                }
                else {
                    All_API_Keyword.LANGUAGE = "ENGLISH";
                    SharedPreferences.Editor editor = getSharedPreferences("com.androdocs.weatherapp", MODE_PRIVATE).edit();
                    editor.putBoolean("LanguagePrefThai", false);
                    editor.apply();
                }
            }
        });
        ButtonCurLoc = findViewById(R.id.ButtonCurrentLocation);
        ButtonCurLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DoIt(v);
            }
        });
        ButtonManLoc = findViewById(R.id.ButtonManualLocation);
        ButtonManLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DoIt(v);
            }
        });
    }
}
