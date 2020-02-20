package com.example.icities;

import com.example.icities.Clases.City;
import com.example.icities.Clases.CityCollection;
import com.example.icities.Clases.PlaceCollection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ServiceProvider {
    @GET("city/creator/{uid}")
    @Headers({"Accept: application/xml", "Content-Type: application/xml"})
    Call<CityCollection> getAllCities(@Path("uid") String uid);

    @GET("city/{id}")
    @Headers({"Accept: application/xml", "Content-Type: application/xml"})
    Call<City> getCity(@Path("id") int id);

    @GET("place/city/{id}")
    @Headers({"Accept: application/xml", "Content-Type: application/xml"})
    Call<PlaceCollection> getAllPlaces(@Path("id") int id);
}

