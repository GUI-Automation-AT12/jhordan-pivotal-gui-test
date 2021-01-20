package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.Projects;
import org.fundacionjala.pivotal.entities.Workspace;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.*;
import org.fundacionjala.pivotal.ui.popups.CreateWorkspacePopUp;
import org.testng.asserts.SoftAssert;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WorkspaceStep {

    private DashboardPage dashboardPage;
    private CreateWorkspacePopUp createWorkspacePopUp;
    private WorkspacePage workspacePage;
    ProjectPage projectPage;
    ProjectsSummaryPage projectsSummaryPage;
    Workspace workspace;
    Context context;

    public WorkspaceStep(final Context sharedContext) {
        this.context = sharedContext;
    }

    @When("I open the Create Workspace pop-up")
    public void openTheCreateWorkspacePopUp() {
        dashboardPage = new DashboardPage();
        createWorkspacePopUp = dashboardPage.goToWorkspaceCreation();
    }

    @And("I create a workspace with the following information")
    public void createAWorkspaceWithTheFollowingInformation(final Map<String, String> workspaceInfo) {
        //Updating Workspace entity
        workspace=new Workspace(workspaceInfo.get("Name"));
        workspace.processInformation(workspaceInfo);

        //Creating Workspace from UI
        workspacePage = createWorkspacePopUp.createPublicWorkspace(workspace);

        //Saving new Workspace in Context
        context.getWorkspacesListToDelete().add(workspace);
    }

    @Then("properties of new workspace should be displayed at Workspace's Page")
    public void propertiesOfNewWorkspaceShouldBeDisplayedAtWorkspaceSPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(workspacePage.getTextFromProjectNameSpan(workspace.getName()), workspace.getName());
        softAssert.assertAll();
    }

    @When("I save the Workspace's Id")
    public void iSaveTheWorkspaceSId() {
        String gottenId = workspacePage.getIdFromUrl();
        workspace.setId(gottenId);
    }

    @And("I open the Workspace Summary page")
    public void iOpenTheWorkspaceSummaryPage() {
        projectPage = new ProjectPage();
        projectsSummaryPage = projectPage.goToProjectsList();
    }

    @Then("my new Workspace should be listed in the summary")
    public void myNewWorkspaceShouldBeListedInTheSummary() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(workspacePage.getWorkspaceFromList(workspace.getName()),workspace.getName());
    }

    @Then("{string} message should be displayed.")
    public void messageShouldBeDisplayed(String message) {
        String actual = createWorkspacePopUp.getTextFromErrorMessage();
        assertEquals(message, actual);
    }
}
