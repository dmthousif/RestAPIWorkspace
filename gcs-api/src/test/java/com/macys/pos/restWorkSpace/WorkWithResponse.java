package com.macys.pos.restWorkSpace;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

@Slf4j
public class WorkWithResponse {

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

    public WorkWithResponse() throws JSONException {
    }

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
        validateResponse();
    }

    public void validateResponse() throws JSONException {
        JSONObject jsonObject = new JSONObject(reqBody);
        JSONObject bookingdates = jsonObject.getJSONObject("bookingdates");
        JSONArray checkout = bookingdates.getJSONArray("checkout");
        System.out.println("checkoutjsonArray" + checkout);

        for (int i = 0; i < checkout.length(); i++) {
            Object Value = checkout.get(i);
            System.out.println("checkout.get("+i+")" + Value);
            if (Value instanceof JSONObject) {
                for (Iterator it = ((JSONObject) Value).keys(); it.hasNext(); ) {

                    Object key = it.next();
                    System.out.println("Checkout::Key::" + key
                   + "::Value::" + ((JSONObject) Value).get(key.toString()));
                }
            }
            System.out.println(Value);
        }
        // Map<String, Object> map = new LinkedHashMap<String,Object>();
        //System.out.println(checkout.getString("feedback"));
    }
}
