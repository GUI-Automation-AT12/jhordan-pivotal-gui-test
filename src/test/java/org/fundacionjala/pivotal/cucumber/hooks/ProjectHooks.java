package org.fundacionjala.pivotal.cucumber.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.Projects;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectSettingsPage;

import java.net.MalformedURLException;

public class ProjectHooks {

    private final Context context;

    /**
     * Adding Dependency injection to share Project Context information.
     * @param sharedContext
     */
    public ProjectHooks(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * AfterHook that deletes created Project.
     */
    @After(value = "@deleteProject")
    public void deleteProject() throws MalformedURLException, PropertiesReadingException {
        for (Projects project : context.getProjectsListToDelete()) {
            WebTransporter.navigateToPath("projects/" + project.getId() + "/settings");
            ProjectSettingsPage projectSettingsPage = new ProjectSettingsPage();
            projectSettingsPage.deleteProject();
        }
        context.getProjectsListToDelete().clear();
    }
}
