package Todoist.StepDefs;

import Todoist.API.TodoistTesting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class CreateUpdateScenarioStepDefs {

    @Steps
    TodoistTesting todoistTesting;

    @Then("API response status code should be {int} OK")
    public void apiResponseStatusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(200);
    }

    @When("Send request post create a new project")
    public void sendRequestPostCreateANewProjectWithValidJsonFile() {
        SerenityRest.when().post(TodoistTesting.CREATE_A_PROJECT);
    }

    @Given("post create project with valid json file")
    public void postCreateProjectWithValidJsonFile() {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/CreateProjectWithValidAuthorization.json");
        todoistTesting.postCreateProjectheader(jsonFiles);
    }

    @Given("set invalid token & post create project with valid json file")
    public void setInvalidTokenPostCreateProjectWithValidJsonFile() {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/CreateProjectWithValidAuthorization.json");
        todoistTesting.postCreateProjectheaderinvalid(jsonFiles);
    }

    @Given("post create project with invalid json file")
    public void postCreateProjectWithInvalidJsonFile() {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/CreateProjectWithInvalidData.json");
        todoistTesting.postCreateProjectheader(jsonFiles);
    }

    @Then("API response status code should be {int} bad request")
    public void apiResponseStatusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(400);
    }

    @When("Send request post create a new project on invalid path")
    public void sendRequestPostCreateANewProjectOnInvalidPath() {
        SerenityRest.when().post(TodoistTesting.CREATE_A_PROJECT_INVALID_PATH);
    }

    @Given("post update project on valid id {string} with valid json file")
    public void postUpdateProjectOnValidIdWithValidJsonFile(String id) {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/UpdateProjectWithValidData.json");
        todoistTesting.postUpdateProjectheader(jsonFiles, id);
    }

    @When("Send request post update a project")
    public void sendRequestPostUpdateAProject() {
        SerenityRest.when().post(TodoistTesting.UPDATE_A_PROJECT);
    }

    @Then("API response status code should be {int} no content")
    public void apiResponseStatusCodeShouldBeNoContent(int NoContent) {
        SerenityRest.then().statusCode(204);
    }

    @Given("set invalid token and post update project on valid id {string} with valid json file")
    public void setInvalidTokenAndPostUpdateProjectOnValidIdWithValidJsonFile(String id) {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/UpdateProjectWithInvalidData.json");
        todoistTesting.postUpdateProjectheaderinvalid(jsonFiles, id);
    }

    @Given("post update project on valid id {string} with invalid json file")
    public void postUpdateProjectOnValidIdWithInvalidJsonFile(String id) {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/UpdateProjectWithInvalidData.json");
        todoistTesting.postUpdateProjectheader(jsonFiles, id);
    }

    @When("Send request post update a project on invalid path")
    public void sendRequestPostUpdateAProjectOnInvalidPath() {
        SerenityRest.when().post(TodoistTesting.UPDATE_A_PROJECT_INVALID_PATH);

    }

    @When("Send request put update a project")
    public void sendRequestPutUpdateAProject() {
        SerenityRest.when().put(TodoistTesting.UPDATE_A_PROJECT);
    }

    @Then("API response status code should be {int} method not allowed")
    public void apiResponseStatusCodeShouldBeMethodNotAllowed(int NotAllowed) {
        SerenityRest.then().statusCode(405);
    }
}
