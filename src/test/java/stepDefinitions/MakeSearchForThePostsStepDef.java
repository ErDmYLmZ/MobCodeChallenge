package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import setUp.JsonPlaceHolderBaseUrl;

import static io.restassured.RestAssured.given;

public class MakeSearchForThePostsStepDef extends JsonPlaceHolderBaseUrl {
   //private Response response;
    @When("user makes a search for the posts written by {string}")
    public void user_makes_a_search_for_the_posts_written_by(String id) {
        response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}?id="+ id);
        Assert.assertEquals("Status code is not 200 ", 200, response.getStatusCode());
    }
    @Then("user verifies the {string}")
    public void user_verifies_the(String title) {
        Assert.assertTrue(response.asString().contains(title));


    }
}
