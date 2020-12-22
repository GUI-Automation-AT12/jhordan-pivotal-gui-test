package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.And;
import org.fundacionjala.pivotal.entities.Project;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.popups.CreateProjectPopup;

import java.util.Map;

public class CreateProjectStep {
    @And("I create a new Project with the following information")
    public void iCreateANewProjectWithTheFollowingInformation (final Map<String, String> projectInformation) {

        Project project = new Project();
        // Update User entity
        project.processInformation(projectInformation);

        CreateProjectPopup createProjectPopup = new CreateProjectPopup();
        // Update User Information by UI
        createProjectPopup.editProfileInformation(projectInformation.keySet(), project);
    }

}
