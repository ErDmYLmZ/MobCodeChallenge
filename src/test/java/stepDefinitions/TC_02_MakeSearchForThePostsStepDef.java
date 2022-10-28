package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import setUp.JsonPlaceHolderBaseUrl;

import static io.restassured.RestAssured.given;

@Slf4j
public class TC_02_MakeSearchForThePostsStepDef extends JsonPlaceHolderBaseUrl {

    @When("user makes a search for the posts written by {string}")
    public void user_makes_a_search_for_the_posts_written_by(String id) {
        log.info("User searches posts for an valid id");
        response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}?id=" + id);
        Assert.assertEquals("Status code is not 200 ", 200, response.getStatusCode());
    }

    @Then("user verifies the {string}")
    public void user_verifies_the(String title) {
        log.info("Correct title is verified");
        Assert.assertTrue(response.asString().contains(title));


    }
}
