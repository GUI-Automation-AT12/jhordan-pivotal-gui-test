package org.fundacionjala.core.selenium.webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

/**
 * This class creates a instance Chrome.
 *
 * @author Jhordan Soto
 * @version 1.0
 */
public class Chrome implements IDriver {

    @Override
    public WebDriver initDriver() {

        ChromeDriverManager.getInstance(CHROME).version("87.0.4280.88").setup();
        return new ChromeDriver();
    }
}
