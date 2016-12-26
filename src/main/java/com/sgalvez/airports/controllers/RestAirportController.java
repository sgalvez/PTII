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
@RequestMapping("/airports")
public class RestAirportController {

    @Autowired
    private AirportRepository airportRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Airport>> getAllPies(){
        return new ResponseEntity<>((Collection<Airport>) airportRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{airportCode}")
    public ResponseEntity<Airport> getPieWithId(@PathVariable String airportCode) {
        return new ResponseEntity<>(airportRepository.findOne(airportCode),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "airportCode")
    public ResponseEntity<Collection<Airport>> getCityByAirportCode(@RequestParam(value = "airportCode") String airportCode){
        return new ResponseEntity<>(airportRepository.findByAirportCode(airportCode), HttpStatus.OK);
    }
}
