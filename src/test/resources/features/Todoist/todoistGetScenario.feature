Feature: Testing API Todoist - Endpoint GET

  @case_positive @Get @erna
  Scenario: Get all project with valid authorization bearer token
    Given Set authorization with valid bearer token
    When Send request get all project
    Then API response status code should be 200 OK
    And Get all projects assert json validation

  @case_negative @Get @erna
  Scenario: Get all project with invalid authorization bearer token
    Given Set authorization with invalid bearer token
    When Send request get all project
    Then API response status code should be 401 Unauthorized

  @case_negative @Get @erna
  Scenario: Get all project with invalid path
    Given Set authorization with valid bearer token
    When Send request get all project with invalid path
    Then API response status code should be 404 Not Found

  @erna
  Scenario: Get a project with valid id
    Given request get a project with valid id "2295439998"
    When Send request get a project
    Then API response status code should be 200 OK
    And Get a projects assert json validation

  @erna
  Scenario: Get a project with invalid id
    Given request get a project with invalid id "2295439998xx"
    When Send request get a project
    Then API response status code should be 404 Not Found

  @erna
  Scenario: Get a project with invalid path
    Given request get a project id "2295439998" with invalid path
    When Send request get a project with invalid path
    Then API response status code should be 404 Not Found

  @erna
  Scenario: Get all collaborators
    Given Set authorization with valid bearer token
    And request get a collaborator with valid id "2295439998"
    When Send request get all collaborators
    Then API response status code should be 200 OK






