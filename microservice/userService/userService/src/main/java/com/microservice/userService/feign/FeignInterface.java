package com.microservice.userService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="paymentService")
public interface FeignInterface {
    @GetMapping("/payments/id/{paymentId}")
    String getPaymentInfo(@PathVariable Integer paymentId);
}
