package com.learn.spring.configuration;

import com.learn.spring.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public String test() {
        System.out.println("test bean");
        return "test bean";
    }
    @Bean
    public StudentService getStudentService() {
        return new StudentService("Test",12);
    }
}
