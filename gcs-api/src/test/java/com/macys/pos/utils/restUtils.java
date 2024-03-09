package com.macys.pos.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.macys.pos.common.ConfigProperties;
import com.macys.pos.pojos.Booking;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;
import wiremock.com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class restUtils {
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    ObjectMapper objectMapper;
    String req;


    @Before
    public static RequestSpecification buildSpec() {
        requestSpecification = RestAssured.given();
        requestSpecification.contentType("application/json")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .header("Authorization", "Bearer your_access_token")
                .auth().none()
                .baseUri(ConfigProperties.getBaseUrl());
        return requestSpecification;

    }

    public static ResponseSpecification retriewSpec() {
        responseSpecification = rest().expect();
        responseSpecification.statusCode(201);
        responseSpecification.contentType("application/json");
        responseSpecification.contentType("application/json; charset=utf-8");
        responseSpecification.header("Content-Type", containsString("application/json"));
        responseSpecification.header("Server", equalTo("Apache"));
        // Verify cookies (assuming there's a cookie named "sessionId" with value "1234567890")
        responseSpecification.cookie("sessionId", "1234567890");
        return responseSpecification;
    }

    /* public static String replaceValue(String jsonReq, String jsonPath, String newValue){

        DocumentContext context = JsonPath.parse(jsonReq);
        String modifiedJsonReq = context.set(jsonPath, newValue).jsonString();
        return modifiedJsonReq;
    }*/

    public static String replaceValue(String jsonReq, String jsonPath, String newValue) {
        return JsonPath.parse(jsonReq).set(jsonPath, newValue).jsonString();
    }


    public static JsonNode replaceValueUsingJacksonlib(JsonNode jsonNode, String jsonPath, String newValue) {
        // Traverse JSON using JSON path
        String[] pathElements = jsonPath.split("/");
        JsonNode currentNode = jsonNode;
        for (String pathElement : pathElements) {
            if (!pathElement.isEmpty()) {
                if (currentNode.isObject()) {
                    currentNode = currentNode.path(pathElement);
                } else if (currentNode.isArray()) {
                    int index = Integer.parseInt(pathElement);
                    currentNode = currentNode.get(index);
                }
            }
        }
        // Update value at the specified JSON path
        if (currentNode instanceof ObjectNode) {
            ((ObjectNode) currentNode).put("", newValue);
        }
        return currentNode;
    }

    public String buildRequestBody(String fileName) throws IOException {
        String pathToReq = System.getProperty("user.dir") + "/src/test/resources/payloads/" + fileName;
        req = new String(Files.readAllBytes(Paths.get(pathToReq)));
        return req;
    }

    public String buildRequestBody() throws JsonProcessingException {
        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        Booking.BookingDates bookingDates = new Booking.BookingDates("2018-01-01", "2019-01-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");
        objectMapper = new ObjectMapper();
        req = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return req;
    }

    public String getResponseBody(String fileName) throws IOException {
        String expRespJsonPath = System.getProperty("user.dir") + "/src/test/resources/response/" + fileName;
        String expRespJson = new String(Files.readAllBytes(Paths.get(expRespJsonPath)));
        return expRespJson;
    }

    public String overRideValues(String fieldName, Object value) {
        return JsonPath.parse(req).set(fieldName, value).jsonString();
    }

    public Map getHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("restHeaderKey1", "restHeaderValue1");
        headers.put("restHeaderKey2", "restHeaderValue2");
        headers.put("restHeaderKey3", "restHeaderValue3");
        headers.put("restHeaderKey4", "restHeaderValue");
        return headers;
    }

    public Map getCookies() {
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put("restkey1", "restCookie1");
        cookies.put("restkey2", "restCookie2");
        cookies.put("restkey3", "restCookie3");
        cookies.put("restkey4", "restCookie4");
        return cookies;
    }


}