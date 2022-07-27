package Todoist.StepDefs;

import Todoist.TodoistTesting.TodoistTesting;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

public class TodoistStepDefs {

    @Steps
    TodoistTesting todoistTesting;

    @Given("post create project with valid json file")
    public void postCreateProjectWithValidJsonFile() {
        File jsonFiles = new File(TodoistTesting.FILE_JSON+"/CreateUserWithValidAuthorization.json");
        todoistTesting.postCreateProjectheader(jsonFiles);
    }

    @When("Send request post create a new project")
    public void sendRequestPostCreateANewProjectWithValidJsonFile() {
        SerenityRest.when().post(TodoistTesting.CREATE_A_PROJECT);
    }

    @Then("API response status code should be {int} OK")
    public void apiResponseStatusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(200);
    }

}
