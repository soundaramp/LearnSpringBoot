package com.learn.bookReview.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails ud = User.builder().username("admin").password(passwordEncoder.encode("admin123")).roles("ADMIN","USER").build();
        UserDetails ud1 = User.builder().username("user")
                .password(passwordEncoder.encode("user123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(ud, ud1);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth->auth
                .requestMatchers("/books/getAllReviews").hasAnyRole("ADMIN")
                .requestMatchers("/books/addBook","/books/addReview").permitAll()
                .anyRequest().authenticated()
        );

        return http.build();
    }
}
