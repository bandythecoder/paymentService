package com.example.demo.controller;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
public class PaymentResponse {

    @XmlElement(name = "CstmrPmtStsRpt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
    private CstmrPmtStsRpt cstmrPmtStsRpt;


    @Builder
    public static class CstmrPmtStsRpt {

        @XmlElement(name = "GrpHdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private GrpHdr grpHdr;

        @XmlElement(name = "OrgnlPmtInfAndSts", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private OrgnlPmtInfAndSts orgnlPmtInfAndSts;

        @XmlElement(name = "Err", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private List<Err> err;
    }

    @Builder
    public static class GrpHdr {

        @XmlElement(name = "MsgId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private String msgId;

        @XmlElement(name = "MsgNmId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private String msgNmId;

        @XmlElement(name = "MsgRspn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private String msgRspn;
    }

    @Builder
    public static class OrgnlPmtInfAndSts {

        @XmlElement(name = "OrgnlPmtInfId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private String orgnlPmtInfId;

        @XmlElement(name = "PmtSts", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private String pmtSts;
    }

    @Builder
    public static class Err {

        @XmlElement(name = "ErrDesc", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private String errDesc;

        @XmlElement(name = "ErrCode", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private String errCode;

        @XmlElement(name = "ErrSource", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private String errSource;

        @XmlElement(name = "ErrType", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.03")
        private String errType;
    }

    // Helper method to map the fixmlResponse to PaymentResponse
    public static PaymentResponse from(FixmlResponse fixmlResponse) {
        // Convert the header part
        PaymentResponse.CstmrPmtStsRpt cstmrPmtStsRpt = PaymentResponse.CstmrPmtStsRpt.builder()
                .grpHdr(PaymentResponse.GrpHdr.builder()
                        .msgId(fixmlResponse.getHeader().getResponseHeader().getRequestMessageKey().getGlobalUUID())
                        .msgNmId("pain.002.001.03") // Assuming this stays static
                        .msgRspn("ISO20022") // Assuming this stays static
                        .build())
                .orgnlPmtInfAndSts(PaymentResponse.OrgnlPmtInfAndSts.builder()
                        .orgnlPmtInfId(fixmlResponse.getHeader().getResponseHeader().getRequestMessageKey().getRequestUUID())
                        .pmtSts(fixmlResponse.getHeader().getResponseHeader().getUbusTransaction().getStatus())
                        .build())
                .err(mapErrors(fixmlResponse.getBody().getError().getFibusinessException().getErrorDetails()))
                .build();

        // Build Document object
        return PaymentResponse.builder()
                .cstmrPmtStsRpt(cstmrPmtStsRpt)
                .build();
    }

    // Map errors from the FixmlResponse
    private static List<PaymentResponse.Err> mapErrors(List<FixmlResponse.Body.Error.FIBusinessException.ErrorDetail> errorDetails) {
        return errorDetails.stream()
                .map(error -> PaymentResponse.Err.builder()
                        .errDesc(error.getErrorDesc())
                        .errCode(error.getErrorCode())
                        .errSource(error.getErrorSource())
                        .errType(error.getErrorType())
                        .build())
                .collect(Collectors.toList());
    }
}
