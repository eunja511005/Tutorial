package com.eun.tutorial.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eun.tutorial.filter.XssFilter;

@Configuration
public class MyFilterConfiguration {
    @Bean
    public FilterRegistrationBean<XssFilter> myFilter() {
        FilterRegistrationBean<XssFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*"); // Set the URL patterns for the filter
        registration.setName("XssFilter");
        registration.setOrder(1); // Set the order in which the filter should be applied
        return registration;
    }
}
