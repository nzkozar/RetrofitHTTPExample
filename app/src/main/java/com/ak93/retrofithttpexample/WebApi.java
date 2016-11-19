package com.ak93.retrofithttpexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Anže Kožar on 19.11.2016.
 */

public interface WebApi {
    @Headers("Accept: application/json")
    @GET("/{station}")
    Call<Stations>loadStations(@Path("station")String station);
}
