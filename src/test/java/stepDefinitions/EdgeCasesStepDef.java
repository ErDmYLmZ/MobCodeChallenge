package stepDefinitions;

import io.cucumber.java.en.Then;

public class EdgeCasesStepDef {
    @Then("user verifies the response body is empty")
    public void user_verifies_the_response_body_is_empty() {

    }

    @Then("user verifies the status code is {int}")
    public void userVerifiesTheStatusCodeIs(int statusCode) {

    }

    @Then("user verifies that is wrong {string}")
    public void userVerifiesThatIsWrong(String title) {
    }
}
