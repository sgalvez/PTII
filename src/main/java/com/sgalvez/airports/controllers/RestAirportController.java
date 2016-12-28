package com.sgalvez.airports.controllers;

import com.sgalvez.airports.models.Airport;
import com.sgalvez.airports.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by sgalvez on 12/25/16.
 */

@RestController
@CrossOrigin
@RequestMapping("/airports")
public class RestAirportController {

    @Autowired
    private AirportRepository airportRepository;

    @RequestMapping(method = RequestMethod.GET, value = "getAll")
    public ResponseEntity<Collection<Airport>> getAllData(){
        return new ResponseEntity<>((Collection<Airport>) airportRepository.findAll(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "getCity")
    public ResponseEntity<Collection<Airport>> getByAirportCode(@RequestParam(value = "airportCode") String airportCode){
        return new ResponseEntity<>(airportRepository.findByAirportCode(airportCode), HttpStatus.OK);
    }
}
