package org.fundacionjala.core.selenium.webdriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;
import java.util.HashMap;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

/**
 * This class creates a instance of FireFox.
 *
 * @author Jhordan Soto
 * @version 1.0
 */
public class FireFox implements IDriver {

    /**
     * Initializes FireFox driver.
     * @return A new geckodriver.
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FIREFOX).version("73.0.1").setup();
        return new FirefoxDriver();
    }
}