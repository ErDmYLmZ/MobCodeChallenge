package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Assert;
import setUp.JsonPlaceHolderBaseUrl;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class EmailValidationInTheCommentSectionStepDef extends JsonPlaceHolderBaseUrl {

    private Response response;

    @When("user fetches the comments")
    public void user_fetches_the_comments() {
        response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}");
        Assert.assertEquals("Status code is not 200 ", 200, response.getStatusCode());


    }
    @Then("user validates the emails are in proper format")
    public void user_validates_the_emails_are_in_proper_format() {
       List<String> emails = response.jsonPath().getList("email");
       emails.stream().map(t-> EmailValidator.getInstance().isValid(t)).collect(Collectors.toList());

    }
}
