@WorkSpace
Feature: Create Workspace

  @deleteWorkspace
  Scenario: Create a new workspace from an existent Account
    Given I log in to Pivotal with Standard User credentials
    When I open the Create Workspace pop-up
    And I create a workspace with the following information
      | Name    | New Workspace |
    Then properties of new workspace should be displayed at Workspace's Page
    When I save the Workspace's Id
    And I open the Workspace Summary page
    Then my new Workspace should be listed in the summary

  @negative
  Scenario: Create a new workspace with empty space from an existent Account
    Given I log in to Pivotal with Standard User credentials
    When I open the Create Workspace pop-up
    And I create a workspace with the following information
      | Name    |  |
    Then "Workspace name can't be blank." message should be displayed.


