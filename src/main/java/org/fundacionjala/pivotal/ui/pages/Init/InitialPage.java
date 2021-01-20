package org.fundacionjala.pivotal.ui.pages.Init;

import org.fundacionjala.core.selenium.Interactioner;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitialPage extends BasePage {
    @FindBy(linkText = "Log in")
    private WebElement logInLink;

    private void clickLogInLink() {
        Interactioner.clickWebElement(logInLink);
    }

    /**
     * Allows to go to Login Step 1 Page from GUI.
     * @return a new LoginStep1Page.
     */
    public LoginStep1Page goToLoginStep1() {
        clickLogInLink();
        return new LoginStep1Page();
    }

}
