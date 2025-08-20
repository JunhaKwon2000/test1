package com.winter.app.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siot.IamportRestClient.IamportClient;

@Configuration
public class IamportConfig {
	
    @Value("${imp.api.key}")
    private String apiKey;
 
    @Value("${imp.api.secretkey}")
    private String secretKey;
	
    @Bean
    IamportClient iamportClient() {
        return new IamportClient(apiKey, secretKey);
    }

}
