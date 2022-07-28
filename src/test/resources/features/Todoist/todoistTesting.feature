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
    Then API response status code should be 401 Unauthorized

  @case_negative @Create
  Scenario: Create a new project with invalid data on json file
    Given post create project with invalid json file
    When Send request post create a new project
    Then API response status code should be 400 bad request

  @case_negative @Create
  Scenario: Create a new project with invalid path
    Given post create project with valid json file
    When Send request post create a new project on invalid path
    Then API response status code should be 404 Not Found

  @case_positive @Update
  Scenario: Update a new project with valid authorization bearer token
    Given post update project on valid id "2295485780" with valid json file
    When Send request post update a project
    Then API response status code should be 204 no content

  @case_negative @Update
  Scenario: Update a new project with invalid authorization bearer token
    Given set invalid token and post update project on valid id "2295485780" with valid json file
    When Send request post update a project
    Then API response status code should be 401 Unauthorized

  @case_negative @Update
  Scenario: Update a project with invalid data on json file
    Given post update project on valid id "2295485780" with invalid json file
    When Send request post update a project
    Then API response status code should be 400 bad request

  @case_negative @Update
  Scenario: Update a project with invalid path
    Given post update project on valid id "2295485780" with valid json file
    When Send request post update a project on invalid path
    Then API response status code should be 404 Not Found

  Scenario: Update a project with invalid method
    Given post update project on valid id "2295485780" with valid json file
    When Send request put update a project
    Then API response status code should be 405 method not allowed


#Contoh Untuk Get
  @case_positive @Get
  Scenario: Get all project with valid authorization bearer token
    Given Set authorization with valid bearer token
    When Send request get all project
    Then API response status code should be 200 OK
    And Get all projects assert json validation

  @case_negative @Get
  Scenario: Get all project with invalid authorization bearer token
    Given Set authorization with invalid bearer token
    When Send request get all project
    Then API response status code should be 401 Unauthorized

  @case_negative @Get
  Scenario: Get all project with invalid path
    Given Set authorization with valid bearer token
    When Send request get all project with invalid path
    Then API response status code should be 404 Not Found

  Scenario: Get a project with valid id
    Given request get a project with valid id "2295439998"
    When Send request get a project
    Then API response status code should be 200 OK
    And Get a projects assert json validation

  Scenario: Get a project with invalid id
    Given request get a project with invalid id "2295439998xx"
    When Send request get a project
    Then API response status code should be 404 Not Found

  Scenario: Get a project with invalid id
    Given request get a project with invalid id "2295439998xx"
    When Send request get a project
    Then API response status code should be 404 Not Found

  Scenario: Get all collaborators
    Given Set authorization with valid bearer token
    And request get a collaborator with valid id "2295439998"
    When Send request get all collaborators
    Then API response status code should be 200 OK







