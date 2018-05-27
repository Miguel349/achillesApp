package com.adidashackaton.achillesApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.boot.autoconfigure.security.SecurityProperties.ACCESS_OVERRIDE_ORDER;

@Configuration
@EnableWebSecurity(debug=false)
@EnableGlobalMethodSecurity(securedEnabled = true)
@Order(ACCESS_OVERRIDE_ORDER - 1 )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String ADMIN_USER = "robby";
    public static final String ADMIN_PASS = "L51g1";
    /*  @Bean
    public TokenBasedRememberMeServices rememberMeServices() {
        return new TokenBasedRememberMeServices("remember-me-key", accountService);
    }*/


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .csrf().disable();

    }
}