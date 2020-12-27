package org.fundacionjala.core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public final class WebDriverManager {
    // Content WebDriverManager.
    private static WebDriverManager webDriverManager;

    // Content WebDriver.
    private WebDriver webDriver;

    // Content WebDriverWait.
    private WebDriverWait webDriverWait;

    /**
     * this method is used for initializes the variables.
     */
    private WebDriverManager() {
        initializes();
    }

    /**
     * This method is used for instantiate the WebDriverManager class.
     *
     * @return a webDriverManager.
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null || webDriverManager.webDriver == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    /**
     * This method is used for initializes the variables.
     */
    private void initializes() {
        this.webDriver = WebDriverFactory.getWebDriver(DriverProperties.getInstance().getBrowser());
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(DriverProperties.getInstance().getImplicitWaitTime(),
                TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, DriverProperties.getInstance().getExplicitWaitTime(),
                DriverProperties.getInstance().getSleepWait());
    }


    /**
     * Uses to get a WebDriver.
     *
     * @return a WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Uses to get a WebDriverWait.
     *
     * @return a WebDriverWait.
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public void quit() {
        webDriver.quit();
    }
}
