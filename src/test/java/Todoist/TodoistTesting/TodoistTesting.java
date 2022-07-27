package Todoist.TodoistTesting;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TodoistTesting {

    public static final String URL = "https://api.todoist.com";
    public static final String DIR = System.getProperty("user.dir");

    public static final String FILE_JSON = DIR+"/src/test/resources/fileJSONtodoist";

    public static String CREATE_A_PROJECT = URL+"/rest/v1/projects";

    public static String GET_A_PROJECT = URL+"/rest/v1/projects";

    public String PROJECTS = "https://api.todoist.com/rest/v1/projects";

    @Step("Post create project headers")
    public void postCreateProjectheader(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer cf3181ac95fcf0abcdcd08aa1ddafeba7824cabd");
    }
    //                .headers("Authorization","Bearer ");

//    @Step("Post create project")
//    public void postCreateProject(File json){
//        SerenityRest.given()
//                .contentType(ContentType.JSON)
//                .body(json);
//    }

    @Step("Get all project")
    public void getAllProject(){
        SerenityRest.given()
                .headers("Authorization","Bearer cf3181ac95fcf0abcdcd08aa1ddafeba7824cabd");
    }

}
