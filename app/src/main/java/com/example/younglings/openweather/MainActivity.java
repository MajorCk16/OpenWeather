package com.example.younglings.openweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText etCity;

    void displayWeather(){
        Intent intent = new Intent(this,WeatherDetailsActivity.class);
        intent.putExtra("Cityname",etCity.getText().toString());
        startActivity(intent);

        BackgroundTask task = new BackgroundTask();
        task.execute();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button)(findViewById(R.id.btnSubmit));
        etCity= (EditText)(findViewById(R.id.etCity));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayWeather();


            }
        });
    }
}
