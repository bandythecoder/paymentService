package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.xml.bind.*;

@RestController
public class PaymentController {

    @Autowired
    private NEFTPaymentService neftPaymentService;

    @PostMapping("/process-payment")
    public String processPayment(@RequestBody String iso20022Xml) throws JAXBException {
        return neftPaymentService.convertToFixmlAndSend(iso20022Xml);
    }
}

