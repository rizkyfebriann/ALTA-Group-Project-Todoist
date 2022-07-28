package Todoist.StepDefs;

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
}
