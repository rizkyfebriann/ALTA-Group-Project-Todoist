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
import org.junit.runner.Request;

public class GetScenarioStepDefs {

    @Steps
    TodoistTesting todoistTesting;

    @And("request get a collaborator with valid id {string}")
    public void requestGetACollaboratorWithValidId(String id) {
        todoistTesting.getAProjectHeader(id);
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

    //Get A project with invalid path
    @Given("request get a project id {string} with invalid path")
    public void requestGetAProjectIdWithInvalidPath(String id) {
        todoistTesting.getAProjectHeader(id);
    }
    @When("Send request get a project with invalid path")
    public void sendRequestGetAProjectWithInvalidPath() {
        SerenityRest.when().get(TodoistTesting.GET_A_PROJECT_INVALID_PATH);
    }
}
