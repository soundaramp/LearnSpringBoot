package com.learn.spring.Controller;
import com.learn.spring.service.StudentService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringController {
    Logger logger = LoggerFactory.getLogger(ILoggerFactory.class);

    @Autowired
    StudentService studentService;

    @RequestMapping("/hello")
    @ResponseBody
    public StudentService handleRequest() {
        logger.debug("\nHandleRequest::Processing request");
        studentService.updateName();
        return studentService;
    }
}