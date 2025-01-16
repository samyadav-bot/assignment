package com.example.Project1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="service2")
public class Service2AppProperties {

    String host;
    int port;
    String callingEndPoint;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getCallingEndPoint() {
        return callingEndPoint;
    }

    public void setCallingEndPoint(String callingEndPoint) {
        this.callingEndPoint = callingEndPoint;
    }
}
