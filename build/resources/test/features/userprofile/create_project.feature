@Project
Feature: Create New Project

  @DeleteProject
  Scenario: Create a new Project
    Given I log in to Pivotal with Valid User credentials
    When I navigate to Dashboard page
    And I create a new Project with the following information
      | Project Name    | Prueba   |
      | Account         | Untitled |
      | Project Privacy | Public   |
