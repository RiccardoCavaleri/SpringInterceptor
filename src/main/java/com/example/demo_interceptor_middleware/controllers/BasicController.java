package com.example.demo_interceptor_middleware.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/time")
//l'endpoint restituisce la data e l'orario corrente
public class BasicController {

    @GetMapping
    public LocalDateTime getCurrentDateTime(){
        return LocalDateTime.now();
    }
}
