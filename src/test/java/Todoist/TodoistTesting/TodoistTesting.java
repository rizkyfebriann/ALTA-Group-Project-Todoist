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

    public static String FALSE_CREATE_A_PROJECT = URL+"/rest/v1/projectku";

    public static String UPDATE_A_PROJECT = URL+"/rest/v1/projects/{id}";

    public static String FALSE_UPDATE_A_PROJECT = URL+"/rest/v1/projectku/{id}";

    public static String GET_A_PROJECT = URL+"/rest/v1/projects";

    public String PROJECTS = "https://api.todoist.com/rest/v1/projects";

    @Step("Post create project headers")
    public void postCreateProjectheader(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer cf3181ac95fcf0abcdcd08aa1ddafeba7824cabd");
    }

    @Step("Post create project headers invalid")
    public void postCreateProjectheaderinvalid(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer test123");
    }


    @Step("Post update project headers valid")
    public void postUpdateProjectheader(File json, String idProject){
        SerenityRest.given()
                .pathParam("id", idProject)
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer cf3181ac95fcf0abcdcd08aa1ddafeba7824cabd");
    }

    @Step("Post update project headers invalid")
    public void postUpdateProjectheaderinvalid(File json, String idProject){
        SerenityRest.given()
                .pathParam("id", idProject)
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer testing123");
    }

    @Step("Get all project")
    public void getAllProject(){
        SerenityRest.given()
                .headers("Authorization","Bearer cf3181ac95fcf0abcdcd08aa1ddafeba7824cabd");
    }

}
