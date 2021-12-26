package com.springdongrest.springdongrest.common;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.operation.preprocess.Preprocessors;

@TestConfiguration
public class RestDocConfiguration {

    @Bean
    public RestDocsMockMvcConfigurationCustomizer restDocsMockMvcConfigurationCustomizer(){
        return configurer -> configurer.operationPreprocessors()
                .withRequestDefaults(Preprocessors.prettyPrint())
                .withResponseDefaults(Preprocessors.prettyPrint());
    }
}
