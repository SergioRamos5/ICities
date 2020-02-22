package com.example.icities.Clases;

import com.example.icities.JsonResponse;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.widget.ImageView;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;

import static androidx.core.app.ActivityCompat.startActivityForResult;


@Xml(name = "city")
public class City extends UserDataFromRest implements Serializable, Parcelable {

    private static final long serialVersionUID = 1L;

    @PropertyElement(name = "cityname")
    private String cityname;
    @PropertyElement(name = "countryname")
    private String countryname;
    @PropertyElement(name = "creatoruid")
    private String creatoruid;
    @PropertyElement(name = "id")
    private Integer id;
    @PropertyElement(name = "regionname")
    private String regionname;

    public City() {
    }

    public City(Integer id) {
        this.id = id;
    }

    public City(Integer id, String cityname, String countryname, String regionname, String creatoruid) {
        this.id = id;
        this.cityname = cityname;
        this.countryname = countryname;
        this.regionname = regionname;
        this.creatoruid = creatoruid;
    }

    public City(String cityname, String countryname, String regionname, String creatoruid) {
        this.cityname = cityname;
        this.countryname = countryname;
        this.regionname = regionname;
        this.creatoruid = creatoruid;
    }

    protected City(Parcel in) {
        cityname = in.readString();
        countryname = in.readString();
        creatoruid = in.readString();
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        regionname = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public String getCreatoruid() {
        return creatoruid;
    }

    public void setCreatoruid(String creatoruid) {
        this.creatoruid = creatoruid;
    }

    public List<Place> getPlaces() {
        return getPlaces(id);
    }

    public boolean updateDB() {
        Call<JsonResponse> jsonResponseCall = createRetrofit().editCity(this);
        AsyncTask updateCityAsyncTask = new AsyncTask() {
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

        boolean updateCityResponse = false;
        try {
            updateCityAsyncTask.execute();
            updateCityResponse = (boolean) updateCityAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return updateCityResponse;
    }

    public boolean insertPlace(Place place) {
        Call<JsonResponse> jsonResponseCall = createRetrofit().insertPlace(this.id, place);
        AsyncTask insertPlaceAsyncTask = new AsyncTask() {
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

        boolean insertPlaceResponse = false;
        try {
            insertPlaceAsyncTask.execute();
            insertPlaceResponse = (boolean) insertPlaceAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return insertPlaceResponse;
    }

    public boolean deleteFromDB() {
        Call<JsonResponse> jsonResponseCall = createRetrofit().deleteCity(this.id);
        AsyncTask deleteCityAsyncTask = new AsyncTask() {
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

        boolean deleteCityResponse = false;
        try {
            deleteCityAsyncTask.execute();
            deleteCityResponse = (boolean) deleteCityAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return deleteCityResponse;
    }

    public boolean deleteFromDBForce() {
        Call<JsonResponse> jsonResponseCall = createRetrofit().deleteCityForce(this.id);
        AsyncTask deleteCityAsyncTask = new AsyncTask() {
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

        boolean deleteCityResponse = false;
        try {
            deleteCityAsyncTask.execute();
            deleteCityResponse = (boolean) deleteCityAsyncTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        return deleteCityResponse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City))
            return false;
        City other = (City) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "clases.City[ id=" + id + " ]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cityname);
        dest.writeString(countryname);
        dest.writeString(creatoruid);
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(regionname);
    }

    public void setImage(Uri file) {
        
        StorageReference riversRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://icities-eda4d.appspot.com/"+ getId());
        UploadTask uploadTask = riversRef.putFile(file);


// Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
            }
        });
    }
}
