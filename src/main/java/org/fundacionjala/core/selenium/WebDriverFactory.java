package org.fundacionjala.core.selenium;

import org.fundacionjala.core.selenium.webdriver.Chrome;
import org.fundacionjala.core.selenium.webdriver.Edge;
import org.fundacionjala.core.selenium.webdriver.FireFox;
import org.fundacionjala.core.selenium.webdriver.IDriver;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is to select a browser.
 *
 * @author Jhordan Soto
 * @version 1.0
 */
public final class WebDriverFactory {

    /**
     * Contructor of the class.
     */
    private WebDriverFactory() {

    }

    private static Map<String, IDriver> browsers = new HashMap<>();
    static {
        browsers.put("chrome", new Chrome());
        browsers.put("firefox", new FireFox());
        browsers.put("edge", new Edge());

    }

    /**
     * Uses for select a Browser.
     *
     * @param browser Parameter content a Browser Name.
     * @return a webDriver.
     */
    public static WebDriver getWebDriver(final String browser) {
        return browsers.get(browser).initDriver();
    }
}

