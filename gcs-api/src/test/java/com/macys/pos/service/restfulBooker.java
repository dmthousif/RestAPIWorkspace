package com.macys.pos.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.macys.pos.common.ConfigProperties;
import com.macys.pos.utils.IgnorableJsonComparator;
import com.macys.pos.utils.restUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class restfulBooker extends restUtils {
    public restfulBooker() {
        this.getClass();
    }

    private static Response response;

    /*@Step("user makes post call")
    public void userMakesPostCall() {
       response =  SerenityRest.rest()
                                .given().spec(restUtils.buildSpec())
                                .when()
                                    .post();
        response.then().log().all();

    }*/

    @Step("user makes post call")
    public void sendPostRequest(String req) throws IOException {
        response = RestAssured
                .given().log().all()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .auth().none()
                .body(req)
                .when().post(ConfigProperties.getBaseUrl());

    }

    @Step
    public void user_makes_get_call() {
        response = SerenityRest.rest()
                .given()
                .when()
                .get("https://reqres.in/api/users");
        response.then().log().all();
    }

    @Step("verify service response")
    public void verifyServiceResponse(String expRespJson) throws IOException {

        List<String> ignorableFields = Arrays.asList("bookingid","totalprice");
        if (response != null && !response.equals("") && expRespJson != null && !expRespJson.equals("")) {
            JSONCompareResult result = null;
            try {
                result = JSONCompare.compareJSON(
                        expRespJson,
                        response.asString(),
                        new IgnorableJsonComparator(JSONCompareMode.NON_EXTENSIBLE, ignorableFields));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            log.info("Expected " + expRespJson);
            log.info("Actual " + response.asString());
            log.info(result.toString());
            Assert.assertEquals(" assertion of the comparison failed at " + result.getMessage(), result.passed(), true);
        }
    }

    @Step
    public void verifyResponseCode(int expectedStatusCode) {
        log.info("APIResponseCode::" + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @Step
    public void sendPostRequestWithAllPossiblePreRequisite() throws JsonProcessingException {
        String firstName = RestAssured
                .given()
                .headers(getHeaders())
                .cookies(getCookies())
                .auth().preemptive().basic("userName","password")
                .baseUri(ConfigProperties.getBaseUrl())
                .body(buildRequestBody())

                .when()
                .post("URL")

                .then()
                .extract().response()
                .jsonPath().get("firstName");
    }

    public Response getResponse() {
        return response;
    }
}
