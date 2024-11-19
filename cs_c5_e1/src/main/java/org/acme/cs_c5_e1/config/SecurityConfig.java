package org.acme.cs_c5_e1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // authentication
        http.httpBasic(Customizer.withDefaults());

        // authorization
        http.authorizeHttpRequests(
                c -> c.requestMatchers("/api/v1/product/").authenticated());

        //csrf
        http.csrf(c -> c.disable());

        return http.build();
    }

}
