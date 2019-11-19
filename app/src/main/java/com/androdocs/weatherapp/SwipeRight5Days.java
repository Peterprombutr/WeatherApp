package com.androdocs.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.androdocs.weatherapp.Gestures.OnSwipeTouchListener;

public class SwipeRight5Days extends AppCompatActivity {

    RelativeLayout tvSwipeMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_right5_days);

        //SetUp View & Gesture
        tvSwipeMe = findViewById(R.id.tvSwipeMe);
        tvSwipeMe.setOnTouchListener(new MyOnSwipeTouchListener(this));
    }

    /*** Swipe Listener ***/
    private class MyOnSwipeTouchListener extends OnSwipeTouchListener {
        public MyOnSwipeTouchListener(Context c) {
            super(c);
        }

        @Override
        public void onSwipeRight() {
            Intent i = new Intent(SwipeRight5Days.this, MainActivity.class);
            startActivity(i);
        }
    }
}
