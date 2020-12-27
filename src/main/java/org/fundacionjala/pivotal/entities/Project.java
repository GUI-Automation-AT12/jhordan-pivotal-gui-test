package org.fundacionjala.pivotal.entities;

import org.fundacionjala.core.utils.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class Project {

    private String projectName;
    private String account;
    private String projectPrivacy;


    /**
     * Sets name to the project.
     * @param projectProjectName
     */
    public void setProjectName(final String projectProjectName) {
        projectName = projectProjectName.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
        projectName = projectName.replaceAll(" ", "");
    }

    /**
     * Gets the Name for the Project.
     * @return UserName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets Account to the Project.
     * @param uAccount
     */
    public void setAccount(final String uAccount) {
        this.account = uAccount;
    }

    /**
     * Gets the Account from the project.
     * @return name
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets projectPrivacyy to a Project.
     * @param projectPrivacyy
     */
    public void setInitials(final String projectPrivacyy) {
        this.projectPrivacy = projectPrivacyy;
    }

    /**
     * Gets the projectPrivacyy from a Project.
     * @return initials.
     */
    public String getProjectPrivacy() {
        return projectPrivacy;
    }

    /**
     * Process all information stored for a Project as a map.
     * @param projectInformation
     */
    public void processInformation(final Map<String, String> projectInformation) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(projectInformation);
        projectInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeMapStrategy(final Map<String, String> projectInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Project Name", () -> setProjectName(projectInformation.get("Project Name")));
        strategyMap.put("Account", () -> setAccount(projectInformation.get("Account")));
        strategyMap.put("Project Privacy", () -> setInitials(projectInformation.get("Project Privacy")));
        return strategyMap;
    }
}
