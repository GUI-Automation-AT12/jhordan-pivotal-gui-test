package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspaceSettingsPage extends BasePage {

    @FindBy(xpath = "//div[@class='content clearfix']//a[contains(text(),'Delete')]")//div[@class='content clearfix']//input[@id='confirm_delete']
    private WebElement deleteWorkspaceLink;

    @FindBy(xpath = "//div[@class='content clearfix']//input[@id='confirm_delete']")
    private WebElement deleteWorkspaceButton;

    private void clickDeleteLink() {
        GuiInteractioner.clickWebElement(deleteWorkspaceLink);
    }

    private void clickDeleteButton() {
        GuiInteractioner.clickWebElement(deleteWorkspaceButton);
    }

    /**
     * Allows the user to delete a project from GUI.
     */
    public void deleteWorkspace() {
        clickDeleteLink();
        clickDeleteButton();
    }


}
