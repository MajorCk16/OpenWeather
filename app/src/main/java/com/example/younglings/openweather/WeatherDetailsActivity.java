package com.example.younglings.openweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeatherDetailsActivity extends AppCompatActivity {

 static    TextView tvLocation,tvTemp,tvDiscription,tvDate;
    static String location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        tvLocation= (TextView)(findViewById(R.id.tvLocation));
        tvDiscription=(TextView)(findViewById(R.id.tvDisc));
        tvDate=(TextView)(findViewById(R.id.tvDate));
        tvTemp= (TextView)(findViewById(R.id.tvTemp));

        Intent intent= getIntent();
        location=intent.getStringExtra("Cityname");
        tvLocation.append(location);







    }
}
