package com.example.demo.controller;

import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;

public class CustomNamespacePrefixMapper extends NamespacePrefixMapper {
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if ("urn:iso:std:iso:20022:tech:xsd:pain.001.001.03".equals(namespaceUri)) {
            return "ns";  // or any prefix you prefer
        }
        return null;
    }
}

