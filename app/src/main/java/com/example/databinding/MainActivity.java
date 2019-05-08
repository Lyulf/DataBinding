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
        String location;
        double celsius;
        if(savedInstanceState != null) {
            location = savedInstanceState.getString("location");
            celsius = savedInstanceState.getDouble("celsius");
        } else {
            location = "Lodz";
            celsius = 10.0;
        }
        temp = new TemperatureData(location, celsius);
        binding.setTemp(temp);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("location", temp.getLocation());
        savedInstanceState.putDouble("celsius", temp.getCelsius());
    }
}
