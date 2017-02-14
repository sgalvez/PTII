package com.sgalvez.airports.controllers;

import com.sgalvez.airports.repositories.AirportCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sgalvez on 12/25/16.
 */

@RestController
@CrossOrigin
@RequestMapping("/airport")
public class AirportCodeController {

    @Autowired
    private AirportCodeRepository airportCodeRepository;

}
