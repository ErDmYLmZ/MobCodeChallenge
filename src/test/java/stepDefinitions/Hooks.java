package stepDefinitions;

import io.cucumber.java.Before;

import static setUp.JsonPlaceHolderBaseUrl.jsonPlaceHolderSetup;

public class Hooks {
    @Before (value = "@Url")
    public static void setUrl(){
    jsonPlaceHolderSetup();
}
}

