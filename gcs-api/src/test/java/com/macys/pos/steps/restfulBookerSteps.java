package com.macys.pos.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.macys.pos.service.restfulBooker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class restfulBookerSteps extends restfulBooker {

    String req=null;
    String expRespJson=null;

    @When("Create the Json from the file {}")
    public void create_the_json_from_the_file(String fileName) throws IOException {
        buildRequestBody(fileName);
    }

    @When("Create the Json using Pojo")
    public void create_the_json_using_pojo() throws JsonProcessingException {
        buildRequestBody();
    }

    @And("Override the field {} with value {}")
    public void override_the_field_with_value(String fieldName, Object value) {
        req = overRideValues(fieldName, value);
    }


    @When("user makes post call")
    public void user_makes_post_call() throws IOException {
        sendPostRequest(req);
    }

    @Then("verify service response {int}")
    public void verify_service_response(Integer expectedStatusCode) {
        verifyResponseCode(expectedStatusCode);
    }

    @Then("verify service response body {}")
    public void verify_service_response_body(String responseBody) throws IOException {
        expRespJson = getResponseBody(responseBody);
        verifyServiceResponse(expRespJson);
    }

}
