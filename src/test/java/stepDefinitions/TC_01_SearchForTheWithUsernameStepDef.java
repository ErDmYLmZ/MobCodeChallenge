package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import setUp.JsonPlaceHolderBaseUrl;

import static io.restassured.RestAssured.given;

@Slf4j
public class TC_01_SearchForTheWithUsernameStepDef extends JsonPlaceHolderBaseUrl {

    @Given("user sets the {string}")
    public void userSetsTheWith(String endPoint) {
        log.info("Endpoint is set without query parameter");
        spec.pathParam("first", endPoint);
    }

    @When("user searches for a {string}")
    public void user_searches_for_a(String username) {
        log.info("Get request was sent for an username");
        response = given().spec(spec).when().get("/{first}?username=" + username);
    }

    @Then("the status code is verified as {int}")
    public void theStatusCodeIsVerifiedAs(int statuscode) {
        log.info("Status code 200 is verified");
        Assert.assertEquals(200, response.statusCode());

    }

    @Then("the Content type is verified as {string}")
    public void the_content_type_is_verified_as(String ContentType) {
        log.info("Content type is verified");
        Assert.assertEquals(ContentType, response.contentType());

    }

    @Then("the received information should contain {string},{string},{string}")
    public void the_received_information_should_contain(String expectedId, String expectedName, String expectedUsername) {
        log.info("Assertion is done with valid data");
        Assert.assertTrue(response.asString().contains(expectedId));
        Assert.assertTrue(response.asString().contains(expectedName));
        Assert.assertTrue(response.asString().contains(expectedUsername));
    }

     {
    }
}
