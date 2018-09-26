package com.example.younglings.openweather;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BackgroundTask extends AsyncTask<Void,Void,Void> {

    String rawData ;
    String location = WeatherDetailsActivity.location;
    String sunset,sunrise;
    String lat,lon;
    String cloudiness;
    String description;
    String temp=" " ;
    String wind ;
    String pressure ;
    String humidity ;
    Date currentTime = Calendar.getInstance().getTime();

    @Override
    protected Void doInBackground(Void... voids) {



        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Durban,za&appid=4c3173a69df39b2c40c66cff3f0a3ec7&unit=metric");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = " ";

            while (line != null) {
                line = bufferedReader.readLine();
                rawData = rawData + line;
                Log.d("check Json",rawData);
            }

            JSONObject job = new JSONObject(rawData);


            temp = job.getJSONObject("main").getString("temp");
            wind = job.getJSONObject("wind").getString("speed");
            pressure = job.getJSONObject("main").getString("pressure");
            humidity = job.getJSONObject("main").getString("humidity");
            lat=job.getJSONObject("coord").getString("lat");
            lon=job.getJSONObject("coord").getString("lon");
            cloudiness=job.getJSONObject("clouds").getString("all");



            JSONArray weatherArray = job.getJSONArray("weather");
            for (int i = 0; i < weatherArray.length(); i++) {
                JSONObject jo = weatherArray.getJSONObject(i);
                description = jo.getString("description");

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        WeatherDetailsActivity.tvTemp.setText(temp+" °C");
        WeatherDetailsActivity.tvDiscription.setText(description);

        SimpleDateFormat date = new SimpleDateFormat("YY-MM-dd HH:mm");






        WeatherDetailsActivity.tvDate.setText(date.toString());







    }

}
