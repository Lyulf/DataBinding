package com.example.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class TemperatureData extends BaseObservable{
    private String location;
    private Double celsius;

    TemperatureData(String location, Double celsius) {
        this.location = location;
        this.celsius = celsius;
    }

    @Bindable
    public Double getCelsius() {
        return celsius;
    }

    @Bindable
    public String getLocation() {
        return location;
    }

    public void setCelsius(Double celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    public void incrementCelsius() {
        celsius++;
        notifyPropertyChanged(BR.celsius);
    }

    public void decrementCelsius() {
        celsius--;
        notifyPropertyChanged(BR.celsius);
    }
}
