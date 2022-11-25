package com.example.ssl;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class CustomFilterRegister {

    @Bean
    public FilterRegistrationBean firstFilter() {
        FilterRegistrationBean customFilter = new FilterRegistrationBean(new LogFilter());
        return customFilter;
    }
}
