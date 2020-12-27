package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.Interactioner;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettingsPage extends BaseLoggedInPage {

    @FindBy(id = "delete_link")
    private WebElement deleteProjectLink;

    @FindBy(id = "confirm_delete")
    private WebElement deleteProjectBtn;

    private void scrollDownToFindDeleteProjectLink() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getInstance().getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", this.deleteProjectLink);
    }

    private void clickDeleteLink() {
        Interactioner.clickWebElement(deleteProjectLink);
    }

    private void clickDeleteBtn() {
        Interactioner.clickWebElement(deleteProjectBtn);
    }

    /**
     * Allows the user to delete a project from GUI.
     */
    public void deleteProject() {
        scrollDownToFindDeleteProjectLink();
        clickDeleteLink();
        clickDeleteBtn();
    }
}
