package com.example.demo.controller;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class PaymentRequest {

        private String channel;

        public record Transaction(
                String id,
                LocalDateTime CreationTimestamp
        ) {}

        public record PostalAddress(
                String country,
                String addressLine,
                String addressType
        ) {}

        public record Account(
                String id,
                String ifscCode,
                String accountType,
                int bankId
        ) {}

        public record Amount(
                String currency,
                String value
        ) {}

        public record Participant(
                String name,
                PostalAddress postalAddress,
                String LEID,
                Account account,
                Amount amount
        ) {}

        public record PaymentInformation(
                String paymentMethod,
                int numberOfTransactions,
                LocalDateTime requestedExecutionDate,
                Participant payer,
                Participant payee
        ) {}

        private Transaction transaction;
        private PaymentInformation paymentInformation;
    }

