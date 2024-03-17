package com.macys.pos.enums;

public enum Properties {
    ENDPOINT("api.endpoint"),
    BUCKET_NAME("gcs.file.manager.bucket"),
    PROJECT_ID("spring.cloud.gcp.project-id"),
    ENVIRONMENT("environment"),
    DEFAULT("default");

    String property;

    Properties(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
