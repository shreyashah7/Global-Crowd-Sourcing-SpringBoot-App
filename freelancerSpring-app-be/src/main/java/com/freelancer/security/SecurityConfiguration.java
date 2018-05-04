package com.freelancer.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class SecurityConfiguration implements WebMvcConfigurer {

    @Autowired
    RequestIntercepter requestIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestIntercepter);
    }
}