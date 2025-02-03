package com.example.demo.controller;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestAPI {

    private String channel;
    private Transaction transaction;
    private PaymentInformation paymentInformation;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Transaction {
        private String id;
        private String creationTimestamp;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostalAddress {
        private String country;
        private String addressLine;
        private String addressType;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Account {
        private String id;
        private String ifscCode;
        private String accountType;

        private BankInfo bankInfo;

        @Data  // Generates getters, setters, toString(), equals(), and hashCode() methods
        @NoArgsConstructor  // Generates a no-args constructor
        @AllArgsConstructor  // Generates a constructor with all fields
        public class BankInfo {
            private String bankId;
            private String name;
            private String branchId;
            private String branchName;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Amount {
        private String currency;
        private Double value;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Participant {
        private String name;
        private PostalAddress postalAddress;
        private String LEID;
        private Account account;
        private Amount amount;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentInformation {
        private String paymentMethod;
        private int numberOfTransactions;
        private String requestedExecutionDate;
        private Participant payer;
        private Participant payee;
    }
}
