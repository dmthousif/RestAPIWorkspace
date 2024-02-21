package com.macys.pos.service.restWorkSpace;

import org.checkerframework.checker.units.qual.Prefix;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.PseudoTextElement;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class getKeysFromResponse {

    String APIResponse = new String(Files.readAllBytes(Paths.get("C:\\Users\\Thousif_Danki\\Documents\\Automation\\LearnAutomation\\Automation\\gcs-api\\src\\test\\resources\\response\\bookBookingResponseNew.json")));

    public getKeysFromResponse() throws IOException {
    }


    @Test
    public void getKeysFromResponse() throws IOException, JSONException {
        JSONObject jsonObject = new JSONObject(APIResponse);
       Set reponseKeys =  getAllKey(jsonObject);
        System.out.println("reponseKeys"+reponseKeys);
        for(Object key : reponseKeys){
            System.out.println("key::"+key.toString());
        }
    }

    public Set getAllKey(JSONObject jsonObject) throws JSONException {
        Set<String> keys = new HashSet<String>();
        AddKeys(jsonObject, "", keys);
        return keys;


    }

    private void AddKeys(JSONObject jsonObject, String Prefix, Set<String> keys) throws JSONException {
        for (Iterator it = jsonObject.keys(); it.hasNext(); ) {
            String key = (String) it.next();
            String fullKey = Prefix.isEmpty() ? key : Prefix + "." + key;
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                AddKeys((JSONObject) value, fullKey, keys);
            } else if (value instanceof JSONArray) {
                handleArray((JSONArray) value, fullKey, keys);
            } else {
                keys.add(fullKey);
            }
        }

    }

    private void handleArray(JSONArray jsonArray, String Prefix, Set<String> keys) throws JSONException {

        for(int i=0;i<jsonArray.length();i++){
            String fullKey = Prefix + "["+i+"]";
            Object value = jsonArray.get(i);
            if (value instanceof JSONObject) {
                AddKeys((JSONObject) value, fullKey, keys);
            } else if (value instanceof JSONArray) {
                handleArray((JSONArray) value, fullKey, keys);
            } else {
                keys.add(fullKey);
            }
        }
    }
}
