package com.example.databinding;

public class TemperatureData {
    private double celsius;
    private String location;

    TemperatureData(String location, double celsius) {
        this.location = location;
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
