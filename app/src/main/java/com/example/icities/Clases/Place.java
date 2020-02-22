/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.icities.Clases;

import android.os.AsyncTask;

import com.example.icities.JsonResponse;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;

@Xml(name = "place")
public class Place extends UserDataFromRest implements Serializable
{

    private static final long serialVersionUID = 1L;
    @PropertyElement(name = "id")
    private Integer id;
    @PropertyElement(name = "placename")
    private String placename;
    @PropertyElement(name = "adress")
    private String adress;
    @PropertyElement(name = "placedescription")
    private String placedescription;
    @PropertyElement(name = "idcity")
    private City idcity;

    public Place()
    {
    }

    public Place(Integer id)
    {
        this.id = id;
    }

    private Place(Integer id, String placename, String adress, String placedescription)
    {
        this.id = id;
        this.placename = placename;
        this.adress = adress;
        this.placedescription = placedescription;
    }

    public Place(String placename, String adress, String placedescription)
    {
        this.placename = placename;
        this.adress = adress;
        this.placedescription = placedescription;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPlacename()
    {
        return placename;
    }

    public void setPlacename(String placename)
    {
        this.placename = placename;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public String getPlacedescription()
    {
        return placedescription;
    }

    public void setPlacedescription(String placedescription)
    {
        this.placedescription = placedescription;
    }

    public City getIdcity()
    {
        return idcity;
    }

    public void setIdcity(City idcity)
    {
        this.idcity = idcity;
    }

    public boolean updateDB()
    {
        Call<JsonResponse> jsonResponseCall = createRetrofit().editPlace(this);
        AsyncTask updatePlaceAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    jsonResponseCall.execute();
                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        };

        boolean updatePlaceResponse = false;
        try {
            updatePlaceAsyncTask.execute();
            updatePlaceResponse = (boolean) updatePlaceAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return updatePlaceResponse;
    }

    public boolean deleteFromDB(){
        Call<JsonResponse> jsonResponseCall = createRetrofit().deletePlace(this.id);
        AsyncTask deletePlaceAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    jsonResponseCall.execute();
                } catch (Exception e) {
                    return false;
                }
                return true;
            }
        };

        boolean deletePlaceResponse = false;
        try {
            deletePlaceAsyncTask.execute();
            deletePlaceResponse = (boolean) deletePlaceAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return deletePlaceResponse;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Place))
            return false;
        Place other = (Place) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "clases.Place[ id=" + id + " ]";
    }

}
