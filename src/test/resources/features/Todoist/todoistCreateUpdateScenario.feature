Feature: Testing API Todoist - Endpoint Create and Update

  @case_positive @Create @rizky
  Scenario: Create a new project with valid authorization bearer token
    Given post create project with valid json file
    When Send request post create a new project
    Then API response status code should be 200 OK

  @case_negative @Create @rizky
  Scenario: Create a new project with invalid authorization bearer token
    Given set invalid token & post create project with valid json file
    When Send request post create a new project
    Then API response status code should be 401 Unauthorized

  @case_negative @Create @rizky
  Scenario: Create a new project with invalid data on json file
    Given post create project with invalid json file
    When Send request post create a new project
    Then API response status code should be 400 bad request

  @case_negative @Create @rizky
  Scenario: Create a new project with invalid path
    Given post create project with valid json file
    When Send request post create a new project on invalid path
    Then API response status code should be 404 Not Found

  @case_positive @Update @rizky
  Scenario: Update a new project with valid authorization bearer token
    Given post update project on valid id "2295485780" with valid json file
    When Send request post update a project
    Then API response status code should be 204 no content

  @case_negative @Update @rizky
  Scenario: Update a new project with invalid authorization bearer token
    Given set invalid token and post update project on valid id "2295485780" with valid json file
    When Send request post update a project
    Then API response status code should be 401 Unauthorized

  @case_negative @Update @rizky
  Scenario: Update a project with invalid data on json file
    Given post update project on valid id "2295485780" with invalid json file
    When Send request post update a project
    Then API response status code should be 400 bad request

  @case_negative @Update @rizky
  Scenario: Update a project with invalid path
    Given post update project on valid id "2295485780" with valid json file
    When Send request post update a project on invalid path
    Then API response status code should be 404 Not Found

  @case_negative @Update @rizky
  Scenario: Update a project with invalid method
    Given post update project on valid id "2295485780" with valid json file
    When Send request put update a project
    Then API response status code should be 405 method not allowed











