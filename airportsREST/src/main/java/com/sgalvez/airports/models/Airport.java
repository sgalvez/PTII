package com.sgalvez.airports.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by sgalvez on 12/17/16.
 */

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @NotNull
    private String code;
    private String name;
    private String cityCode;
    private String cityName;
    private String countryName;
    private String countryCode;
    private String timezone;
    private String lat;
    private String lon;
    private int numAirports;
    private boolean city;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public int getNumAirports() {
        return numAirports;
    }

    public boolean getCity() {
        return city;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setNumAirports(int numAirports) {
        this.numAirports = numAirports;
    }

    public void setCity(boolean city) {
        this.city = city;
    }


    public Airport() {

    }



}
