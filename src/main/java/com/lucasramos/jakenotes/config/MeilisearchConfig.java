package com.lucasramos.jakenotes.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeilisearchConfig{

    @Value("${spring.data.meilisearch.host}")
    private String host;

    @Value("${spring.data.meilisearch.masterKey}")
    private String masterKey;

    @Bean
    public Client meilisearchClient() {
        return new Client(new Config(host, masterKey));
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }
}