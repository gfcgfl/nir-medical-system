package com.zju.medical.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaoguo
 */
@Configuration
@ConfigurationProperties(prefix = "report-img")
public class ReportImageConfig {

    private String drawWith;

    public String getDrawWith() {
        return drawWith;
    }

    public void setDrawWith(String drawWith) {
        this.drawWith = drawWith;
    }
}
