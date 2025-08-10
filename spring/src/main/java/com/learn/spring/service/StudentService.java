package com.learn.spring.service;

import org.springframework.stereotype.Component;

@Component
public class StudentService {
    String name;
    int age;
    public StudentService() {
        System.out.println("Default constructor");

    }
    public StudentService(String name, int age) {
        System.out.println("Student service paremeterized constructor");
        this.name=name;
        this.age=age;
    }

    public void updateName() {
        name=name.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



