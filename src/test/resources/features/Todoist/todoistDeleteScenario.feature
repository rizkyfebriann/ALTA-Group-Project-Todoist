Feature: Testing API Todoist - Endpoint DELETE

  @prita
  Scenario: Delete a project with valid id
    Given request delete project with id "2295439998"
    When Send request delete project
    Then API response status code should be 204 no content

  @prita
  Scenario: Delete a project with invalid id
    Given request delete project with invalid id "2295439998xx"
    When Send request delete project
    Then API response status code should be 400 bad request

  @prita
  Scenario: Delete a project with invalid token
    Given request delete project id "2295439998" with invalid token
    When Send request delete project
    Then API response status code should be 401 Unauthorized

  @prita
  Scenario: Delete a project with invalid path
    Given request delete project id "2295439998" with invalid path
    When Send request delete project with invalid path
    Then API response status code should be 404 Not Found