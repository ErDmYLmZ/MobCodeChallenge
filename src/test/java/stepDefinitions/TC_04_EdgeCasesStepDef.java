package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import setUp.JsonPlaceHolderBaseUrl;

import static io.restassured.RestAssured.given;

@Slf4j
public class TC_04_EdgeCasesStepDef extends JsonPlaceHolderBaseUrl {

    @When("user searches for invalid {string}")
    public void userSearchesForInvalid(String invalidUsername) {
        log.info("User searches for an invalid username");
        response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}?username=" + invalidUsername);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("user verifies the response body is empty")
    public void user_verifies_the_response_body_is_empty() {
        log.info("Empty response body is verified");
        var emptyList = response.jsonPath().getList("username");
        Assert.assertEquals(0, emptyList.size());
    }

    @Given("user sets the invalid {string}")
    public void userSetsTheInvalid(String invaliEndPoint) {
        log.info("User sets an invalid endpoint");
        spec.pathParam("first", invaliEndPoint);

    }

    @When("user searches for an {string}")
    public void userSearchesForAn(String id) {
        log.info("User searches for a valid id");
        response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}?id=" + id);
    }

    @Then("user verifies the status code is {int}")
    public void userVerifiesTheStatusCodeIs(int statusCode) {
        log.info("Status code:404 is verified");
        Assert.assertEquals(404, response.getStatusCode());
    }

    @Given("user sets the {string} with {string} query parameters and makes a search")
    public void userSetsTheWithQueryParameters(String endPoint, String id) {
        log.info("User sends a request with an id query parameter");
        spec.pathParam("first", endPoint).queryParam("id", id);
        response = given().spec(spec).get("/{first}");
    }

    @Then("user verifies that is wrong {string}")
    public void userVerifiesThatIsWrong(String title) {
        log.info("Wrong title is verified");
        Assert.assertFalse("Title does not match", response.jsonPath().getList("title").equals(title));

    }


}
