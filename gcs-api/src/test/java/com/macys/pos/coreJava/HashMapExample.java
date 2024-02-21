package com.macys.pos.coreJava;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonObjectParser;
import com.google.gson.JsonObject;
import io.grpc.internal.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static java.util.Collections.replaceAll;

public class HashMapExample {

    public static void main(String[] args) throws IOException, JSONException {
        Map<String, Object> hashmap1 = new LinkedHashMap<String, Object>();
        Map<String, Object> hashmap2 = new LinkedHashMap<String, Object>();
        String expRespJsonPath = "C:\\Users\\Thousif_Danki\\Documents\\Automation\\LearnAutomation\\Automation\\gcs-api\\src\\test\\resources\\response\\bookBookingResponse.json";
        String expRespJson = new String(Files.readAllBytes(Paths.get(expRespJsonPath)));
        ObjectMapper objectMapper = new ObjectMapper();
        // Convert string to JsonNode (JSON object)
        JsonNode jsonObject = objectMapper.readTree(expRespJson);
        // Create a HashMap to store the JSON object
        Map<String, Object> map = new LinkedHashMap<>();
        // Convert JsonNode to Map
        map.putAll(objectMapper.convertValue(jsonObject, Map.class));
        //Iterate HashMap
        JsonObject jsonObj = new JsonObject(); //Using Google gson
        JsonParser.parse(expRespJson).toString();
        Iterator it = new JSONObject(expRespJson).keys(); //using org.json
        while (it.hasNext()) {
            System.out.println("expRespJson::" + it.next());

        }
        System.out.println("responseBodyInaLinkedHashMap::" + map);
        //Using for each + Keyset()
        for (String key : map.keySet()) {
            Object value = map.get(key);
            System.out.println("LinkedHashMap::" + value);
        }
        //using Iterator + entrySet()
        Iterator res = map.entrySet().iterator();
        while (res.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) res.next();
            System.out.println ("Iterator");
            System.out.println ("key::"+entry.getKey() + "value::"+ entry.getValue());
        }

        //using iterator + EntrySet()

        for(Map.Entry<String,Object> entry: map.entrySet()){

            System.out.println ("forEach");
            System.out.println ("key::"+entry.getKey() + "value::"+ entry.getValue());
        }


        //
        hashmap1.putAll(hashmap2); // copies all the data from 1 to 2
        hashmap2.containsKey("key"); //returns true or false
        hashmap1.replaceAll((BiFunction<? super String, ? super Object, ?>) hashmap2);

    }


    //Data into hashMap stored in key value pairs
    //Insertion order is not mainted in HashMap and mainted in LinkedHashMap
    //It contains duplicate values but not the keys
    //It can have single null key
    //not synchronised, whereas hashtable is synchronised


}
