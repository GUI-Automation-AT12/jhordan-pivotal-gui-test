package org.fundacionjala.pivotal.cucumber.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.Projects;
import org.fundacionjala.pivotal.entities.Workspace;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectSettingsPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.WorkspaceSettingsPage;

import java.net.MalformedURLException;

public class WorkspaceHook {

    private final Context context;

    /**
     * Adding Dependency injection to share Default Workspace information.
     * @param sharedContext
     */
    public WorkspaceHook(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * AfterHook that deletes created Workspace.
     */
    @After(value = "@deleteWorkspace")
    public void deleteWorkspace() throws MalformedURLException, PropertiesReadingException {
        for (Workspace workspace : context.getWorkspacesListToDelete()) {
            WebTransporter.navigateToPath("workspaces/" + workspace.getId() + "/settings");
            WorkspaceSettingsPage workspaceSettingsPage = new WorkspaceSettingsPage();
            workspaceSettingsPage.deleteWorkspace();
        }
        context.getWorkspacesListToDelete().clear();
    }
}
