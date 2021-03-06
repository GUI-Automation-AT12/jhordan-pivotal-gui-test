package org.fundacionjala.pivotal.ui.component.profile;

import org.fundacionjala.core.selenium.Interactioner;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Set;

public class EditProfileForm extends BasePage {

    @FindBy(id = "person_username")
    private WebElement userNameTextBox;

    @FindBy(id = "person_name")
    private WebElement nameTextBox;

    @FindBy(id = "person_initials")
    private WebElement initialsTextBox;

    @FindBy(css = ".save_button.header_button")
    private WebElement saveEditProfileBtn;

    private void fillUserNameTextBox(String newUserName) {
        Interactioner.fillWebElement(userNameTextBox, newUserName);
    }

    private void fillNameTextBox(String newName) {
        Interactioner.fillWebElement(nameTextBox, newName);
    }

    private void fillInitialsTextBox(String newInitials) {
        Interactioner.fillWebElement(initialsTextBox, newInitials);
    }

    private void clickSaveEditProfileBtn() {
        Interactioner.clickWebElement(saveEditProfileBtn);
    }

    private void setInformationToEdit(final Set<String> formFields, final User user) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(formFields, user);
        formFields.forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeMapStrategy(final Set<String> formFields, final User user) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("User name", () -> fillUserNameTextBox(user.getUserName()));
        strategyMap.put("Name", () -> fillNameTextBox(user.getName()));
        strategyMap.put("Initials", () -> fillInitialsTextBox(user.getInitials()));
        return strategyMap;
    }

    /**
     * Edits information of a User Profile from GUI.
     * @param formFields
     * @param user
     */
    public void editProfileInformation(final Set<String> formFields, final User user) {
        setInformationToEdit(formFields, user);
        clickSaveEditProfileBtn();
    }
}
