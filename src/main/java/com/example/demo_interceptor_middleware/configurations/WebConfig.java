package com.example.demo_interceptor_middleware.configurations;

import com.example.demo_interceptor_middleware.interceptors.APILoggingInterceptor;
import com.example.demo_interceptor_middleware.interceptors.LegacyInteceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //aggiungiamo APILoggingInterceptor e LegacyInteceptor al registro con il metodo addInterceptors
    @Bean
    public APILoggingInterceptor apiLoggingInterceptor(){
        return  new APILoggingInterceptor();
    }

    @Bean
    public LegacyInteceptor legacyInteceptor(){
        return new LegacyInteceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor());
        registry.addInterceptor(legacyInteceptor()).addPathPatterns("/legacy");
    }
}
