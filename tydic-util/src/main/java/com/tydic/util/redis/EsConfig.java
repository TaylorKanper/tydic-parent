package com.tydic.util.redis;

import lombok.Data;

@Data
//@ConfigurationProperties(prefix = "es")
public class EsConfig {
    private String ESContionType;
    private String gomeESCusterName;
    private Boolean ESSniff;
    private String ESPort;
    private String gomeESHosts;

}

