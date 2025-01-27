package com.example.demo.controller;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.Optional;
import java.net.URISyntaxException;

import static com.example.demo.controller.JAXBUtil.getUnmarshaller;

public class FakePaymentServer {

    public Optional<FixmlResponse> postTransaction(String fixmlXml) {
        return getInputStream("response.xml")
                .map(this::unmarshalXML);
    }

    private Optional<InputStream> getInputStream(String resourceName) {
        try {
            URI resourceUri = NEFTPaymentService.class.getClassLoader().getResource(resourceName).toURI();
            return Optional.of(Files.newInputStream(Paths.get(resourceUri)));
        } catch (IOException | URISyntaxException e) {
            return Optional.empty();
        }
    }

    private FixmlResponse unmarshalXML(InputStream inputStream) {
        return safeUnmarshal(inputStream, FixmlResponse.class)
                .orElseThrow(() -> new RuntimeException("Failed to unmarshal XML to FixmlResponse"));
    }

    private <T> Optional<T> safeUnmarshal(InputStream inputStream, Class<T> clazz) {
        try {
            Unmarshaller unmarshaller = getUnmarshaller(clazz);
            return Optional.ofNullable((T) unmarshaller.unmarshal(inputStream));
        } catch (JAXBException e) {
            return Optional.empty();
        }
    }
}
