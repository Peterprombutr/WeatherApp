package com.androdocs.weatherapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {
    @SerializedName("list")
    @Expose
    private java.util.List<DataObject> dataObject = null;
    @SerializedName("city")
    @Expose
    private City city;

    public java.util.List<DataObject> getDataObjectList() {
        return dataObject;
    }

    public void setDataObject(java.util.List<DataObject> dataObject) {
        this.dataObject = dataObject;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}