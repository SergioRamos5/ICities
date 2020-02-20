package com.example.icities.Clases;

import com.example.icities.UserData;
import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import java.io.Serializable;
import java.util.List;


@Xml(name = "city")
public class City extends UserData implements Serializable {

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

}
