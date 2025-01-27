package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
public class PaymentController {
    @Autowired
    private NEFTPaymentService neftPaymentService;
    @PostMapping("/process-payment")
    public ResponseEntity<String> processPayment(@RequestBody String iso20022Xml) {
        Optional<String> paymentResponse = neftPaymentService.makePayment(iso20022Xml);
        return paymentResponse
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(500).body("Payment processing failed.")); // If not, return a 500 error with a message
    }
}

