package com.example.tanakinator2.dao;

import com.example.tanakinator2.configuration.ApiCallConfigurationProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class Tanakinator2DaoImpl implements Tanakinator2Dao, InitializingBean {
    private final ApiCallConfigurationProperties properties;
    private final RestOperations restOperations;
    private String apiUriPrefix;

    public Tanakinator2DaoImpl(ApiCallConfigurationProperties properties, RestOperations restOperations) {
        this.properties = properties;
        this.restOperations = restOperations;
    }

    @Override
    public String getMessage() {
        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(apiUriPrefix);
        return restOperations.getForObject(
                builder.build().toUriString(),
                String.class
        );
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        apiUriPrefix = "http://" + properties.getHost() + ":"
                + properties.getPort() + "/api";
    }
}
