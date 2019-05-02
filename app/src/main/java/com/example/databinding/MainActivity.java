package com.example.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.databinding.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    TemperatureData temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        temp = new TemperatureData("Lodz", 10.0);
        if(savedInstanceState != null) {
            String location = savedInstanceState.getString("location");
            Double celsius = savedInstanceState.getDouble("celsius");
            temp.setLocation(location);
            temp.setCelsius(celsius);
        }
        binding.setTemp(temp);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            savedInstanceState.putString("location", temp.getLocation());
            savedInstanceState.putDouble("celsius", temp.getCelsius());
        }
        super.onSaveInstanceState(savedInstanceState);
    }
}
