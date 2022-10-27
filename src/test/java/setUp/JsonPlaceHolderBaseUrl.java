package setUp;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigurationReader;


public class JsonPlaceHolderBaseUrl {

   protected Response response;

   protected static RequestSpecification spec;
    public static void jsonPlaceHolderSetup(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.get("Url")).build();
    }
}
