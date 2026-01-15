package com.vanilla.topup.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;


@Configuration
public class RestClientConfig {

    @Value("${account-service.base-url:http://localhost:8081}")
    private String accountServiceBaseUrl;

    @Bean
    public RestClient accountRestClient() {
        return RestClient.builder()
                .baseUrl(accountServiceBaseUrl)
                .build();
    }


}
