package org.fundacionjala.pivotal.ui.popups;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.entities.Workspace;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.WorkspacePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateWorkspacePopUp extends BasePage {

    @FindBy(xpath = "//div[@class='tc-form-modal__section']//input")
    private WebElement txtWorkspaceName;

    @FindBy(xpath ="//div[@class='tc_modal_content']//button[@class='zWDds__Button pvXpn__Button--positive']")
    private WebElement buttonCreate;

    @FindBy(xpath ="//div[@class='tc_modal_content']//button[@class='zWDds__Button CMa1J__Button--open']")
    private WebElement buttonCancel;

    @FindBy(xpath ="//div[@class='tc-form__input--error-message']//span")
    private WebElement errorMessageName;

    private void fillWorkspaceNameTextBox(final String workSpaceName) {
        GuiInteractioner.setInputText(txtWorkspaceName, workSpaceName);
    }

    /**
     *
     * @return
     */
    public String getTextFromErrorMessage() {
        return GuiInteractioner.getTextFromWebElement(errorMessageName);
    }

    private void clickCreateButton() {
        GuiInteractioner.clickWebElement(buttonCreate);
    }

    private void clickCancelButton() {
        GuiInteractioner.clickWebElement(buttonCancel);
    }

    /**
     * Creates a public project from GUI.
     * @param workspace Entity that contains the new Project's information
     * @return a new ProjectPage.
     */
    public WorkspacePage createPublicWorkspace(final Workspace workspace) {

        fillWorkspaceNameTextBox(workspace.getName());
        clickCreateButton();
        return new WorkspacePage();
    }
}
