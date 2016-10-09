package com.tydic.dubbo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
@Data
@ConfigurationProperties(prefix = "dubbo")
public class DubboProperties {

    private String name;
    private String registry = "127.0.0.1:2181";
    private Integer port = -1;
    private Integer timeout = 1000;
    private Integer threads = 2;
    private Integer heartBeats = 30000;
    private String host;
    private String serialization;
    private String version;
    private String mode = "provider";

}