package Todoist.API;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class TodoistTesting {

    public static final String URL = "https://api.todoist.com";
    public static final String DIR = System.getProperty("user.dir");

    public static final String FILE_JSON = DIR+"/src/test/resources/fileJSONtodoist";

    public static String CREATE_A_PROJECT = URL+"/rest/v1/projects";
    public static String CREATE_A_PROJECT_INVALID_PATH = URL+"/rest/v1/projectku";

    public static String UPDATE_A_PROJECT = URL+"/rest/v1/projects/{id}";
    public static String UPDATE_A_PROJECT_INVALID_PATH = URL+"/rest/v1/projectku/{id}";

    public static String GET_ALL_PROJECT = URL+"/rest/v1/projects";
    public static String GET_ALL_PROJECT_INVALID_PATH = URL+"/rest/v1/projects/xxx";
    public static String GET_A_PROJECT = URL+"/rest/v1/projects/{id}";
    public static String GET_A_PROJECT_INVALID_PATH = URL+"/rest/v1/projects/{id}/xx";
    public static String GET_ALL_COLLABORATORS = URL+"/rest/v1/projects/{id}/collaborators";

    public static String DELETE_A_PROJECT = URL+"/rest/v1/projects/{id}";
    public static String DELETE_A_PROJECT_INVALID_PATH = URL+"/rest/v1/projectssss/{id}";



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

    @Step("Post update project headers")
    public void postUpdateProjectheader(File json, String idProject){
        SerenityRest.given()
                .pathParam("id", idProject)
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer cf3181ac95fcf0abcdcd08aa1ddafeba7824cabd");
    }

    @Step("Post update project headers")
    public void postUpdateProjectheaderinvalid(File json, String idProject){
        SerenityRest.given()
                .pathParam("id", idProject)
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization","Bearer test123");
    }

    @Step("Get all project")
    public void getProjectHeader(){
        SerenityRest.given()
                .headers("Authorization","Bearer cf3181ac95fcf0abcdcd08aa1ddafeba7824cabd");

    }
    @Step("get project headers invalid token")
    public void getProjectHeaderInvalidToken(){
        SerenityRest.given()
                .headers("Authorization","Bearer 38e03e89042843309ca5a77775d69818a79f3b24xxx");
    }

    @Step("Get a project with id")
    public void getAProjectHeader(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer 38e03e89042843309ca5a77775d69818a79f3b24")
                .pathParam("id", id);
    }
    @Step("Delete user")
    public void deleteProject(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer 1346771ebb10c3a138838a162384911617fd97ba")
                .pathParam("id", id);
    }
    @Step("Delete project")
    public void deleteProject(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer 1346771ebb10c3a138838a162384911617fd97ba")
                .pathParam("id", id);
    }

    @Step("Delete project headers invalid token")
    public void deleteProjectHeaderInvalidToken(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer 1346771ebb10c3a138838a162384911617fd97baXXXX")
                .pathParam("id", id);
    }@Step("Delete project")
    public void deleteProject(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer 1346771ebb10c3a138838a162384911617fd97ba")
                .pathParam("id", id);
    }

    @Step("Delete project headers invalid token")
    public void deleteProjectHeaderInvalidToken(String id){
        SerenityRest.given()
                .headers("Authorization","Bearer 1346771ebb10c3a138838a162384911617fd97baXXXX")
                .pathParam("id", id);
    }
}
