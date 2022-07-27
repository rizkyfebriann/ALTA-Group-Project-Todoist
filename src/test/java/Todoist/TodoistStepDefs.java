package Todoist;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

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
