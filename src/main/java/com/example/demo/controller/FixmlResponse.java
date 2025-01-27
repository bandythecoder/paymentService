package com.example.demo.controller;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "FIXML",namespace = "http://www.finacle.com/fixml")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class FixmlResponse {

    @XmlElement(name = "Header",namespace = "http://www.finacle.com/fixml")
    private Header header;

    @XmlElement(name = "Body",namespace = "http://www.finacle.com/fixml")
    private Body body;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Setter
    public static class Header {

        @XmlElement(name = "ResponseHeader",namespace = "http://www.finacle.com/fixml")
        private ResponseHeader responseHeader;

        @XmlAccessorType(XmlAccessType.FIELD)
        @Getter
        @Setter
        public static class ResponseHeader {

            @XmlElement(name = "RequestMessageKey",namespace = "http://www.finacle.com/fixml")
            private RequestMessageKey requestMessageKey;

            @XmlElement(name = "ResponseMessageInfo",namespace = "http://www.finacle.com/fixml")
            private ResponseMessageInfo responseMessageInfo;

            @XmlElement(name = "UBUSTransaction",namespace = "http://www.finacle.com/fixml")
            private UBUSTransaction ubusTransaction;

            @XmlElement(name = "HostTransaction",namespace = "http://www.finacle.com/fixml")
            private HostTransaction hostTransaction;

            @XmlElement(name = "HostParentTransaction",namespace = "http://www.finacle.com/fixml")
            private HostParentTransaction hostParentTransaction;

            @XmlElement(name = "CustomInfo",namespace = "http://www.finacle.com/fixml")
            private String customInfo;

            @XmlAccessorType(XmlAccessType.FIELD)
            @Getter
            @Setter
            public static class RequestMessageKey {
                @XmlElement(name = "GlobalUUID",namespace = "http://www.finacle.com/fixml")
                private String globalUUID;

                @XmlElement(name = "RequestUUID",namespace = "http://www.finacle.com/fixml")
                private String requestUUID;

                @XmlElement(name = "ServiceRequestId",namespace = "http://www.finacle.com/fixml")
                private String serviceRequestId;

                @XmlElement(name = "ServiceId",namespace = "http://www.finacle.com/fixml")
                private String serviceId;

                @XmlElement(name = "ServiceRequestVersion",namespace = "http://www.finacle.com/fixml")
                private String serviceRequestVersion;

                @XmlElement(name = "ServiceVersion",namespace = "http://www.finacle.com/fixml")
                private String serviceVersion;

                @XmlElement(name = "ChannelId",namespace = "http://www.finacle.com/fixml")
                private String channelId;

                @XmlElement(name = "OriginatorId",namespace = "http://www.finacle.com/fixml")
                private String originatorId;

                @XmlElement(name = "OriginatorInstanceId",namespace = "http://www.finacle.com/fixml")
                private String originatorInstanceId;

                @XmlElement(name = "OriginatorVersion",namespace = "http://www.finacle.com/fixml")
                private String originatorVersion;

                @XmlElement(name = "LanguageId",namespace = "http://www.finacle.com/fixml")
                private String languageId;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @Getter
            @Setter
            public static class ResponseMessageInfo {
                @XmlElement(name = "BankId",namespace = "http://www.finacle.com/fixml")
                private String bankId;

                @XmlElement(name = "TimeZone",namespace = "http://www.finacle.com/fixml")
                private String timeZone;

                @XmlElement(name = "MessageDateTime",namespace = "http://www.finacle.com/fixml")
                private String messageDateTime;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @Getter
            @Setter
            public static class UBUSTransaction {
                @XmlElement(name = "Id",namespace = "http://www.finacle.com/fixml")
                private String id;

                @XmlElement(name = "Status",namespace = "http://www.finacle.com/fixml")
                private String status;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @Getter
            @Setter
            public static class HostTransaction {
                @XmlElement(name = "Id",namespace = "http://www.finacle.com/fixml")
                private String id;

                @XmlElement(name = "Status",namespace = "http://www.finacle.com/fixml")
                private String status;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @Getter
            @Setter
            public static class HostParentTransaction {
                @XmlElement(name = "Id",namespace = "http://www.finacle.com/fixml")
                private String id;

                @XmlElement(name = "Status",namespace = "http://www.finacle.com/fixml")
                private String status;
            }
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @Setter
    public static class Body {

        @XmlElement(name = "Error",namespace = "http://www.finacle.com/fixml")
        private Error error;

        @XmlAccessorType(XmlAccessType.FIELD)
        @Getter
        @Setter
        public static class Error {

            @XmlElement(name = "FIBusinessException",namespace = "http://www.finacle.com/fixml")
            private FIBusinessException fibusinessException;

            @XmlAccessorType(XmlAccessType.FIELD)
            @Getter
            @Setter
            public static class FIBusinessException {
                @XmlElement(name = "ErrorDetail",namespace = "http://www.finacle.com/fixml")
                private List<ErrorDetail> errorDetails;

                @XmlAccessorType(XmlAccessType.FIELD)
                @Getter
                @Setter
                public static class ErrorDetail {
                    @XmlElement(name = "ErrorCode",namespace = "http://www.finacle.com/fixml")
                    private String errorCode;

                    @XmlElement(name = "ErrorDesc",namespace = "http://www.finacle.com/fixml")
                    private String errorDesc;

                    @XmlElement(name = "ErrorSource",namespace = "http://www.finacle.com/fixml")
                    private String errorSource;

                    @XmlElement(name = "ErrorType",namespace = "http://www.finacle.com/fixml")
                    private String errorType;
                }
            }
        }
    }
}

