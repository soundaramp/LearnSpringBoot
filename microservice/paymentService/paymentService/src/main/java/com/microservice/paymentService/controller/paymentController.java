package com.microservice.paymentService.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payments")
public class paymentController {



    Map<Integer, Integer> payments = new HashMap<>();
    paymentController() {
        payments.put(1, 100);
        payments.put(2, 200);
        payments.put(3, 300);
    }
    @GetMapping("/id/{paymentId}")
    public String getPayment(@PathVariable int paymentId) {
        System.out.println("payment service2");
        return "Payment ID: " + paymentId + ", Amount: " + payments.get(paymentId);
    }
}
