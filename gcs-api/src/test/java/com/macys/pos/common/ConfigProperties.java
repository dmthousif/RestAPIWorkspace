package com.macys.pos.common;

import com.macys.pos.enums.Properties;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.configuration.SystemPropertiesConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;

public class ConfigProperties {

    private static Configuration configuration = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
    private static EnvironmentVariables environmentVariables = configuration.getEnvironmentVariables();
    private static String baseUrl = "";
    private static String sourceBucketName = "";
    private static String projectId = "";

    public static String getSourceBucketName() {
        return (sourceBucketName.length() == 0) ?
                sourceBucketName = getProperty(Properties.BUCKET_NAME.getProperty()) :
                sourceBucketName;
    }

    public static String getProjectId() {
        return (projectId.length() == 0) ?
                projectId = getProperty(Properties.PROJECT_ID.getProperty()) :
                projectId;
    }

    public static String getBaseUrl() {
        return (baseUrl.length() == 0) ?
                baseUrl = getProperty(Properties.ENDPOINT.getProperty()) :
                baseUrl;
    }

    public static String getProperty(String property) {
        String environment = (System.getProperty(Properties.ENVIRONMENT.getProperty()) == null) ?
                Properties.DEFAULT.getProperty() :
                System.getProperty(Properties.ENVIRONMENT.getProperty());
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("environments." + environment + "." + property);
    }

}
