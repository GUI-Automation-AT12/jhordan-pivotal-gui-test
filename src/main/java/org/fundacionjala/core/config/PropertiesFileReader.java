package org.fundacionjala.core.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.throwables.EnvironmentReadingException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    private static final Logger LOGGER = LogManager.getLogger(EnvironmentProperties.class);
    private final Properties property;
    private final FileReader reader;

    /**
     * Initializes an instance of properties files.
     * @param propertiesPath
     */
    public PropertiesFileReader(final String propertiesPath) throws EnvironmentReadingException {
        try {
            reader = new FileReader(propertiesPath);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            LOGGER.error("Error when reading file");
            LOGGER.error(e.getMessage());
            throw new EnvironmentReadingException("Error when reading properties file");
        } catch (IOException e) {
            LOGGER.error("Error getting properties");
            LOGGER.error(e.getMessage());
            throw new EnvironmentReadingException("Error getting properties");
        } finally {
            closeReader();
        }
    }

    /**
     * Gets environment property.
     * @param env
     * @return property value.
     */
    public String getProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }

    /**
     * Nethod that closes the reader.
     * @throws EnvironmentReadingException
     */
    private void closeReader() throws EnvironmentReadingException {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error("Cannot close file Reader.");
            throw new EnvironmentReadingException("Cannot close File Reader.");
        }
    }
}
