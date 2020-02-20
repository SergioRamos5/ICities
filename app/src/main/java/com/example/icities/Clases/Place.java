/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.icities.Clases;

import java.io.Serializable;

public class Place implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String placename;

    private String adress;

    private String placedescription;

    private City idcity;

    public Place() {
    }

    public Place(Integer id) {
        this.id = id;
    }

    public Place(Integer id, String placename, String adress, String placedescription) {
        this.id = id;
        this.placename = placename;
        this.adress = adress;
        this.placedescription = placedescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPlacedescription() {
        return placedescription;
    }

    public void setPlacedescription(String placedescription) {
        this.placedescription = placedescription;
    }

    public City getIdcity() {
        return idcity;
    }

    public void setIdcity(City idcity) {
        this.idcity = idcity;
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
        if (!(object instanceof Place))
            return false;
        Place other = (Place) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "clases.Place[ id=" + id + " ]";
    }

}
