package com.TodoApplication.Backend.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth->auth.requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                        .anyRequest().authenticated()
        );
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(
          session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        http.csrf( csrf-> csrf.disable());
        return http.build();
    }
}