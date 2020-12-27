package org.fundacionjala.pivotal.ui.popups;

import org.fundacionjala.core.selenium.Interactioner;
import org.fundacionjala.pivotal.entities.Project;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectPage;

import java.util.HashMap;
import java.util.Set;

public class CreateProjectPopup extends BasePage {

    @FindBy(name = "project_name")
    private WebElement projectNameTextBox;

    @FindBy(css = ".tc-account-selector")
    private WebElement accountDropdownList;

    @FindBy(css = ".tc-account-selector__option-account:nth-child(1) .tc-account-selector__option-account-name")
    private WebElement account1Option;

    @FindBy(css = ".tc-project-type-chooser__label:nth-child(3) > .tc-project-type-chooser__label-name")
    private WebElement publicProjectType;

    @FindBy(css = ".pvXpn__Button--positive")
    private WebElement createBtn;

    private void fillProjectNameTextBox(final String projectName) {
        Interactioner.fillWebElement(projectNameTextBox, projectName);
    }

    private void clickAccountDropdownList() {
        Interactioner.clickWebElement(accountDropdownList);
    }

    private void clickAccount1Option(final String account) {
        clickAccountDropdownList();
        Interactioner.clickWebElement(account1Option);
    }

    private void clickCreateBtn() {
        Interactioner.clickWebElement(createBtn);
    }

    /**
     * Creates a project from GUI.
     * @param projectName
     * @return a new ProjectPage.
     */
    public ProjectPage createProject(final String projectName) {
        fillProjectNameTextBox(projectName);
        clickAccountDropdownList();
      //  clickAccount1Option();
        clickCreateBtn();
        return new ProjectPage();
    }

    private void setInformationToEdit(final Set<String> formFields, final Project project) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(formFields, project);
        formFields.forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeMapStrategy(final Set<String> formFields,final Project project) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Project Name", () -> fillProjectNameTextBox(project.getProjectName()));
        strategyMap.put("Account", () -> clickAccount1Option(project.getAccount()));
        return strategyMap;
    }

    /**
     * Edits information of a Project from GUI.
     * @param formFields
     * @param project
     */
    public void editProfileInformation(final Set<String> formFields, final Project project) {
        setInformationToEdit(formFields, project);
        clickCreateBtn();
    }
}
