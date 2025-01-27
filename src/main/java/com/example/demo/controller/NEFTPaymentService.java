package com.example.demo.controller;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.Optional;

import static com.example.demo.controller.XMLUtil.convertToXml;
import static com.example.demo.controller.PaymentDocument.*;
import static com.example.demo.controller.PaymentDocument.CstmrCdtTrfInitn.*;

@Service
public class NEFTPaymentService {

    private final FakePaymentServer fakePaymentService = new FakePaymentServer();

    // Method to convert ISO 20022 XML to FIXML format and send to Finacle
    public Optional<String> makePayment(String iso20022Xml) {
        return unmarshalISO20022Xml(iso20022Xml)
                .map(this::convertToFixml)
                .flatMap(this::sendToFinacle)
                .map(this::convertPaymentResponse);
    }

    private Optional<PaymentDocument> unmarshalISO20022Xml(String iso20022Xml) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PaymentDocument.class,
                    CstmrCdtTrfInitn.class, GrpHdr.class, PmtInf.class,
                    CdtrAcct.class, DbtrAcct.class, InstdAmt.class,
                    PmtTpInf.class, SttlmAcct.class, Cdtr.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(iso20022Xml);
            PaymentDocument paymentDocument = (PaymentDocument) unmarshaller.unmarshal(reader);
            return Optional.of(paymentDocument);
        } catch (JAXBException e) {
            // log the exception if needed
            return Optional.empty();
        }
    }

    private String convertToFixml(PaymentDocument paymentRequest) {
        try {
            FIXML fixml = FIXML.from(paymentRequest);
            return convertToXml(fixml);
        } catch (JAXBException e) {
            // log the exception if needed
            return null;
        }
    }

    private Optional<FixmlResponse> sendToFinacle(String fixmlXml)
    {
        return fakePaymentService.postTransaction(fixmlXml);
    }
    @SneakyThrows
    private String convertPaymentResponse(FixmlResponse fixmlResponse) {
        PaymentResponse payResponse = PaymentResponse.from(fixmlResponse);
        return XMLUtil.convertToXml(payResponse);
    }
}
