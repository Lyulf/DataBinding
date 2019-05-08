package com.example.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class TemperatureData extends BaseObservable{
    private String location;
    private double celsius;

    TemperatureData(String location, double celsius) {
        this.location = location;
        this.celsius = celsius;
    }

    @Bindable
    public double getCelsius() {
        return celsius;
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    public void incrementCelsius() {
        setCelsius(celsius + 1);
    }

    public void decrementCelsius() {
        setCelsius(celsius - 1);
    }
}
