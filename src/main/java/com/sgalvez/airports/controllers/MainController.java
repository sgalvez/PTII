package com.sgalvez.airports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sgalvez on 12/17/16.
 */
@RestController
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "PTII - Springboot poc";
    }
}
