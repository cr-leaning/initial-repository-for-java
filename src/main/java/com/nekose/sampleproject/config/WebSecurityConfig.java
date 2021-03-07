package com.nekose.sampleproject.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/samples/**").permitAll()
                .antMatchers("/v1/examples/**").permitAll()
                .antMatchers("/error").permitAll()
                .anyRequest().authenticated();
    }
}
