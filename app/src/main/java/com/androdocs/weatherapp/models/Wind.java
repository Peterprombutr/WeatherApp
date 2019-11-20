package com.androdocs.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    @Expose
    private float speed;
    @SerializedName("deg")
    @Expose
    private float deg;

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }
}