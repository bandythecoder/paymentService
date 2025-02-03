package com.example.demo.controller;

import jakarta.xml.bind.annotation.*;
import lombok.*;

@XmlRootElement(name = "FIXML")
@XmlAccessorType(XmlAccessType.FIELD)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FIXML {
    @XmlElement(name = "Header")
    private Header header;
    @XmlElement(name = "Body")
    private Body body;

    public static FIXML from(PaymentRequestAPI paymentRequestAPI) {
        return FIXML.builder()
                .header(Header.builder()
                        .requestHeader(RequestHeader.builder()
                                .messageKey(getMessageKey(paymentRequestAPI))
                                .requestMessageInfo(getMessageInfo(paymentRequestAPI))
                                .build())
                        .build())
                .body(Body.builder()
                        .pmtAddRequest(getPmtAddRequest(paymentRequestAPI))
                        .build())
                .build();
    }

    private static PmtAddRequest getPmtAddRequest(PaymentRequestAPI paymentRequestAPI) {
        return PmtAddRequest.builder()
                .pmtAddRq(getPmtAddRq(paymentRequestAPI))
                .pmtAddCustomData(PmtAddCustomData.builder()
                        .awi(getAwi(paymentRequestAPI))
                        .senderInfo3("10")
                        .build())
                .build();
    }

    private static PmtAddRq getPmtAddRq(PaymentRequestAPI paymentRequestAPI) {
        return PmtAddRq.builder()
                .pmtProduct("CT")
                .drAcct(getDrAcct(paymentRequestAPI))
                .remitAmt(RemitAmt.builder()
                        .amountValue(getAmount(paymentRequestAPI).getValue())
                        .currencyCode(getAmount(paymentRequestAPI).getCurrency())
                        .build())
                .crAcct(getCrAcct(paymentRequestAPI))
                .pmtSysId(getPmtSysId(paymentRequestAPI))
                .institutionDtls(getInstitutionalDtls(paymentRequestAPI))
                .build();
    }

    private static InstitutionDtls getInstitutionalDtls(PaymentRequestAPI paymentRequestAPI)
    {
        return InstitutionDtls.builder()
                .addrTypeInd(getCrAddrTypeInd(paymentRequestAPI))
                .build();
    }

    private static String getCrAddrTypeInd(PaymentRequestAPI paymentRequestAPI) {
        return paymentRequestAPI.getPaymentInformation().getPayee().getPostalAddress().getAddressType();
    }

    private static String getPmtSysId(PaymentRequestAPI paymentRequestAPI)
    {
        return paymentRequestAPI.getPaymentInformation().getPaymentMethod();
    }

    private static String getAwi(PaymentRequestAPI paymentRequestAPI) {
        return paymentRequestAPI.getPaymentInformation().getPayee().getAccount().getIfscCode();
    }

    private static PaymentRequestAPI.Amount getAmount(PaymentRequestAPI paymentRequestAPI) {
        return paymentRequestAPI.getPaymentInformation().getPayer().getAmount();
    }

    private static Account getDrAcct(PaymentRequestAPI paymentRequestAPI) {
        return Account.builder()
                .acctId(getAcctId(paymentRequestAPI))
                .bankInfo(getPayerBankInfo(paymentRequestAPI))
                .build();
    }

    private static Account getCrAcct(PaymentRequestAPI paymentRequestAPI) {
        return Account.builder()
                .acctId(getCrAcctId(paymentRequestAPI))
                .build();
    }

    private static BankInfo getPayerBankInfo(PaymentRequestAPI paymentRequestAPI) {
        return BankInfo.builder()
                .bankId(getBankId(paymentRequestAPI))
                .build();
    }

    private static String getAcctId(PaymentRequestAPI paymentRequestAPI) {
        return paymentRequestAPI.
                getPaymentInformation().
                getPayer().
                getAccount().
                getId();
    }
    private static String getCrAcctId(PaymentRequestAPI paymentRequestAPI) {
        return paymentRequestAPI.
                getPaymentInformation().
                getPayee().
                getAccount().
                getId();
    }
    private static RequestMessageInfo getMessageInfo(PaymentRequestAPI paymentRequestAPI) {
        return RequestMessageInfo.builder()
                .bankId(getBankId(paymentRequestAPI))
                .messageDateTime(getMessageDateTime(paymentRequestAPI))
                .build();
    }

    private static String getMessageDateTime(PaymentRequestAPI paymentRequestAPI) {
        return paymentRequestAPI.getTransaction().getCreationTimestamp();
    }

    private static String getBankId(PaymentRequestAPI paymentRequestAPI) {
        return paymentRequestAPI.getPaymentInformation().getPayer().getAccount().getBankInfo().getBankId();
    }

    private static MessageKey getMessageKey(PaymentRequestAPI paymentRequestAPI) {
        return MessageKey.builder()
                .requestUUID(paymentRequestAPI.getTransaction().getId())
                .serviceRequestId("PmtAdd")
                .serviceRequestVersion("10.2")
                .channelId("RTS")
                .build();
    }
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
class Header {
    @XmlElement(name = "RequestHeader")
    private RequestHeader requestHeader;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class RequestHeader {
    @XmlElement(name = "MessageKey")
    private MessageKey messageKey;

    @XmlElement(name = "RequestMessageInfo")
    private RequestMessageInfo requestMessageInfo;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class MessageKey {
    @XmlElement(name = "RequestUUID")
    private String requestUUID;

    @XmlElement(name = "ServiceRequestId")
    private String serviceRequestId;

    @XmlElement(name = "ServiceRequestVersion")
    private String serviceRequestVersion;

    @XmlElement(name = "ChannelId")
    private String channelId;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class RequestMessageInfo {
    @XmlElement(name = "BankId")
    private String bankId;

    @XmlElement(name = "MessageDateTime")
    private String messageDateTime;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class Body {
    @XmlElement(name = "PmtAddRequest")
    private PmtAddRequest pmtAddRequest;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class PmtAddRequest {
    @XmlElement(name = "PmtAddRq")
    private PmtAddRq pmtAddRq;

    @XmlElement(name = "PmtAdd_CustomData")
    private PmtAddCustomData pmtAddCustomData;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class PmtAddRq {
    @XmlElement(name = "PmtProduct")
    private String pmtProduct;

    @XmlElement(name = "DrAcct")
    private Account drAcct;

    @XmlElement(name = "RemitAmt")
    private RemitAmt remitAmt;

    @XmlElement(name = "ChrgAcct")
    private Account chrgAcct;

    @XmlElement(name = "BeneficiaryDtls")
    private BeneficiaryDtls beneficiaryDtls;

    @XmlElement(name = "InstitutionDtls")
    private InstitutionDtls institutionDtls;

    @XmlElement(name = "PmtSysId")
    private String pmtSysId;

    @XmlElement(name = "CrAcct")
    private Account crAcct;

    @XmlElement(name = "StlmntAcct")
    private Account stlmntAcct;
}
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Account {
    @XmlElement(name = "AcctId")
    private String acctId;

    @XmlElement(name = "BankInfo")
    private BankInfo bankInfo;
}
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BankInfo {
    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "BankId")
    private String bankId;

    @XmlElement(name = "BranchId")
    private String branchId;

    @XmlElement(name = "BranchName")
    private String branchName;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class RemitAmt {
    @XmlElement(name = "amountValue")
    private double amountValue;

    @XmlElement(name = "currencyCode")
    private String currencyCode;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class BeneficiaryDtls {
    @XmlElement(name = "AddrTypeInd")
    private String addrTypeInd;

    @XmlElement(name = "Name")
    private String name;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class InstitutionDtls {
    @XmlElement(name = "AddrTypeInd")
    private String addrTypeInd;

    @XmlElement(name = "Name")
    private String name;
}

@Builder
@NoArgsConstructor
@AllArgsConstructor
class PmtAddCustomData {
    @XmlElement(name = "AWI")
    private String awi;

    @XmlElement(name = "SENDERINFO3")
    private String senderInfo3;

    @XmlElement(name = "REMITINFO1")
    private String remitInfo1;

    @XmlElement(name = "REMITINFO2")
    private String remitInfo2;

    @XmlElement(name = "REMITINFO3")
    private String remitInfo3;

    @XmlElement(name = "REMITINFO4")
    private String remitInfo4;

    @XmlElement(name = "SENDERINFO4")
    private String senderInfo4;  // Updated to String

    @XmlElement(name = "SENDERINFO1")
    private String senderInfo1;

    @XmlElement(name = "SENDERINFO2")
    private String senderInfo2;

    @XmlElement(name = "SENDERINFO5")
    private String senderInfo5;

    @XmlElement(name = "SENDERINFO6")
    private String senderInfo6;

}



