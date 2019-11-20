package com.androdocs.weatherapp.utilities;

public class Utility {
    public static Apis getApis() {
        return Client.getClient().create(Apis.class);
    }
}
