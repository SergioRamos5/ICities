package com.example.icities.Clases;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.icities.UserData;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.io.Serializable;
import java.util.List;


@Xml(name = "city")
public class City extends UserData implements Serializable, Parcelable {

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

    public City()
    {
    }

    public City(Integer id)
    {
        this.id = id;
    }

    public City(Integer id, String cityname, String countryname, String regionname, String creatoruid)
    {
        this.id = id;
        this.cityname = cityname;
        this.countryname = countryname;
        this.regionname = regionname;
        this.creatoruid = creatoruid;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCityname()
    {
        return cityname;
    }

    public void setCityname(String cityname)
    {
        this.cityname = cityname;
    }

    public String getCountryname()
    {
        return countryname;
    }

    public void setCountryname(String countryname)
    {
        this.countryname = countryname;
    }

    public String getRegionname()
    {
        return regionname;
    }

    public void setRegionname(String regionname)
    {
        this.regionname = regionname;
    }

    public String getCreatoruid()
    {
        return creatoruid;
    }

    public void setCreatoruid(String creatoruid)
    {
        this.creatoruid = creatoruid;
    }

    public List<Place> getPlaces()
    {
        return getPlaces(id);
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
        if (!(object instanceof City))
            return false;
        City other = (City) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "clases.City[ id=" + id + " ]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cityname);
        dest.writeString(this.countryname);
        dest.writeString(this.creatoruid);
        dest.writeValue(this.id);
        dest.writeString(this.regionname);
    }

    protected City(Parcel in) {
        this.cityname = in.readString();
        this.countryname = in.readString();
        this.creatoruid = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.regionname = in.readString();
    }

    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
