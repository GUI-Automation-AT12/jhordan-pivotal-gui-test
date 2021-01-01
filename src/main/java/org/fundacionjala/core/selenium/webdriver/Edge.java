package org.fundacionjala.core.selenium.webdriver;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;

/**
 * This class creates a instance of Edge.
 *
 * @author Jhordan Soto
 * @version 1.0
 */
public class Edge implements IDriver {

    @Override
    public WebDriver initDriver() {

        EdgeDriverManager.getInstance(EDGE).version("87.0.664.66").setup();
        return new EdgeDriver();
    }
}