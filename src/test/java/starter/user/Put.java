package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Put {

    protected String url = "https://reqres.in/api";

    @Step("I set PUT api endpoints")
    public String setPutApiEndpoints(){
        return url + "/users/2";
    }
    @Step("I send PUT HTTP request")
    public void sendPutHttpRequest(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name","morpheus");
        requestBody.put("job","zion resident");

        SerenityRest.given().header("Content-Type","application/json").body(requestBody.toJSONString()).put(setPutApiEndpoints());
    }
    @Step("I receive valid data for update user")
    public void validateUpdateUser(){
        restAssuredThat(response -> response.body("'name'", equalTo("morpheus")));
        restAssuredThat(response -> response.body("'job'", equalTo("zion resident")));
    }
}
