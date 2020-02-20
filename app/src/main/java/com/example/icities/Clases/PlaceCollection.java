package com.example.icities.Clases;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.io.Serializable;
import java.util.List;

@Xml(name = "places")
public class PlaceCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Element
    private List<Place> places;

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
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
