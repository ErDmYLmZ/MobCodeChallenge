package setUp;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;



public class JsonPlaceHolderBaseUrl {
    protected static RequestSpecification spec;
    public static void jsonPlaceHolderSetup(){
        spec = new RequestSpecBuilder().setBaseUri("http://localhost:3000").build();
    }
}
