package com.androdocs.weatherapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SwipeRight5Days extends AppCompatActivity {

    float x1,x2,y1,y2;

    // COMPLETED (1) Create a field to store the weather display TextView
    private TextView mWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_right5_days);

        // COMPLETED (2) Use findViewById to get a reference to the weather display TextView
        mWeatherTextView = (TextView) findViewById(R.id.tv_weather_data);

        // COMPLETED (3) Create an array of Strings that contain fake weather data
        String[] dummyWeatherData = {
                "Today, May 17 - Clear - 17°C / 15°C",
                "Tomorrow - Cloudy - 19°C / 15°C",
                "Thursday - Rainy- 30°C / 11°C",
                "Friday - Thunderstorms - 21°C / 9°C",
                "Saturday - Thunderstorms - 16°C / 7°C",
                "Sunday - Rainy - 16°C / 8°C",
                "Monday - Partly Cloudy - 15°C / 10°C",
                "Tue, May 24 - Meatballs - 16°C / 18°C",
                "Wed, May 25 - Cloudy - 19°C / 15°C",
                "Thu, May 26 - Stormy - 30°C / 11°C",
                "Fri, May 27 - Hurricane - 21°C / 9°C",
                "Sat, May 28 - Meteors - 16°C / 7°C",
                "Sun, May 29 - Apocalypse - 16°C / 8°C",
                "Mon, May 30 - Post Apocalypse - 15°C / 10°C",
        };

        // TODO (4) Append each String from the fake weather data array to the TextView
        for(String dummyWeatherDay: dummyWeatherData){
            mWeatherTextView.append(dummyWeatherDay + "\n\n\n");
        }


    }

    @Override
    public boolean onTouchEvent( MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 <= x2){
                    Intent i = new Intent(SwipeRight5Days.this, MainActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}
