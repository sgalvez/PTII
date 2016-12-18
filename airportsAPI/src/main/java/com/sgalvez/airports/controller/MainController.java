package com.sgalvez.airports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sgalvez on 12/17/16.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "PTII - Springboot poc";
    }
}
