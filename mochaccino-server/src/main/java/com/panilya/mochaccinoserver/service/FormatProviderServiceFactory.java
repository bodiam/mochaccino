package com.panilya.mochaccinoserver.service;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatProviderServiceFactory {

    private final Faker faker;

    @Autowired
    public FormatProviderServiceFactory(Faker faker) {
        this.faker = faker;
    }

    public ProviderService createProviderService(DataFormat dataFormat) {
        switch (dataFormat) {
            case CSV:
                return new CsvFormatProviderService(faker);
            case JSON:
                return new JsonFormatProviderService(faker);
            default:
                throw new IllegalStateException("Error in ProviderServiceFactory");
        }
    }
}
