package org.fundacionjala.core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class EnvironmentProperties {

    /**
     * Constructor of the Class.
     */
    private EnvironmentProperties() {

    }
    /**
     * Initialize a new GetProperties.
     * @return GetProperties.
     */
    public static EnvironmentProperties getInstance() {
        return new EnvironmentProperties();
    }

    /**
     * Gets properties from properties file.
     *
     * @param path - Path of Gradle properties file.
     * @return Properties.
     */
    public static Properties getProperties(final String path) {

        try  {
            InputStream input = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException ioe) {
            throw new RuntimeException(ioe + path + " could not be read.");
        }
    }
}
