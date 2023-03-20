package com.example.vapiclientsdk;

import com.example.vapiclientsdk.client.VapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("vapi.client")
@Data
@ComponentScan
public class vapiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public VapiClient vapiClient(){
        return new VapiClient(accessKey,secretKey);
    }


}
