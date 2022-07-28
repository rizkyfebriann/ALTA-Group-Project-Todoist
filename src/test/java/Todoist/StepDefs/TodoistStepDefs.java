package Todoist.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;
import Todoist.TodoistTesting.TodoistTesting;

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

    @When("Send request get all project")
    public void sendRequestGetAllProject() {
        SerenityRest.when().get(TodoistTesting.GET_A_PROJECT);
    }

    @Given("post create project with valid json file")
    public void postCreateProjectWithValidJsonFile() {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/CreateProjectWithValidAuthorization.json");
        todoistTesting.postCreateProjectheader(jsonFiles);
    }

    @Given("request get all project")
    public void requestGetAllProject() {
        todoistTesting.getAllProject();
    }

    @Given("set invalid token & post create project with valid json file")
    public void setInvalidTokenPostCreateProjectWithValidJsonFile() {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/CreateProjectWithValidAuthorization.json");
        todoistTesting.postCreateProjectheaderinvalid(jsonFiles);
    }

    @Then("API response status code should be {int} unauthorized")
    public void apiResponseStatusCodeShouldBeUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(401);
    }

    @Given("post create project with invalid json file")
    public void postCreateProjectWithInvalidJsonFile() {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/CreateProjectWithInvalidData.json");
        todoistTesting.postCreateProjectheader(jsonFiles);
    }

    @Then("API response status code should be {int} bad request")
    public void apiResponseStatusCodeShouldBeBadRequest(int bad_request) {
        SerenityRest.then().statusCode(400);
    }

    @When("Send request post create a new project on invalid path")
    public void sendRequestPostCreateANewProjectOnInvalidPath() {
        SerenityRest.when().post(TodoistTesting.FALSE_CREATE_A_PROJECT);
    }

    @Then("API response status code should be {int} not found")
    public void apiResponseStatusCodeShouldBeNotFound(int not_found) {
        SerenityRest.then().statusCode(404);
    }

    @When("Send request post update a project")
    public void sendRequestPostUpdateANewProject() {
        SerenityRest.when().post(TodoistTesting.UPDATE_A_PROJECT);
    }

    @Given("post update project on valid id {string} with valid json file")
    public void postUpdateProjectOnValidIdWithValidJsonFile(String id) {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/UpdateProjectWithValidData.json");
        todoistTesting.postUpdateProjectheader(jsonFiles, id);
    }

    @Then("API response status code should be {int} no content")
    public void apiResponseStatusCodeShouldBeNoContent(int no_content) {
        SerenityRest.then().statusCode(204);
    }

    @Given("set invalid token and post update project on valid id {string} with valid json file")
    public void setInvalidTokenAndPostUpdateProjectOnValidIdWithValidJsonFile(String id) {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/UpdateProjectWithValidData.json");
        todoistTesting.postUpdateProjectheaderinvalid(jsonFiles, id);
    }

    @Given("post update project on valid id {string} with invalid json file")
    public void postUpdateProjectOnValidIdWithInvalidJsonFile(String id) {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/UpdateProjectWithInvalidData.json");
        todoistTesting.postUpdateProjectheader(jsonFiles, id);
    }

    @When("Send request post update a project on invalid path")
    public void sendRequestPostUpdateAProjectOnInvalidPath() {
        SerenityRest.when().post(TodoistTesting.FALSE_UPDATE_A_PROJECT);

    }

    @When("Send request put update a project")
    public void sendRequestPutUpdateAProject() {
        SerenityRest.when().put(TodoistTesting.UPDATE_A_PROJECT);
    }

    @Then("API response status code should be {int} method not allowed")
    public void apiResponseStatusCodeShouldBeMethodNotAllowed(int not_allowed) {
        SerenityRest.then().statusCode(405);
    }
}
