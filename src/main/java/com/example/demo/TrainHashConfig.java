package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hashpass")
public class TrainHashConfig {
    private String trainCreate;
    private String trainRead;
    private String trainUpdate;
    private String trainDelete;
}
