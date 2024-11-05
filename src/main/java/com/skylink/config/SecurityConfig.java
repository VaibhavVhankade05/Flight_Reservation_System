package com.skylink.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() 
            .authorizeHttpRequests()
            	.requestMatchers("/users/**").permitAll() //Permit All User Request
                .requestMatchers("/users/register").permitAll()
                .requestMatchers("/users", "/users/{id}").permitAll()
                .requestMatchers(HttpMethod.PUT, "/users/{id}").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/users/{id}").permitAll()
                
                .requestMatchers("/flight/**").permitAll() //Permit All Flight Request
                .requestMatchers("/flight", "/users/{id}").permitAll()
                .requestMatchers(HttpMethod.PUT, "/flight/{id}").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/flight/{id}").permitAll()
                
                .requestMatchers("/booking/**").permitAll() //Permit All Booking Request
                
                .requestMatchers("/payment/**").permitAll() //Permit All Payment Request
                .anyRequest().authenticated() 
            .and()
            .httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Register the PasswordEncoder bean
    }
}
