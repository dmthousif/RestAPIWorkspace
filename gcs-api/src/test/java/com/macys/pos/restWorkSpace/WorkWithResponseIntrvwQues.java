package com.macys.pos.restWorkSpace;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;
import wiremock.com.jayway.jsonpath.DocumentContext;
import wiremock.com.jayway.jsonpath.JsonPath;

import java.util.*;

public class WorkWithResponseIntrvwQues {
    static String responseString = "{\"dashboard\":{\"purchaseAmount\":1162,\"website\":\"Hello.com\"},\"courses\":[{\"title\":\"Selenium Python\",\"price\":50,\"copies\":6},{\"title\":\"Cypress\",\"price\":40,\"copies\":4},{\"title\":\"RPA\",\"price\":45,\"copies\":10},{\"title\":\"Appium\",\"price\":36,\"copies\":7}]}";

    @Test
    public void processWithJackson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseString);
            // 1. Print titles
            System.out.println("Titles:");
            JsonNode courses = root.get("courses");
            for (JsonNode course : courses) {
                System.out.println(course.get("title").asText());
            }
            // 2. Calculate Price * Copies for all courses
            int totalCost = 0;
            for (JsonNode course : courses) {
                int price = course.get("price").asInt();
                int copies = course.get("copies").asInt();
                totalCost += price * copies;
            }
            // 3. Compare with purchaseAmount
            int purchaseAmount = root.get("dashboard").get("purchaseAmount").asInt();
            if (totalCost == purchaseAmount) {
                System.out.println("Total cost matches purchase amount: " + totalCost);
            } else {
                System.out.println("Total cost does not match purchase amount. Total cost: " + totalCost);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void processWithGson() {
        JsonObject jsonObject = JsonParser.parseString(responseString).getAsJsonObject();
        JsonArray courses = jsonObject.getAsJsonArray("courses");
        // 1. Print titles
        System.out.println("Titles:");
        for (JsonElement course : courses) {
            System.out.println(course.getAsJsonObject().get("title").getAsString());
        }
        // 2. Calculate Price * Copies for all courses
        int totalCost = 0;
        for (JsonElement course : courses) {
            JsonObject courseObj = course.getAsJsonObject();
            int price = courseObj.get("price").getAsInt();
            int copies = courseObj.get("copies").getAsInt();
            totalCost += price * copies;
        }
        // 3. Compare with purchaseAmount
        int purchaseAmount = jsonObject.getAsJsonObject("dashboard").get("purchaseAmount").getAsInt();
        if (totalCost == purchaseAmount) {
            System.out.println("Total cost matches purchase amount: " + totalCost);
        } else {
            System.out.println("Total cost does not match purchase amount. Total cost: " + totalCost);
        }
    }
    @Test
    public void processWithJayWay() {
        // Parse JSON string to DocumentContext
        DocumentContext jsonContext = JsonPath.parse(responseString);
        // 1. Print titles
        System.out.println("Titles:");
        jsonContext.read("$.courses[*].title", List.class).forEach(System.out::println);
        // 2. Calculate Price * Copies for all courses
        ArrayList<Integer> prices = jsonContext.read("$.courses[*].price");
        List<Integer> copies = jsonContext.read("$.courses[*].copies");

        int totalCost = 0;
        for (int i = 0; i < prices.size(); i++) {
            totalCost += prices.get(i) * copies.get(i);
        }
        // 3. Compare with purchaseAmount
        int purchaseAmount = jsonContext.read("$.dashboard.purchaseAmount");
        if (totalCost == purchaseAmount) {
            System.out.println("Total cost matches purchase amount: " + totalCost);
        } else {
            System.out.println("Total cost does not match purchase amount. Total cost: " + totalCost);
        }
    }
}

