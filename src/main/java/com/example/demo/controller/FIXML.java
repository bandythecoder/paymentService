package com.example.demo.controller;

import lombok.*;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "FIXML",namespace = "http://www.finacle.com/fixml")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FIXML {

    @XmlElement(name = "Header",namespace = "http://www.finacle.com/fixml")
    private Header header;

    @XmlElement(name = "Body",namespace = "http://www.finacle.com/fixml")
    private Body body;

    // Nested classes

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class Header {

        @XmlElement(name = "RequestHeader",namespace = "http://www.finacle.com/fixml")
        private RequestHeader requestHeader;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class RequestHeader {

        @XmlElement(name = "MessageKey",namespace = "http://www.finacle.com/fixml")
        private MessageKey messageKey;

        @XmlElement(name = "RequestMessageInfo",namespace = "http://www.finacle.com/fixml")
        private RequestMessageInfo requestMessageInfo;

        @XmlElement(name = "Security",namespace = "http://www.finacle.com/fixml")
        private Security security;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class MessageKey {

        @XmlElement(name = "RequestUUID",namespace = "http://www.finacle.com/fixml")
        private String requestUUID;

        @XmlElement(name = "ServiceRequestId",namespace = "http://www.finacle.com/fixml")
        private String serviceRequestId;

        @XmlElement(name = "ServiceRequestVersion",namespace = "http://www.finacle.com/fixml")
        private String serviceRequestVersion;

        @XmlElement(name = "ChannelId",namespace = "http://www.finacle.com/fixml")
        private String channelId;

        @XmlElement(name = "LanguageId",namespace = "http://www.finacle.com/fixml")
        private String languageId;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class RequestMessageInfo {

        @XmlElement(name = "BankId",namespace = "http://www.finacle.com/fixml")
        private String bankId;

        @XmlElement(name = "TimeZone",namespace = "http://www.finacle.com/fixml")
        private String timeZone;

        @XmlElement(name = "EntityId",namespace = "http://www.finacle.com/fixml")
        private String entityId;

        @XmlElement(name = "EntityType",namespace = "http://www.finacle.com/fixml")
        private String entityType;

        @XmlElement(name = "ArmCorrelationId",namespace = "http://www.finacle.com/fixml")
        private String armCorrelationId;

        @XmlElement(name = "MessageDateTime",namespace = "http://www.finacle.com/fixml")
        private String messageDateTime;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class Security {

        @XmlElement(name = "Token",namespace = "http://www.finacle.com/fixml")
        private Token token;

        @XmlElement(name = "FICertToken",namespace = "http://www.finacle.com/fixml")
        private String fiCertToken;

        @XmlElement(name = "RealUserLoginSessionId",namespace = "http://www.finacle.com/fixml")
        private String realUserLoginSessionId;

        @XmlElement(name = "RealUser",namespace = "http://www.finacle.com/fixml")
        private String realUser;

        @XmlElement(name = "RealUserPwd",namespace = "http://www.finacle.com/fixml")
        private String realUserPwd;

        @XmlElement(name = "SSOTransferToken",namespace = "http://www.finacle.com/fixml")
        private String ssoTransferToken;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class Token {

        @XmlElement(name = "PasswordToken",namespace = "http://www.finacle.com/fixml")
        private PasswordToken passwordToken;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class PasswordToken {

        @XmlElement(name = "UserId",namespace = "http://www.finacle.com/fixml")
        private String userId;

        @XmlElement(name = "Password",namespace = "http://www.finacle.com/fixml")
        private String password;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class Body {

        @XmlElement(name = "PmtAddRequest",namespace = "http://www.finacle.com/fixml")
        private PmtAddRequest pmtAddRequest;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class PmtAddRequest {

        @XmlElement(name = "PmtAddRq",namespace = "http://www.finacle.com/fixml")
        private PmtAddRq pmtAddRq;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class PmtAddRq {

        @XmlElement(name = "PmtProduct",namespace = "http://www.finacle.com/fixml")
        private String pmtProduct;

        @XmlElement(name = "DrAcct",namespace = "http://www.finacle.com/fixml")
        private DrAcct drAcct;

        @XmlElement(name = "RemitAmt",namespace = "http://www.finacle.com/fixml")
        private RemitAmt remitAmt;

        @XmlElement(name = "BeneficiaryDtls",namespace = "http://www.finacle.com/fixml")
        private BeneficiaryDtls beneficiaryDtls;

        @XmlElement(name = "PmtSysId",namespace = "http://www.finacle.com/fixml")
        private String pmtSysId;

        @XmlElement(name = "CrAcct",namespace = "http://www.finacle.com/fixml")
        private CrAcct crAcct;

        @XmlElement(name = "StlmntAcct",namespace = "http://www.finacle.com/fixml")
        private StlmntAcct stlmntAcct;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class DrAcct {

        @XmlElement(name = "AcctId",namespace = "http://www.finacle.com/fixml")
        private String acctId;

        @XmlElement(name = "AcctType",namespace = "http://www.finacle.com/fixml")
        private AcctType acctType;

        @XmlElement(name = "AcctCurr",namespace = "http://www.finacle.com/fixml")
        private String acctCurr;

        @XmlElement(name = "BankInfo",namespace = "http://www.finacle.com/fixml")
        private BankInfo bankInfo;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class AcctType {

        @XmlElement(name = "SchmCode",namespace = "http://www.finacle.com/fixml")
        private String schmCode;

        @XmlElement(name = "SchmType",namespace = "http://www.finacle.com/fixml")
        private String schmType;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class BankInfo {

        @XmlElement(name = "BankId",namespace = "http://www.finacle.com/fixml")
        private String bankId;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class RemitAmt {

        @XmlElement(name = "amountValue",namespace = "http://www.finacle.com/fixml")
        private String amountValue;

        @XmlElement(name = "currencyCode",namespace = "http://www.finacle.com/fixml")
        private String currencyCode;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class BeneficiaryDtls {

        @XmlElement(name = "AddrTypeInd",namespace = "http://www.finacle.com/fixml")
        private String addrTypeInd;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class TranFromAcct {

        @XmlElement(name = "AcctId",namespace = "http://www.finacle.com/fixml")
        private String acctId;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class TranToAcct {

        @XmlElement(name = "AcctId",namespace = "http://www.finacle.com/fixml")
        private String acctId;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class CrAcct {

        @XmlElement(name = "AcctId",namespace = "http://www.finacle.com/fixml")
        private String acctId;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Builder
    public static class StlmntAcct {

        @XmlElement(name = "AcctId",namespace = "http://www.finacle.com/fixml")
        private String acctId;
    }

    public static FIXML from(PaymentDocument paymentDocument)
    {
        // Construct the FIXML object using the Lombok Builder
        FIXML fixml = FIXML.builder()
                .header(FIXML.Header.builder()
                        .requestHeader(FIXML.RequestHeader.builder()
                                .messageKey(getMessageKey(paymentDocument))
                                .requestMessageInfo(getRequestMessageInfo())
                                .security(getSecurity())
                                .build())
                        .build())
                .body(getBody(paymentDocument))
                .build();

        // Print or use the constructed FIXML object
        return fixml;
    }

    private static Body getBody(PaymentDocument paymentDocument) {
        return Body.builder()
                .pmtAddRequest(PmtAddRequest.builder()
                        .pmtAddRq(PmtAddRq.builder()
                                .pmtProduct(getTp(paymentDocument))
                                .drAcct(getDrAcct(paymentDocument))
                                .remitAmt(getRemitAmt(paymentDocument))
                                .beneficiaryDtls(getBeneficiaryDtls(paymentDocument))
                                .pmtSysId(paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getPmtSysId())
                                .crAcct(getCrAcct(paymentDocument))
                                .stlmntAcct(getStlmntAcct(paymentDocument))
                                .build())
                        .build())
                .build();
    }

    private static BeneficiaryDtls getBeneficiaryDtls(PaymentDocument paymentDocument) {
        return BeneficiaryDtls.builder()
                .addrTypeInd(paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getCdTr().getPstlAdr().getAddrTypeInd())
                .build();
    }

    private static RemitAmt getRemitAmt(PaymentDocument paymentDocument) {
        return RemitAmt.builder()
                .amountValue(paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getInstdAmt().getAmt())
                .currencyCode(paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getInstdAmt().getCcy())
                .build();
    }

    private static StlmntAcct getStlmntAcct(PaymentDocument paymentDocument) {
        return StlmntAcct.builder()
                .acctId(paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getSttlmAcct().getId())
                .build();
    }

    private static CrAcct getCrAcct(PaymentDocument paymentDocument) {
        return CrAcct.builder()
                .acctId(getAcctId(paymentDocument))
                .build();
    }

    private static String getAcctId(PaymentDocument paymentDocument) {
        return paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getCdtrAcctList().getId();
    }

    private static DrAcct getDrAcct(PaymentDocument paymentDocument) {
        return DrAcct.builder()
                .acctId(getAccountId(paymentDocument))
                .acctType(AcctType.builder()
                        .schmCode(getSchmCode(paymentDocument))
                        .schmType(getSchmType(paymentDocument))
                        .build())
                .acctCurr(getCurrency(paymentDocument))
                .bankInfo(BankInfo.builder()
                        .bankId("01")
                        .build())
                .build();
    }

    private static String getSchmCode(PaymentDocument paymentDocument) {
        return paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getDbtrAcctList().getTp().getSchmCode();
        //return "";
    }

    private static String getSchmType(PaymentDocument paymentDocument) {
        return paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getDbtrAcctList().getTp().getSchmType();
        //return "";
    }

    private static String getAccountId(PaymentDocument paymentDocument) {
        return paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getDbtrAcctList().getId();
    }

    private static String getCurrency(PaymentDocument paymentDocument) {
        return paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getDbtrAcctList().getCcy();
    }

    private static String getTp(PaymentDocument paymentDocument) {
        return paymentDocument.getCstmrCdtTrfInitn().getPmtInf().getPmtTpInf().getPmtTp();
    }

    private static Security getSecurity() {
        return Security.builder()
                .token(Token.builder()
                        .passwordToken(PasswordToken.builder()
                                .userId("")
                                .password("")
                                .build())
                        .build())
                .fiCertToken("")
                .realUserLoginSessionId("")
                .realUser("")
                .realUserPwd("")
                .ssoTransferToken("")
                .build();
    }

    private static RequestMessageInfo getRequestMessageInfo() {
        return RequestMessageInfo.builder()
                .bankId("01")
                .timeZone("")
                .entityId("")
                .entityType("")
                .armCorrelationId("")
                .messageDateTime(DateTimeUtil.currentTime())
                .build();
    }

    private static MessageKey getMessageKey(PaymentDocument paymentDocument) {
        return MessageKey.builder()
                .requestUUID(paymentDocument.getCstmrCdtTrfInitn().getGrpHdr().getMsgId())
                .serviceRequestId("PmtAdd")
                .serviceRequestVersion("10.2")
                .channelId("COR")
                .languageId("")
                .build();
    }
}

