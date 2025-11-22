package com.microservice.userService.Controller;

import com.microservice.userService.feign.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    FeignInterface feignInterface;
//    private final FeignInterface feignInterface;
//
//    public UserController(FeignInterface feignInterface) {
//        this.feignInterface = feignInterface;
//    }

    @GetMapping("/{paymentId}")
    public String getUserPaymentInfo(@PathVariable Integer paymentId) {
        System.out.println("Inside User Service - getUserPaymentInfo");
        return feignInterface.getPaymentInfo(paymentId);
    }
    @GetMapping("/health")
    public String healthCheck() {
        return "User Service is up and running!";
    }

    private String runRestTemplate(Integer paymentId) {
        String url = "http://localhost:8082/";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url+"payments/id/1",
                HttpMethod.GET,
                requestEntity,
                String.class);
        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
        return statusCode+"User Payment Info: " + responseEntity.getBody();
    }

}
