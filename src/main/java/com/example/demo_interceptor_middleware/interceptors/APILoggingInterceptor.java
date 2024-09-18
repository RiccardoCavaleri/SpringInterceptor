package com.example.demo_interceptor_middleware.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


//OBBIETTIVO: intercettare tutte le richieste e stampare l'header User-Agent nella console
@Component
//headlerInterceptor ha la responsabilità di intercettare le richieste in entrata
public class APILoggingInterceptor implements HandlerInterceptor {

    @Override
    // metodo preHandel serve in questo caso per ottenere l'user-agent che fa la richiesta e lo stampiamo in console
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userAgent = request.getHeader("User-Agent");
        System.out.println("User-Agent: " + userAgent);
        // restituisco true per far continuare la richiesta al controller (se avessi messo false non avrebbe proseguito)
        return true;
    }
}
