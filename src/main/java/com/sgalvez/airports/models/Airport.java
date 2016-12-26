package com.sgalvez.airports.model;

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
    private String airportcode;
    private String cityname;
    private long worldareacode;

    public Airport() {

    }

    //TODO: Mejorar la definicion de la entidad
    public Airport(String airportcode){
        this.airportcode = airportcode;
    }

    public Airport(String cityname, long worldareacode){
        this.cityname = cityname;
        this.worldareacode = worldareacode;
    }

    public String getAirportcode(){
        return airportcode;
    }

    public String getCityname(){
        return cityname;
    }

    public long getWorldareacode(){
        return worldareacode;
    }

}

