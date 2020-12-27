package org.fundacionjala.core.selenium.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * This Interface is to init a driver.
 *
 * @author Jhordan Soto
 * @version 1.0
 */
public interface IDriver {

    /**
     * This method initialize browser.
     *
     * @return a IDriver
     */
    WebDriver initDriver();
}

