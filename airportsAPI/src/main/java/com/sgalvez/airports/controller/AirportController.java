package com.sgalvez.airports.controller;

import com.sgalvez.airports.model.Airport;
import com.sgalvez.airports.model.AirportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sgalvez on 12/17/16.
 */
@Controller
public class AirportController {

    @RequestMapping("/findCity")
    @ResponseBody
    public String getByAirportCode(String airportcode){
        String cityname;
        try{
            Airport airport = airportDAO.getByAirportCode(airportcode);
            cityname = String.valueOf(airport.getCityname());
        }
        catch (Exception ex) {
            return "Airport not found: " + ex.toString();
        }
        return "The City of the "+airportcode+" Airport is: " + cityname;

    }
    @Autowired
    private AirportDAO airportDAO;
}
