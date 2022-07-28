Feature: Testing API Todoist

  @case_positive @Create
  Scenario: Create a new project with valid authorization bearer token
    Given post create project with valid json file
    When Send request post create a new project
    Then API response status code should be 200 OK

  @case_negative @Create
  Scenario: Create a new project with invalid authorization bearer token
    Given set invalid token & post create project with valid json file
    When Send request post create a new project
    Then API response status code should be 401 unauthorized

  @case_negative @Create
  Scenario: Create a new project with invalid data on json file
    Given post create project with invalid json file
    When Send request post create a new project
    Then API response status code should be 400 bad request

  @case_negative @Create
  Scenario: Create a new project with invalid path
    Given post create project with valid json file
    When Send request post create a new project on invalid path
    Then API response status code should be 404 not found

  @case_positive @Update
  Scenario: Update a new project with valid authorization bearer token
    Given post update project on valid id "2295485780" with valid json file
    When Send request post update a project
    Then API response status code should be 204 no content

  @case_negative @Update
  Scenario: Update a new project with invalid authorization bearer token
    Given set invalid token and post update project on valid id "2295485780" with valid json file
    When Send request post update a project
    Then API response status code should be 401 unauthorized

  @case_negative @Update
  Scenario: Update a project with invalid data on json file
    Given post update project on valid id "2295485780" with invalid json file
    When Send request post update a project
    Then API response status code should be 400 bad request

  @case_negative @Update
  Scenario: Update a project with invalid path
    Given post update project on valid id "2295485780" with valid json file
    When Send request post update a project on invalid path
    Then API response status code should be 404 not found

  Scenario: Update a project with invalid method
    Given post update project on valid id "2295485780" with valid json file
    When Send request put update a project
    Then API response status code should be 405 method not allowed


#Contoh Untuk Get
  @case_positive @Get
  Scenario: Get all project with valid authorization bearer token
    Given request get all project
    When Send request get all project
    Then API response status code should be 200 OK