package com.androdocs.weatherapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

import com.androdocs.weatherapp.Gestures.OnSwipeTouchListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SwipeLeftSetting extends AppCompatActivity {
    double latitude, longitude;
    String LocName;

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

    private void searchByCityName() {
        android.app.AlertDialog.Builder alert = new android.app.AlertDialog.Builder(this, R.style.AlertDialog);
        alert.setTitle(this.getString(R.string.search_title));
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setMaxLines(1);
        input.setSingleLine(true);
        alert.setView(input);
        alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String result = input.getText().toString();
                if (!result.isEmpty()) {
                    System.out.println(result);
                    All_API_Keyword.CITY = result;
                }
            }
        });
        alert.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Cancelled
            }
        });
        alert.show();
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
                Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
                List<Address> addresses = null;
                try {
                    addresses = gcd.getFromLocation(latitude, longitude, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (addresses.size() > 0) {
                    LocName = addresses.get(0).getLocality(); //+","+addresses.get(0).getCountryCode();
                    System.out.println(LocName);

                    if (LocName != null) All_API_Keyword.CITY = LocName;
                }
                else {
                    //Placeholder Text until the System is fixed
                    System.out.println("Placeholder Location, please remove this on release");
                    All_API_Keyword.CITY = "Lat Krabang,th";
                }
            }
        });
        ButtonManLoc = findViewById(R.id.ButtonManualLocation);
        ButtonManLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchByCityName();
            }
        });
    }
}
