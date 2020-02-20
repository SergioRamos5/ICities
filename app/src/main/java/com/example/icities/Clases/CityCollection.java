package com.example.icities.Clases;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.io.Serializable;
import java.util.List;

@Xml(name = "cities")
public class CityCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Element
    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
