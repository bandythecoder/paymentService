package com.example.demo.controller;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/process-payment")
public class PaymentController {
    @Autowired
    private NEFTPaymentService neftPaymentService;
    @SneakyThrows
    @PostMapping(consumes = "application/json", produces = "application/json")
    public PaymentRequestAPI handlePaymentRequest(@RequestBody PaymentRequestAPI paymentRequest) {
        // Your logic here
        neftPaymentService.makePayment(paymentRequest);
        return paymentRequest;
    }
}

