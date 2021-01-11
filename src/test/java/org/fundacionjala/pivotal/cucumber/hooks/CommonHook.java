package org.fundacionjala.pivotal.cucumber.hooks;

import org.fundacionjala.core.selenium.WebDriverManager;
import io.cucumber.java.After;

public class CommonHook {

    @After
    public void close() {
        WebDriverManager.getInstance().quit();
    }
}
