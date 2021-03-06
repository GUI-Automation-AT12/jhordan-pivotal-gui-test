package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.Interactioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BaseLoggedInPage {

    private static final int SLEEPING_TIME = 5000;

    @FindBy(css = ".tc_projects_dropdown_link.tc_context_name")
    private WebElement projectDropdownList;

    @FindBy(css = ".tc_projects_menu_show_all")
    private WebElement projectsSummaryLink;

    private void sleepToShowPage() {
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clickProjectDropdownList() {
        Interactioner.clickWebElement(projectDropdownList);
    }

    private void clickProjectsSummaryLink() {
        Interactioner.clickWebElement(projectsSummaryLink);
    }

    /**
     * Drives to a Page of All Projects.
     * @return a new ProjectsSummaryPage.
     */
    public ProjectsSummaryPage goToProjectsList() {
        sleepToShowPage();
        clickProjectDropdownList();
        clickProjectsSummaryLink();
        return new ProjectsSummaryPage();
    }
}
