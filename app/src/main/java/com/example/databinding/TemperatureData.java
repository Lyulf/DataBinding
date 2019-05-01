package com.example.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class TemperatureData extends BaseObservable{
    private String location;
    private String celsius;

    TemperatureData(String location, String celsius) {
        this.location = location;
        this.celsius = celsius;
    }

    @Bindable
    public String getCelsius() {
        return celsius;
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }

    public void setLocation(String location) {
        this.location = location;
        // no notification = no updating value
//        notifyPropertyChanged(BR.location);
    }
}
