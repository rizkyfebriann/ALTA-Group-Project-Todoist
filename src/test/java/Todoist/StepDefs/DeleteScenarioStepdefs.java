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

public class DeleteScenarioStepdefs {

    @Steps
    TodoistTesting todoistTesting;

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

    //Delete project with invalid id
    @Given("request delete project with invalid id {string}")
    public void requestDeleteProjectWithInvalidIdId(String id) {
        todoistTesting.deleteProject(id);
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
