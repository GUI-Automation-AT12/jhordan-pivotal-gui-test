package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProfilePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class ProfileSteps {

    // Entities
    private User user;

    // Pages
    private ProfilePage profilePage;

    /**
     * StepDef to edit user Profile receiving a Data Table.
     * @param userInformation
     */
    @When("^I edit My Profile with the following information$")
    public void editMyProfile(final Map<String, String> userInformation) {

        // Update User entity
        user = new User();
        user.processInformation(userInformation);

        // Update User Information by UI
        profilePage = new ProfilePage();
//        profilePage.getEditProfileForm().editProfileInformation(userInformation.keySet(), user);
        profilePage.getEditProfileForm().editProfileInformation(user);
    }

    @Then("{string} message should be displayed in My Profile section")
    public void verifyMessageIsDisplayedInMyProfileSection(final String message) {
        String actualMessage = profilePage.getTextFromChangesNotification();
        Assert.assertEquals(actualMessage, message);
    }

    @Then("the user information should be updated in My Profile section")
    public void verifyUserInformationIsUpdatedInMyProfileSection() {
        SoftAssert softAssert = new SoftAssert();

        Map<String, String> actualProfileInfo = profilePage.getUserInformationAsMap(user.getUpdatedFields());
        Map<String, String> expectedProfileInfo = user.getUpdatedInfo();

        actualProfileInfo.forEach((field, actualValue) -> {
            softAssert.assertEquals(actualValue, expectedProfileInfo.get(field));
        });
        softAssert.assertAll();

        Assert.assertEquals(actualProfileInfo, expectedProfileInfo);
    }

    @Then("my Name should be updated in the User Management Menu")
    public void myNameShouldBeUpdatedInTheUserManagementMenu() {
        String managementMenuTitle = profilePage.getUserManagementMenuTitleAsString();
        Assert.assertEquals(managementMenuTitle, user.getName());
    }

    @Then("my User Name should be updated in the Top Menu")
    public void myUserNameShouldBeUpdated() {
        String userNameFromTopMenu = profilePage.getTopMenu().getUserNameFromTopMenu();
        Assert.assertEquals(userNameFromTopMenu, user.getUserName());
    }

    @When("I open the User Dropdown Menu from Top Menu")
    public void iOpenTheUserDropdownMenuFromTopMenu() {
        profilePage.getTopMenu().openUserNameDropdownMenu();
    }


    @Then("the user information should be updated in the User Dropdown Menu")
    public void theUserInformationShouldBeUpdatedInTheUserDropdownMenu() {
        Map<String, String> dropdownMenuInfo = profilePage.getTopMenu().getUserMenu().getUserInformationAsMap();
        Assert.assertEquals(dropdownMenuInfo.get("Underlying initials"), user.getInitials());
        Assert.assertEquals(dropdownMenuInfo.get("Details user name"), user.getUserName());
        Assert.assertEquals(dropdownMenuInfo.get("Details name"), user.getName());
        Assert.assertEquals(dropdownMenuInfo.get("Details initials"), user.getInitials(),
                "The Details initials were not the expected in User Dropdown. ");
    }
}
