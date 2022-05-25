// see https://quarkus.io/guides/security-authorization
//package com.nekose.sampleproject.config;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    // TODO OAuth2を導入する
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/v1/samples/**").permitAll()
//                .antMatchers("/v1/examples/**").permitAll()
//                .antMatchers("/error").permitAll()
//                .anyRequest().authenticated()
//        .and().httpBasic().disable();;
//    }
//}
