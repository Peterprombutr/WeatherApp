package com.androdocs.weatherapp.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataObject {

    @SerializedName("dt")
    @Expose
    private int dt;
    @SerializedName("main")
    @Expose
    private com.androdocs.weatherapp.models.Main main;
    @SerializedName("weather")
    @Expose
    private java.util.List<com.androdocs.weatherapp.models.Weather> weather = null;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("wind")
    @Expose
    private com.androdocs.weatherapp.models.Wind wind;
    @SerializedName("sys")
    @Expose
    private com.androdocs.weatherapp.models.Sys sys;
    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;

    public long getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public com.androdocs.weatherapp.models.Main getMain() {
        return main;
    }

    public void setMain(com.androdocs.weatherapp.models.Main main) {
        this.main = main;
    }

    public java.util.List<com.androdocs.weatherapp.models.Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<com.androdocs.weatherapp.models.Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public com.androdocs.weatherapp.models.Wind getWind() {
        return wind;
    }

    public void setWind(com.androdocs.weatherapp.models.Wind wind) {
        this.wind = wind;
    }

    public com.androdocs.weatherapp.models.Sys getSys() {
        return sys;
    }

    public void setSys(com.androdocs.weatherapp.models.Sys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

}