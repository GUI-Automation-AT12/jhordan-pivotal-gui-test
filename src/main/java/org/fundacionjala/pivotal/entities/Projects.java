package org.fundacionjala.pivotal.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Projects {

    private String id;
    private String name;
    private String account;
    private String privacy;

    /**
     * Default Constructor for Project Entity class.
     */
    public Projects() {
    }

    /**
     * Constructor for Project entity class with minimum info.
     * @param projectName of the new project
     * @param projectAccount of the new project
     * @param projectPrivacy of the new project
     */
    public Projects(final String projectName, final String projectAccount, final String projectPrivacy) {
        this.name = projectName;
        this.account = projectAccount;
        this.privacy = projectPrivacy;
    }

    /**
     * Gets the id of the project.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the project.
     * @param projectId
     */
    public void setId(final String projectId) {
        this.id = projectId;
    }

    /**
     * Gets the name of the project.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the project.
     * @param projectName
     */
    public void setName(final String projectName)
    {
        if (projectName != null){
        this.name = projectName;
        }
        else {
            this.name = " ";
        }
    }

    private HashMap<String, Runnable> composeMapStrategy(final Map<String, String> projectInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(projectInformation.get("Name")));
        strategyMap.put("Account", () -> setAccount(projectInformation.get("Account")));
        strategyMap.put("Privacy", () -> setPrivacy(projectInformation.get("Privacy")));
        return strategyMap;
    }

    /**
     *
     */
    public void processInformation(final Map<String, String> projectInformation) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(projectInformation);
        projectInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     *
     */
    private HashMap<String, Supplier<String>> composeStrategyGetterMap() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> getName());
        strategyMap.put("Account", () -> getAccount());
        strategyMap.put("Privacy", () -> getPrivacy());
        return strategyMap;
    }

    /**
     * Gets the account of the project.
     * @return account
     */
    public String getAccount() {

        return account;
    }

    /**
     * Sets the account of the project.
     * @param projectAccount
     */
    public void setAccount(final String projectAccount) {
        if (projectAccount != null){
            this.account = projectAccount;
        }
        else {
            this.account = " ";
        }
    }

    /**
     * Gets the privacy of the project.
     * @return privacy
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     * Sets the privacy of the project.
     * @param projectPrivacy
     */
    public void setPrivacy(final String projectPrivacy) {
        this.privacy = projectPrivacy;
    }
}
