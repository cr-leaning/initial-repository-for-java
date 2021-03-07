package com.nekose.sampleproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // TODO OAuth2を導入する
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/v1/samples/**").permitAll()
                .antMatchers("/v1/examples/**").permitAll()
                .antMatchers("/error").permitAll()
                .anyRequest().authenticated()
        .and().httpBasic().disable();;
    }
}
