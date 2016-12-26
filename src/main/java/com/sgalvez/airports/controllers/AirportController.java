package com.sgalvez.airports.controller;

import com.sgalvez.airports.model.Airport;
import com.sgalvez.airports.model.AirportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sgalvez on 12/17/16.
 */
@RestController
public class AirportController {

    @RequestMapping("/getCity")
    public String getByAirportCode(@RequestParam(value="airportcode", defaultValue = "SCL")String airportcode) {
        String cityname;
        try{
            Airport airport = airportDAO.getByAirportCode(airportcode);
            cityname = String.valueOf(airport.getCityname());
        }
        catch (Exception ex) {
            return "Airport not found: " + ex.toString();
        }
        return String.format(cityname);
    }
    
    @Autowired
    private AirportDAO airportDAO;
}
