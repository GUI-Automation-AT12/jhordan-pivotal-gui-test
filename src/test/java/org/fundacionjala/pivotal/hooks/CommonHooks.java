package org.fundacionjala.pivotal.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.selenium.WebDriverManager;

public class CommonHooks {

    /**
     * Close Navigator.
     */
    @After()
    public void afterScenario() {
        WebDriverManager.getInstance().quit();
    }
}
