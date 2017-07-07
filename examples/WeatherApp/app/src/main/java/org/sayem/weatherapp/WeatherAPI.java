package org.sayem.weatherapp;

import org.sayem.weatherapp.data.Weather;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by sayem on 7/17/16.
 */
public interface WeatherAPI {

    String baseUrl = "http://api.openweathermap.org/data/2.5/";

    @GET("weather?q=NewYork,us&units=imperial&appid=c2c066ae7795f26f751b829beb985602")
    Call<Weather> getWeather();


    class Factory {

        private static WeatherAPI service;

        public static WeatherAPI getInstance() {

            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                return retrofit.create(WeatherAPI.class);
            } else {
                return service;
            }
        }
    }
}
