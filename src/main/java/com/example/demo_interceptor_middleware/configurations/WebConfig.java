package com.example.demo_interceptor_middleware.configurations;

import com.example.demo_interceptor_middleware.interceptors.APILoggingInterceptor;
import com.example.demo_interceptor_middleware.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //aggiungiamo APILoggingInterceptor e LegacyInteceptor al registro con il metodo addInterceptors
    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private LegacyInterceptor legacyInteceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(legacyInteceptor).addPathPatterns("/legacy");
    }
}
