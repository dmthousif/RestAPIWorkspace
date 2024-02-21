package com.macys.pos.service.restWorkSpace;

import com.google.gson.JsonObject;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.comparator.JSONComparator;
import wiremock.com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.skyscreamer.jsonassert.JSONCompare.compareJSON;

@Slf4j
public class ValidateResponse {

    Response response;
    static JSONObject expectedresjsonObject;
    String reqBody = "{\n" +
            "  \"firstname\": \"Jim\",\n" +
            "  \"lastname\": \"Brown\",\n" +
            "  \"totalprice\": 111,\n" +
            "  \"depositpaid\": true,\n" +
            "  \"bookingdates\": {\n" +
            "    \"checkin\": \"2018-01-01\",\n" +
            "    \"checkout\": [\n" +
            "      {\n" +
            "        \"checkoutDate\": \"2019-01-01\",\n" +
            "        \"checkoutTime\": \"11PM\",\n" +
            "        \"PaymentStatus\": \"Paid\",\n" +
            "        \"feedback\": \"Satisfied\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"checkoutDate2\": \"2019-01-02\",\n" +
            "        \"checkoutTime2\": \"11PM-2\",\n" +
            "        \"PaymentStatus2\": \"Paid-2\",\n" +
            "        \"feedback2\": \"Satisfied-2\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"additionalneeds\": \"Breakfast\"\n" +
            "}";

    @Test
    public void SendPostCallAndValidateResponse() throws IOException, JSONException {
        response = SerenityRest.rest()
                .given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .auth().none()
                .body(reqBody)
                .when()
                .post("https://restful-booker.herokuapp.com/booking");
        response.then().log().all().statusCode(200);
        if (response.getStatusCode() == 200) {
            log.info("API Call is successfull");
        }
        System.out.println("validateResponse1::" + response.jsonPath().getString("booking.firstname"));
        System.out.println("validateResponse2::" + response.body().jsonPath().getString("booking.firstname"));
        System.out.println("validateResponse3::" + response.body().jsonPath().get("booking.firstname"));
        System.out.println("validateResponse4::" + response.body().jsonPath().get("booking.bookingdates"));
        System.out.println("validateResponse5::" + response.body().jsonPath().getString("booking.bookingdates.checkin"));
        System.out.println("validateResponse6::" + response.body().toString().contains("Jim"));
        System.out.println("validateResponse7::" + response.body().prettyPrint().contains("test"));
        System.out.println("validateResponse8::" + response.then().header("Content-Type", "application/json; charset=utf-8"));
        //System.out.println("validateResponse9::" + response.then().header("Content-Length","197"));
        System.out.println("validateResponse10::" + response.then().cookie("c5-qfi8FRkEeS5rSnSzr62UbMF8oJY"));
        JsonObject jsonobj = new JsonObject();
        // JsonPath jp = new JsonPath(reqBody); // Using rest assured JsonPath, we dont have facility to modify json
        // Assuming reqBody is your JSON string
        String reqBody = "{\"booking\":{\"firstname\":\"\"}}";

         JsonPath.parse(reqBody).set("booking.firstname", "Thousif");

/*        JsonPath jp = JsonPath.parse(reqBody);
        jp.set("booking.firstname", "Thousif");*/
      //jp.set("key","value");







        String expectedResponseBody = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/response/bookBookingResponseNew.json")));
        expectedresjsonObject = new JSONObject(expectedResponseBody); // Using skyscreamer

        String resp = response.body().asString();
        JSONObject actualresjsonObject = new JSONObject(resp);
        List<String> ignorableFields = Arrays.asList("bookingid");
        Set<String> expectedresKeys = getAllKeys(expectedresjsonObject);
        System.out.println("expectedresKeys::" + expectedresKeys);
        for (String key : expectedresKeys) {
            System.out.println("expectedresKey::" + key);
            if (ignorableFields.contains(key)) {
                continue;
            }
            if (actualresjsonObject.has(key)) {

               Object expectedValue = expectedresjsonObject.get(key);
                Object actualValue = actualresjsonObject.get(key);

                if (expectedValue instanceof JSONObject && actualValue instanceof JSONObject) {
                    compareJSON((JSONObject) expectedValue, (JSONObject) actualValue, (JSONComparator) ignorableFields); // Recursively compare nested JSON objects
                } else {
                    Assert.assertEquals(expectedValue.toString(), actualValue.toString()); // Compare non-nested JSON values
                }
                System.out.println("ValuesComparision::" + expectedresjsonObject.get(key).toString().equals(actualresjsonObject.get(key).toString()));
                Assert.assertEquals(expectedresjsonObject.get(key).toString(), actualresjsonObject.get(key).toString());

            }


        }


        /*log.info("expectedresjsonObject"+expectedresjsonObject.get(key).toString(),"actualresjsonObjectValue"+actualresjsonObject.get(key).toString());
        Assert.assertEquals(expectedresjsonObject.get(key),actualresjsonObject.get(key));*/
        System.out.println("getAllKeys::" + getAllKeys(expectedresjsonObject));
    }


    private static Set<String> getAllKeys(JSONObject jsonObject) throws JSONException {
        Set<String> keys = new HashSet<>();
        addKeys(jsonObject, "", keys);
        return keys;
    }

    private static void addKeys(JSONObject jsonObject, String prefix, Set<String> keys) throws JSONException {
        for (Iterator it = jsonObject.keys(); it.hasNext(); ) {
            String key = (String) it.next();
            String fullKey = prefix.isEmpty() ? key : prefix + "." + key;
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                addKeys((JSONObject) value, fullKey, keys);
            } else if (value instanceof JSONArray) {
                handleArray((JSONArray) value, fullKey, keys);
            } else {
                keys.add(fullKey);
            }
        }
    }

    private static void handleArray(JSONArray jsonArray, String prefix, Set<String> keys) throws JSONException {
        for (int i = 0; i < jsonArray.length(); i++) {
            String fullKey = prefix + "[" + i + "]";
            Object value = jsonArray.get(i);
            if (value instanceof JSONObject) {
                addKeys((JSONObject) value, fullKey, keys);
            } else if (value instanceof JSONArray) {
                handleArray((JSONArray) value, fullKey, keys);
            } else {
                keys.add(fullKey);
            }
        }
    }

}
