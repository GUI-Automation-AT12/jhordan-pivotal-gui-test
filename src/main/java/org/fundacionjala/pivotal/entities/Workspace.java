package org.fundacionjala.pivotal.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Workspace {

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;


    /**
     * Default Constructor for Workspace Entity class.
     */
    public Workspace() {
    }

    /**
     * Constructor for Workspace entity class with minimum info.
     * @param name of the new project
     */
    public Workspace(final String name) {
        this.name = name;
    }

    /**
     * Gets the name of the Workspace.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Workspace.
     * @param workspaceName
     */
    public void setName(final String workspaceName) {
        if (workspaceName != null) {
            this.name = workspaceName;
        }
        else {
            this.name = " ";
        }
    }

    private HashMap<String, Runnable> composeMapStrategy(final Map<String, String> workspaceInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(workspaceInformation.get("Name")));
        return strategyMap;
    }

    /**
     *
     */
    public void processInformation(final Map<String, String> workspaceInformation) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(workspaceInformation);
        workspaceInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     *
     */
    private HashMap<String, Supplier<String>> composeStrategyGetterMap() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> getName());
        return strategyMap;
    }
}
