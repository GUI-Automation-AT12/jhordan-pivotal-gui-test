package org.fundacionjala.pivotal.context;

import org.fundacionjala.pivotal.entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Context {
    private final List<User> usersList;
    private final List<Projects> projectsList;
    private final List<String> editedUsersList;
    private final List<Projects> projectsListToDelete;
    private final List<Story> storyToDelete;
    private final List<Workspace> workspaceListToDelete;

    /**
     * Constructor for Context class.
     */
    public Context() throws IOException {
        this.workspaceListToDelete = new ArrayList<>();
        this.usersList = EntitiesParser.getUsersListFromJson();
        this.projectsList = EntitiesParser.getProjectListFromJson();
        this.editedUsersList = new ArrayList<>();
        this.projectsListToDelete = new ArrayList<>();
        this.storyToDelete = new ArrayList<>();
    }

    /**
     * Searches for a specific User in userList by a provided alias.
     * @param alias provided alias
     * @return User if the alias matches, otherwise return null.
     */
    public User getUserByAlias(final String alias) {
        for (User user : this.usersList) {
            if (alias.equals(user.getAlias())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Searches for a specific Project in projectList providing its name.
     * @param projectName provided to search
     * @return Project if the name matches, otherwise return null.
     */
    public Projects getProjectByName(final String projectName) {
        for (Projects projects : this.projectsList) {
            if (projectName.equals(projects.getName())) {
                return projects;
            }
        }
        return null;
    }

    /**
     * Get the List of Edited Users.
     * @return editedUsersList
     */
    public List<String> getEditedUsersList() {
        return editedUsersList;
    }

    /**
     * Get the List of Projects to delete after some Test Scenarios.
     * @return projectListToDelete
     */
    public List<Projects> getProjectsListToDelete() {
        return projectsListToDelete;
    }

    /**
     * Get the List of Worksapces to delete after some Test Scenarios.
     * @return projectListToDelete
     */
    public List<Workspace> getWorkspacesListToDelete() {
        return workspaceListToDelete;
    }


    /**
     * Get the List of Stories to delete after some Test Scenarios.
     * @return projectListToDelete
     */
    public List<Story> getStoryToDelete() {
        return storyToDelete;
    }
}
