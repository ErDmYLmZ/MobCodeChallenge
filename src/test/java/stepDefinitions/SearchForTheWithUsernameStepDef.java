package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import setUp.JsonPlaceHolderBaseUrl;
import static io.restassured.RestAssured.*;
public class SearchForTheWithUsernameStepDef extends JsonPlaceHolderBaseUrl {

    //private Response response;

    @Given("user sets the {string}")
    public void userSetsTheWith(String endPoint){
        spec.pathParam("first", endPoint);
    }

    @When("user searches for a {string}")
    public void user_searches_for_a(String username) {
        response = given().spec(spec).when().get("/{first}?username="+ username);
    }

    @Then("the status code is verified as {int}")
    public void the_status_code_is_verified_as(Integer statusCode) {
        Assert.assertEquals(200, response.statusCode());
    }

    @Then("the Content type is verified as {string}")
    public void the_content_type_is_verified_as(String ContentType) {
        Assert.assertEquals(ContentType,response.contentType());

    }
    @Then("the received information should contain {string},{string},{string}")
    public void the_received_information_should_contain(String expectedId, String expectedName, String expectedUsername) {
        Assert.assertTrue(response.asString().contains(expectedId));
        Assert.assertTrue(response.asString().contains(expectedName));
        Assert.assertTrue(response.asString().contains(expectedUsername));


    }
}
