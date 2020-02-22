package com.example.icities.Clases;

import android.os.AsyncTask;

import com.example.icities.ServiceProvider;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;
import retrofit2.Retrofit;

public class UserDataFromRest {

    private final static String API_REST_BASE_URL = "http://clembell.duckdns.org:8084/icities/resources/icities/";

    static ServiceProvider createRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_REST_BASE_URL)
                .addConverterFactory(TikXmlConverterFactory.create())
                .build();

        return retrofit.create(ServiceProvider.class);
    }

    public static List<City> getCities(String uid){
        ServiceProvider serviceProvider = createRetrofit();

        AsyncTask getCitiesAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Response<CityCollection> cityCollectionResponse = null;
                try {
                    cityCollectionResponse = serviceProvider.getAllCities(uid).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return cityCollectionResponse.body();
            }
        };

        CityCollection cityCollectionResponse = null;
        try {
            getCitiesAsyncTask.execute();
            cityCollectionResponse = (CityCollection) getCitiesAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return cityCollectionResponse.getCities();
    }

    public static City getCity(int id){
        ServiceProvider serviceProvider = createRetrofit();

        AsyncTask getCityAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Response<City> cityResponse = null;
                try {
                    cityResponse = serviceProvider.getCity(id).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return cityResponse.body();
            }
        };

        City city = null;
        try {
            getCityAsyncTask.execute();
            city = (City) getCityAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return city;
    }

    public static List<Place> getPlaces(int cityId){
        ServiceProvider serviceProvider = createRetrofit();

        AsyncTask getPlacesAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Response<PlaceCollection> placeCollectionResponse = null;
                try {
                    placeCollectionResponse = serviceProvider.getAllPlaces(cityId).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return placeCollectionResponse.body();
            }
        };

        PlaceCollection placeCollectionResponse = null;
        try {
            getPlacesAsyncTask.execute();
            placeCollectionResponse = (PlaceCollection) getPlacesAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return placeCollectionResponse.getPlaces();
    }

    public static Place getPlace(int id){
        ServiceProvider serviceProvider = createRetrofit();

        AsyncTask getPlaceAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Response<Place> placeResponse = null;
                try {
                    placeResponse = serviceProvider.getPlace(id).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return placeResponse.body();
            }
        };

        Place place = null;
        try {
            getPlaceAsyncTask.execute();
            place = (Place) getPlaceAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return place;
    }

    public static Userdata getUser(String uid){
        ServiceProvider serviceProvider = createRetrofit();

        AsyncTask getUserAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                Response<Userdata> userResponse = null;
                try {
                    userResponse = serviceProvider.getUser(uid).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return userResponse.body();
            }
        };

        Userdata userdata = null;
        try {
            getUserAsyncTask.execute();
            userdata = (Userdata) getUserAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return userdata;
    }

    public static boolean insertCity(City city){
        ServiceProvider serviceProvider = createRetrofit();

        AsyncTask insertCityAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    serviceProvider.insertCity(city).execute();
                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        };

        boolean cityInserted = false;
        try {
            insertCityAsyncTask.execute();
            cityInserted = (boolean) insertCityAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return cityInserted;
    }

    public static boolean insertUser(Userdata userdata){
        ServiceProvider serviceProvider = createRetrofit();

        AsyncTask insertUserAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    serviceProvider.insertUser(userdata).execute();
                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        };

        boolean userInserted = false;
        try {
            insertUserAsyncTask.execute();
            userInserted = (boolean) insertUserAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return userInserted;
    }

}