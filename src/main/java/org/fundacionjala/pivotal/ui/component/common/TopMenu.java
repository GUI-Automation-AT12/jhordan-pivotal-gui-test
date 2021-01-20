package org.fundacionjala.pivotal.ui.component.common;

import org.fundacionjala.core.selenium.Interactioner;
import org.fundacionjala.pivotal.ui.component.UserMenu;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends BasePage {

    private UserMenu userMenu;

    public TopMenu() {
        userMenu = new UserMenu();
    }

    @FindBy(css = "li.tc_pull_right:nth-child(3) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")
    private WebElement userNameDropdownMenu;

    public UserMenu openUserNameDropdownMenu() {
        Interactioner.clickWebElement(userNameDropdownMenu);
        return userMenu;
    }

    public UserMenu getUserMenu() {
        return userMenu;
    }

    public String getUserNameFromTopMenu() {
        return Interactioner.getTextFromWebElement(userNameDropdownMenu);
    }
}
