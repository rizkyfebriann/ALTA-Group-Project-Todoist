Feature: Testing API Todoist

  @case_positive @Create
  Scenario: Create a new project with valid authorization bearer token
    Given post create project with valid json file
    When Send request post create a new project
    Then API response status code should be 200 OK