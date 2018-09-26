package com.example.younglings.openweather;

public class Weather {
  static    String temp;
    String desc;
    String wind;
    String cloudiness;
    String pressure;
    String humidity;
    String sunrise;
    String sunset;
    String lat,longi;

    String coordinates;

    Weather(String temperature,String description,String wind,String cloudiness,String pressure,String humidity,String sunrise,String sunset, String lat,String longi){

        this.temp=temperature;
        this.desc=description;
        this.wind=wind;
        this.cloudiness=cloudiness;
        this.pressure=pressure;
        this.humidity=humidity;
        this.sunrise=sunrise;
        this.sunset=sunset;
        this.lat=lat;
        this.longi=longi;

        this.coordinates=lat+",".concat(longi);


    }


}
