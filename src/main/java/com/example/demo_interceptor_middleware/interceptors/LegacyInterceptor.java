package com.example.demo_interceptor_middleware.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//OBBIETTIVO: bloccare le richieste all'endpoint "/legacy" e restituire un messaggio di errore
@Component
public class LegacyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //in setStatus stiamo settando il tipo di errore con un valore numerico
        response.setStatus(HttpStatus.GONE.value());
        //in getWriter().write stiamo scrivendo il messaggio di errore
        response.getWriter().write("This API endpoint is not available.");
        //con il return false non diamo la possibilità di proseguire ai controller
        return false;
    }
}
