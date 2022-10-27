package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import setUp.JsonPlaceHolderBaseUrl;

import static io.restassured.RestAssured.*;

public class EdgeCasesStepDef extends JsonPlaceHolderBaseUrl {
    //private Response response;

    @When("user searches for invalid {string}")
    public void userSearchesForInvalid(String invalidUsername) {
        response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}?username=" + invalidUsername);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("user verifies the response body is empty")
    public void user_verifies_the_response_body_is_empty() {
        var emptyList = response.jsonPath().getList("username");
        Assert.assertEquals(0, emptyList.size());
    }

    @Given("user sets the invalid {string}")
    public void userSetsTheInvalid(String invaliEndPoint) {
        spec.pathParam("first", invaliEndPoint);

    }

    @When("user searches for an {string}")
    public void userSearchesForAn(String id) {
        response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}?id=" + id);
    }

    @Then("user verifies the status code is {int}")
    public void userVerifiesTheStatusCodeIs(int statusCode) {
        Assert.assertEquals(404, response.getStatusCode());
    }

    @Then("user verifies that is wrong {string}")
    public void userVerifiesThatIsWrong(String title) {
        response.prettyPrint();
    }
}
