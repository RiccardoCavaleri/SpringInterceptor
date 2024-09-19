package com.example.demo_interceptor_middleware.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/legacy")
//l'endpoint restituisce un messaggio predefinito
public class LegacyController {

    @GetMapping()
    public String getLegacyMessage(){
        return "This is just old code";
    }
}
