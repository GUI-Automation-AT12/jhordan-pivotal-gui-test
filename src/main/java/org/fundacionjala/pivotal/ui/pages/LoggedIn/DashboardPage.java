package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.popups.CreateProjectPopup;
import org.fundacionjala.pivotal.ui.popups.CreateWorkspacePopUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BaseLoggedInPage {


    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;

    @FindBy(xpath = "//span[@class='Dashboard__Tabs__tab']")
    private WebElement workspacesLink;

    @FindBy(id = "create-workspace-button")
    private WebElement buttonCreateWorkspace;



    private void clickCreateProjectBtn() {
        GuiInteractioner.clickWebElement(createProjectBtn);
    }

    /**
     * Allows user to drive to Project Creation PopUp.
     * @return CreateProjectPopup
     */
    public CreateProjectPopup goToProjectCreation() {
        clickCreateProjectBtn();
        return new CreateProjectPopup();
    }

    /**
     *
     */
    private void clickWorkspaceLink() {
        GuiInteractioner.clickWebElement(workspacesLink);
    }



    private void clickCreateWorkspaceButton() {
        GuiInteractioner.clickWebElement(buttonCreateWorkspace);
    }
    /**
     * Allows user to drive to Workspace Creation PopUp.
     * @return CreateProjectPopup
     */
    public CreateWorkspacePopUp goToWorkspaceCreation() {
        clickWorkspaceLink();
        clickCreateWorkspaceButton();
        return new CreateWorkspacePopUp();
    }
}
