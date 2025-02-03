package com.example.demo.controller;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;

@Service
public class NEFTPaymentService {

    public void makePayment(PaymentRequestAPI paymentRequest) throws JAXBException {
        FIXML fixml = FIXML.from(paymentRequest);
        var context = getJaxbContext();
        var marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        var stringWriter = new StringWriter();
        marshaller.marshal(fixml, stringWriter);
        var xml = stringWriter.toString();
    }


    private  JAXBContext getJaxbContext() throws JAXBException {
        return JAXBContext.newInstance(
                FIXML.class,
                Header.class,
                RequestHeader.class,
                MessageKey.class,
                RequestMessageInfo.class,
                Body.class,
                PmtAddRequest.class,
                PmtAddRq.class,
                Account.class,
                BankInfo.class,
                RemitAmt.class,
                BeneficiaryDtls.class,
                InstitutionDtls.class,
                PmtAddCustomData.class
        );
    }

}
