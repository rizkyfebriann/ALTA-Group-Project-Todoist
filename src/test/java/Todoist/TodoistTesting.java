package Todoist;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TodoistTesting {

    public static final String URL = "https://api.todoist.com";
    public static final String DIR = System.getProperty("user.dir");

    public static final String FILE_JSON = DIR+"/src/test/resources/fileJSONtodoist";

    public static String CREATE_A_PROJECT = URL+"/rest/v1/projects";

    @Step("Post create project headers")
    public void postCreateProjectheader(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json)
                    .headers("Authorization","Bearer ba39cc2788122df9d25f70d46b2bbfb778afbbc0");
    }

    @Step("Post create project")
    public void postCreateProject(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
