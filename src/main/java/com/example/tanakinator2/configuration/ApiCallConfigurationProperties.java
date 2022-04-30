package com.example.tanakinator2.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "tanakinator2.api.call")
public class ApiCallConfigurationProperties {
    private final String host;
    private final int port;

    public ApiCallConfigurationProperties(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
}
