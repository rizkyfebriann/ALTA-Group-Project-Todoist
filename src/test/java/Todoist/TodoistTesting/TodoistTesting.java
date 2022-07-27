package Todoist.TodoistTesting;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TodoistTesting {

    public static final String URL = "https://api.todoist.com/rest/v1/";
    public static final String DIR = System.getProperty("user.dir");

    public static final String FILE_JSON = DIR+"/src/test/resources/fileJSONtodoist";

    public static String CREATE_A_PROJECT = URL+"/projects";

    @Step("Post create project headers")
    public void postCreateProjectheader(){
        SerenityRest.given()
                .headers("Authorization","Bearer cf3181ac95fcf0abcdcd08aa1ddafeba7824cabd");
    }

    @Step("Post create project")
    public void postCreateProject(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
