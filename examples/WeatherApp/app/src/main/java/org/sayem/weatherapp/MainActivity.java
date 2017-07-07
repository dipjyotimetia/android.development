package org.sayem.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.sayem.weatherapp.data.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.temp)
    TextView temp;
    @BindView(R.id.refresh_button)
    Button refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.refresh_button)
    public void onRefresh() {
        WeatherAPI.Factory.getInstance().getWeather().enqueue(new Callback<Weather>() {

            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather = response.body();
                temp.setText(weather.getMain().getTemp());
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.e("Failed", t.getMessage());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        onRefresh();
    }
}
