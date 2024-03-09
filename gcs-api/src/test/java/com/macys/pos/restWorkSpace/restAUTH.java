package com.macys.pos.restWorkSpace;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class restAUTH {


    @Test
    public void testAUTH_1() {
        given().auth().none().log().all();
        given().auth().basic("username", "password").log().all(); //basic
        given().auth().preemptive().basic("username", "password").log().all(); //preemptive
        given().auth().none().queryParam("q", "delhi")
                .queryParam("appid", "12ead183fcf16a2f9b30112756c95612") //API Key
                .when().get("api.openweathermap.org/data/2.5/weather").then().log().all().extract().response().asString();
        given().auth().none()
                .headers("Authorization", "Bearer 273ad7ff6a24fd294d9292188994197d576b61b5e774abfa6c5f56ea6a4e38d1") //Bearer Token
                .baseUri("https://gorest.co.in").basePath("/public/v2/users")
                .when().get().then().log().all();

        given().auth().oauth2("accessToken");

    }

    @Test
    public void run() {
        System.out.print("Response" + given().auth().none().queryParam("q", "delhi").queryParam("appid", "12ead183fcf16a2f9b30112756c95612")
                .when().get("api.openweathermap.org/data/2.5/weather").then().extract().response().asString()
        );
    }

}
