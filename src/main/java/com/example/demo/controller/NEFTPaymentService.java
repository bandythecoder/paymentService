package com.example.demo.controller;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import java.io.StringReader;
import java.io.StringWriter;
import com.example.demo.controller.PaymentDocument.*;
import com.example.demo.controller.PaymentDocument.CstmrCdtTrfInitn.*;

@Service
public class NEFTPaymentService {

    // Method to convert ISO 20022 XML to FIXML format and send to Finacle
    public String convertToFixmlAndSend(String iso20022Xml) throws JAXBException {
        // Step 1: Unmarshal the incoming ISO20022 XML to a Java object
        PaymentDocument paymentRequest = unmarshalISO20022Xml(iso20022Xml);

//         Step 2: Convert the PaymentRequest object to FIXML format
       String fixmlXml = convertToFixml(paymentRequest);

        // Step 3: Send the converted FIXML to Finacle (Example)
        sendToFinacle(fixmlXml);

        return null;  // Return the generated FIXML XML
    }

    // Unmarshal the ISO20022 XML into a PaymentRequest Java object
    private PaymentDocument unmarshalISO20022Xml(String iso20022Xml) throws JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PaymentDocument.class,
                    CstmrCdtTrfInitn.class, GrpHdr.class, PmtInf.class,
                    CdtrAcct.class, DbtrAcct.class, InstdAmt.class,
                    PmtTpInf.class, SttlmAcct.class,Cdtr.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(iso20022Xml);
            return (PaymentDocument) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
            throw e;
        }
    }


    // Convert the PaymentRequest object to FIXML XML format
    private String convertToFixml(PaymentDocument paymentRequest) throws JAXBException {
        FIXML fixml = FIXML.from(paymentRequest);
        JAXBContext jaxbContext = JAXBContext.newInstance(FIXML.class);

        // Create marshaller
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // This is valid for marshalling only

        // Convert the PaymentRequest to FIXML XML
        StringWriter writer = new StringWriter();
        marshaller.marshal(fixml, writer);

        return writer.toString();
       // return null;
    }

    // Example: sending the FIXML to Finacle (you can implement this logic as per your system)
    private void sendToFinacle(String fixmlXml) {
        // Send the FIXML XML to Finacle through HTTP or any other communication protocol
        // For example, making an HTTP POST request to Finacle API
    }
}
