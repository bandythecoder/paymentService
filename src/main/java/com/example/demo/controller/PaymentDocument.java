package com.example.demo.controller;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
@Getter
public class PaymentDocument {
    @XmlElement(name = "CstmrCdtTrfInitn",namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
    private CstmrCdtTrfInitn cstmrCdtTrfInitn;
    @Getter
    public static class CstmrCdtTrfInitn {

    @XmlElement(name = "GrpHdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
    private GrpHdr grpHdr;
    @XmlElement(name = "PmtInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
    private PmtInf pmtInf;
    @Getter
    public static class GrpHdr {
        @XmlElement(name = "MsgId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String msgId;
        @XmlElement(name = "MsgNmId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String msgNmId;
        @XmlElement(name = "MsgRspn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String msgRspn;
    }
    @Getter
    public static class InstdAmt {
        @XmlElement(name = "Amt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String amt;
        @XmlElement(name = "Ccy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String ccy;
    }

    public static class CdtrAcct {

        private String id;

        @XmlElement(name = "Id", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
    @Getter
    public static class DbtrAcct {
        @XmlElement(name = "Id", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String id;

        @XmlElement(name = "Tp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private Tp tp;
        @XmlElement(name = "Ccy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String ccy;


        // Nested class for 'Tp' (Account Type)

    }

        public static class Tp {
            private String schmCode;
            private String schmType;

            @XmlElement(name = "SchmCode", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
            public String getSchmCode() {
                return schmCode;
            }

            public void setSchmCode(String schmCode) {
                this.schmCode = schmCode;
            }

            @XmlElement(name = "SchmType", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
            public String getSchmType() {
                return schmType;
            }

            public void setSchmType(String schmType) {
                this.schmType = schmType;
            }
        }
    @Getter
    public static class Cdtr {
        @XmlElement(name = "PstlAdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private PstlAdr pstlAdr;
    }
    @Getter
    public static class PstlAdr {
        @XmlElement(name = "AddrTypeInd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String addrTypeInd;
    }
    @Getter
    public static class PmtInf {
        @XmlElement(name = "PmtTpInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private PmtTpInf pmtTpInf;
        @XmlElement(name = "DbtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private DbtrAcct dbtrAcctList;
        @XmlElement(name = "CdtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private CdtrAcct cdtrAcctList;
        @XmlElement(name = "SttlmAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private SttlmAcct sttlmAcct;
        @XmlElement(name = "InstdAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private InstdAmt instdAmt;
        @XmlElement(name = "PmtSysId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String pmtSysId;
        @XmlElement(name = "Cdtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private Cdtr cdTr;
    }
    @Getter
    public static class PmtTpInf {
        @XmlElement(name = "PmtTp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String pmtTp;
    }
    @Getter
    public static class SttlmAcct {
        @XmlElement(name = "Id", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.03")
        private String id;
    }
}
}
