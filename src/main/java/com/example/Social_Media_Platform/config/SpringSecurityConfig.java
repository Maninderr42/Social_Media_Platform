package com.example.Social_Media_Platform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfiguration {

    // Bean definition for PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Method to configure AuthenticationManagerBuilder
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configure in-memory authentication with a default user
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password")) // Encoded password using BCrypt
                .roles("USER");
    }
}
