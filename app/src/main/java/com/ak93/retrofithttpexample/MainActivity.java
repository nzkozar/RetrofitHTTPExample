package com.ak93.retrofithttpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Stations> {

    TextView responseTextView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        responseTextView = (TextView)findViewById(R.id.answerText);
        Button httpButton  = (Button)findViewById(R.id.httpButton);
        httpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAPICall();
            }
        });
    }

    private void startAPICall(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.trola.si")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebApi webApi = retrofit.create(WebApi.class);
        Call<Stations> stationsCall = webApi.loadStations("bavarski");

        stationsCall.enqueue(this);

    }

    @Override
    public void onResponse(Call<Stations> call, Response<Stations> response) {
        Log.i(TAG,"onResponse");
        responseTextView.setText(new Gson().toJson(response.body()));
    }

    @Override
    public void onFailure(Call<Stations> call, Throwable t) {
        Log.i(TAG,"onFailure"+t.getMessage());
    }
}
