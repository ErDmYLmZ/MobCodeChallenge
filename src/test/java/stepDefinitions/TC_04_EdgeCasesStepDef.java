package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.matchers.JUnitMatchers;
import setUp.JsonPlaceHolderBaseUrl;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.*;

public class TC_04_EdgeCasesStepDef extends JsonPlaceHolderBaseUrl {


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

    @Given("user sets the {string} with {string} query parameters and makes a search")
    public void userSetsTheWithQueryParameters(String endPoint, String id) {
        spec.pathParam("first", endPoint).queryParam("id", id);
        response=given().spec(spec).get("/{first}");
    }

    @Then("user verifies that is wrong {string}")
    public void userVerifiesThatIsWrong(String title) {
        Assert.assertFalse("Title does not match",response.jsonPath().getList("title").equals(title));

    }




}
