package com.example.databinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TemperatureData temperature;
    Button refreshButton;
    TextView celsiusTextView;
    TextView locationTextView;
    EditText celsiusEditText;
    EditText locationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperature = new TemperatureData("Lodz", 10.0);
        if(savedInstanceState != null) {
            String location = savedInstanceState.getString("location");
            Double celsius = savedInstanceState.getDouble("celsius");
            temperature.setLocation(location);
            temperature.setCelsius(celsius);
        }

        refreshButton = findViewById(R.id.Refresh_Button);
        celsiusTextView = findViewById(R.id.Celsius_TextView);
        locationTextView = findViewById(R.id.Location_TextView);
        celsiusEditText = findViewById(R.id.Celsius_EditText);
        locationEditText = findViewById(R.id.Location_EditText);

        updateValues();

        refreshButton.setOnClickListener(
            (View view) -> {
                double celsius;
                try {
                    celsius = Double.parseDouble(celsiusEditText.getText().toString());
                } catch(NumberFormatException e) {
                    celsius = 0.0;
                }
                temperature.setCelsius(celsius);
                temperature.setLocation(locationEditText.getText().toString());
                updateValues();
            }
        );
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            savedInstanceState.putString("location", temperature.getLocation());
            savedInstanceState.putDouble("celsius", temperature.getCelsius());
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    public void updateValues() {
        celsiusTextView.setText(getString(R.string.temperature) + ": " + temperature.getCelsius() + "°C");
        locationTextView.setText(getString(R.string.location) + ": " + temperature.getLocation());
    }
}
