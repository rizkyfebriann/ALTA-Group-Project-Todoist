package Todoist.StepDefs;

import Todoist.API.TodoistTesting;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

import io.restassured.module.jsv.JsonSchemaValidator;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class TodoistStepDefs {

    @Steps
    TodoistTesting todoistTesting;

    @Then("API response status code should be {int} OK")
    public void apiResponseStatusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(200);
    }

//    @Given("set authorization with valid bearer token")
//    public void setAuthorizationWithValidBearerToken() {
//        todoistTesting.postCreateProjectheader();
//    }

    @When("Send request post create a new project")
    public void sendRequestPostCreateANewProjectWithValidJsonFile() {
        SerenityRest.when().post(TodoistTesting.CREATE_A_PROJECT);
    }

//    @And("request post create project with valid json file")
//    public void requestPostCreateProjectWithValidJsonFile() {
//        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/CreateProjectWithValidAuthorization.json");
//        todoistTesting.postCreateProjectheader(jsonFiles);
//    }
    @Given("post create project with valid json file")
    public void postCreateProjectWithValidJsonFile() {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/CreateProjectWithValidAuthorization.json");
        todoistTesting.postCreateProjectheader(jsonFiles);
    }

//Get All Project
    @Given("Set authorization with valid bearer token")
    public void SetAuthorizationWithValidBeareToken() {
        todoistTesting.getProjectHeader();
    }
    @When("Send request get all project")
    public void sendRequestGetAllProject() {
        SerenityRest.when().get(TodoistTesting.GET_ALL_PROJECT);
    }

    @And("Get all projects assert json validation")
    public void getAllProjectsAssertJsonValidation() {
        File jsonFile = new File(TodoistTesting.FILE_JSON+"/GetAllProjectJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
//Get all project with invalid token
    @Given("Set authorization with invalid bearer token")
    public void settingAuthorizationWithInvalidBearerToken() {
        todoistTesting.getProjectHeaderInvalidToken();
    }

    @Then("API response status code should be {int} Unauthorized")
    public void apiResponseStatusCodeShouldBeUnauthorized(int Unauthorized) {
        SerenityRest.then().statusCode(401);
    }
    //Get All Project With Invalid Path
    @When("Send request get all project with invalid path")
    public void sendRequestGetAllProjectWithInvalidPath() {
        SerenityRest.when().get(TodoistTesting.GET_ALL_PROJECT_INVALID_PATH);
    }
    @Then("API response status code should be {int} Not Found")
    public void apiResponseStatusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(404);
    }

    //Get A Project with valid id
    @Given("request get a project with valid id {string}")
    public void requestGetAProjectWithValidId(String id) {
        todoistTesting.getAProjectHeader(id);
    }
    @When("Send request get a project")
    public void sendRequestGetAProject() {
        SerenityRest.when().get(TodoistTesting.GET_A_PROJECT);
    }
    @And("Get a projects assert json validation")
    public void getAProjectsAssertJsonValidation() {
        File jsonFile = new File(TodoistTesting.FILE_JSON+"/GetAProjectJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    //Get A Project with invalid id
    @Given("request get a project with invalid id {string}")
    public void requestGetAProjectWithInvalidId(String id) {
        todoistTesting.getAProjectHeader(id);
    }
    //Get All Collaborators
    @When("Send request get all collaborators")
    public void sendRequestGetAllCollaborators() {
        SerenityRest.when().get(TodoistTesting.GET_ALL_COLLABORATORS);
    }
}


//Delete project
//Delete project with valid id
@Given("request delete project with id {string}")
public void requestDeleteProjectWithId(String id) {
    todoistTesting.deleteProject(id);
}
    @When("Send request delete project")
    public void sendRequestDeleteProject() {
        SerenityRest.when().delete(TodoistTesting.DELETE_A_PROJECT);
    }
    @Then("API response status code should be {int} No Content")
    public void apiResponseStatusCodeShouldBeNoContent(int statuscode) {
        SerenityRest.then().statusCode(statuscode);
    }
    //Delete project with invalid id
    @Given("request delete project with invalid id {string}")
    public void requestDeleteProjectWithInvalidIdId(String id) {
        todoistTesting.deleteProject(id);
    }
    @Then("API response status code should be {int} Bad Request")
    public void apiResponseStatusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }
    //Delete project with invalid token
    @Given("request delete project id {string} with invalid token")
    public void requestDeleteProjectIdWithInvalidToken(String id) {
        todoistTesting.deleteProjectHeaderInvalidToken(id);
    }
    //  Delete project with invalid path
    @Given("request delete project id {string} with invalid path")
    public void requestDeleteProjectIdWithInvalidPath(String id) {
        todoistTesting.deleteProject(id);
    }
    @When("Send request delete project with invalid path")
    public void sendRequestDeleteProjectWithInvalidPath() {
        SerenityRest.when().delete(TodoistTesting.DELETE_A_PROJECT_INVALID_PATH);
    }
}
