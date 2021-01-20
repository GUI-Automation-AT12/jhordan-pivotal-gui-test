package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspacePage extends BasePage {


    private By workspaceSpan;

    @FindBy(xpath = "//div[@class='tc-form__input--error-message']//span[contains(text(),Workspace name can't be blank.)]")
    private WebElement errorMessageName;

    private By workspaceItem;

    /**
     * Get inner text from Project Name Span.
     * @return text from Project Name Span
     */
    public String getTextFromProjectNameSpan(String workspaceName) {
        workspaceSpan = By.xpath("//div[@id='root']//span[contains(text(),'"+workspaceName+"')]");
        return GuiInteractioner.getTextFromWebElement(workspaceSpan);
    }

    /**
     * Get inner text from Project Public Privacy Span.
     * @return text from Project Public Privacy Span
     */
    public String getWorkspaceFromList(String workspaceName) {
        workspaceItem = By.xpath("//div[@class='workspace_list']//a[contains(text(),'"+workspaceName+"')]");
        return GuiInteractioner.getTextFromWebElement(workspaceItem);
    }

    public String getIdFromUrl() {
        String url = WebTransporter.getCurrentUrl();
        return url.substring(url.lastIndexOf('/') + 1);
    }


    /**
     *
     * @return
     */
    public String getTextFromErrorMessage() {
        return GuiInteractioner.getTextFromWebElement(errorMessageName);
    }

}
