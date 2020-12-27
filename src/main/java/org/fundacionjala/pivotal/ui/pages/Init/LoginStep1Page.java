package org.fundacionjala.pivotal.ui.pages.Init;

import org.fundacionjala.core.selenium.Interactioner;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStep1Page extends BasePage {
    @FindBy(id = "credentials_username")
    private WebElement usernameOrEmailTextBox;

    @FindBy(name = "action")
    private WebElement nextBtn;

    private void fillUsernameOrEmail(final String usernameOrEmail) {
        Interactioner.fillWebElement(usernameOrEmailTextBox, usernameOrEmail);
    }

    private void clickNextBtn() {
        Interactioner.clickWebElement(nextBtn);
    }

    /**
     * Allows to fill usernameOrEmail credential to log in Pivotal Tracker driving to Login Step 2 Page.
     * @param usernameOrEmail
     * @return a new LoginStep2Page;
     */
    public LoginStep2Page goToLoginStep2(final String usernameOrEmail) {
        fillUsernameOrEmail(usernameOrEmail);
        clickNextBtn();
        return new LoginStep2Page();
    }
}
