package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.Interactioner;
import org.fundacionjala.pivotal.ui.component.profile.EditProfileForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class ProfilePage extends BaseLoggedInPage {

    EditProfileForm editProfileForm;

    public ProfilePage() {
        editProfileForm = new EditProfileForm();
    }

    @FindBy(css = "#general.card ul.rows.read li:nth-child(1) div")
    private WebElement profileUserName;

    @FindBy(css = "#general.card ul.rows.read li:nth-child(2) div")
    private WebElement profileName;

    @FindBy(css = "#general.card ul.rows.read li:nth-child(3) div")
    private WebElement profileInitials;

    @FindBy(css = ".edit_button.header_button")
    private WebElement editProfileBtn;

    @FindBy(css = "#general_flash span")
    private WebElement changesNotification;

    @FindBy(css = ".name")
    private WebElement userManagementMenuTitle;

    private String getProfileInformationAsString(WebElement webElement) {
        return Interactioner.getTextFromWebElement(webElement);
    }

    /**
     * Find the User Name from the Profile Page as String.
     * @return User name as String
     */
    public String getProfileUserNameAsString() {
        return getProfileInformationAsString(profileUserName);
    }

    private String getProfileNameAsString() {
        return getProfileInformationAsString(profileName);
    }

    private String getProfileInitialsAsString() {
        return getProfileInformationAsString(profileInitials);
    }

    private void clickEditProfileButton() {
        Interactioner.clickWebElement(editProfileBtn);
    }

    /**
     * Returns the EditProfileForm clicking at EditProfileBtn
     * @return editProfileForm
     */
    public EditProfileForm getEditProfileForm() {
        clickEditProfileButton();
        return editProfileForm;
    }

    public String getTextFromChangesNotification() {
        return Interactioner.getTextFromWebElement(changesNotification);
    }

    public Map<String, String> getUserInformationAsMap() {
        Map userInfoMap = new HashMap<String, String>();
        userInfoMap.put("User name", getProfileUserNameAsString());
        userInfoMap.put("Name", getProfileNameAsString());
        userInfoMap.put("Initials", getProfileInitialsAsString());
        return userInfoMap;
    }

    public Map<String, String> getUserInformationAsMap(final Set<String> fields) {
        Map userInfoMap = new HashMap<String, String>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetterMap();
        fields.forEach(field -> userInfoMap.put(field, strategyMap.get(field).get()));
        return userInfoMap;
    }

    private HashMap<String, Supplier<String>> composeStrategyGetterMap() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("User name", () -> getProfileUserNameAsString());
        strategyMap.put("Name", () -> getProfileNameAsString());
        strategyMap.put("Initials", () -> getProfileInitialsAsString());
        return strategyMap;
    }

    public String getUserManagementMenuTitleAsString() {
        return Interactioner.getTextFromWebElement(userManagementMenuTitle);
    }
}
