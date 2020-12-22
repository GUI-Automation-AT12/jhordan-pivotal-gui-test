package org.fundacionjala.pivotal.ui.component.profile;


import org.fundacionjala.core.selenium.Interactioner;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeSaved extends BasePage {

    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[1]/div/div[1]/span")
    private static WebElement labelChangeSaved;

    /**
     * Find the User Name from the Profile Page as String.
     *
     * @return User name as String.
     */
    public static String getMessageChangeSaved() {
        return Interactioner.getTextFromWebElement(labelChangeSaved);
    }
}

