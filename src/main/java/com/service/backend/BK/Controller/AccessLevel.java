package com.service.backend.BK.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.service.backend.BK.Engine.EngineLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("accessLevel")
public class AccessLevel {
    @Autowired
    EngineLogic engine;

    @PostMapping
    public ResponseEntity<String> addAccessLevel(@RequestBody Map request) throws Exception {
        // assuming we calidate request by security
        // assuming we recive userID who operate via JWT
        // moking into request till implementation of security JWT

        String response = "";
        try {
            checkMap(request);
            response = engine.putAccessLevel(request);
        } catch (AssertionError | Exception x) {
            return org.springframework.http.ResponseEntity.status(HttpStatus.BAD_REQUEST).body(x.getMessage());
        }
        return org.springframework.http.ResponseEntity.status(200).body(response);
    }

    @GetMapping
    public ResponseEntity<String> searchAccessLevel(@RequestBody Map<String, Integer[]> request) throws Exception {
        String response = "";
        // assuming we calidate request by security
        // assuming we recive userID who operate via JWT
        // moking into request till implementation of security JWT
        // assuming we will recive a Map of our pojo RealmCastle
        try {
            for (String x : request.keySet()
            ) {
                Integer.parseInt(x);
            }
            response = engine.searchAccessLevel(request);
        } catch (AssertionError x) {
            return org.springframework.http.ResponseEntity.status(HttpStatus.BAD_REQUEST).body(x.getMessage());
        } catch (NumberFormatException y) {
            return org.springframework.http.ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Body not correct, please refer to Documentation in order to provide the correct body for this request");
        }
        return org.springframework.http.ResponseEntity.status(200).body(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAccessLevel(@RequestBody String request) throws Exception {
        boolean response = false;
        // assuming we calidate request by security
        // assuming we recive userID who operate via JWT
        try {
            JsonObject x = new Gson().fromJson(request, JsonObject.class);
            assert !x.get("castle").toString().equals("") : ("Missing Fileds!");
            assert !x.get("realm").toString().equals("") : ("Missing Fileds!");
            assert !x.get("accessLevelId").toString().equals("") : ("Missing Fileds!");
            assert !x.get("id").toString().equals("") : ("Missing Fileds!");
            response = engine.deleteAccessLevel(x);
        } catch (AssertionError x) {
            return org.springframework.http.ResponseEntity.status(HttpStatus.BAD_REQUEST).body(x.getMessage());
        } catch (JsonParseException y) {
            return org.springframework.http.ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Body not correct, please refer to Documentation in order to provide the correct body for this request");
        }
        return org.springframework.http.ResponseEntity.status(200).body("" + response); // ( ͡° ͜ʖ ͡°)
    }

    private void checkMap(Map map) throws AssertionError {
        assert map.containsKey("accessLevelDescription") : ("Missing Fileds!");
        assert map.containsKey("accessLevelPendingOrderLimit") : ("Missing Fileds!");
        assert map.containsKey("accessLevelActiveOrderLimit") : ("Missing Fileds!");
        assert map.containsKey("accesslevelUnFulfilledOrderLimit") : ("Missing Fileds!");
        assert map.containsKey("accesslevelMaximumAmountPendingRequest") : ("Missing Fileds!");
        assert map.containsKey("accesslevelMaximumAmountOrderRequest") : ("Missing Fileds!");
        assert map.containsKey("accesslevelReliable") : ("Missing Fileds!");
        assert map.containsKey("castle") : ("Missing Fileds!");
        assert map.containsKey("realm") : ("Missing Fileds!");
        assert map.containsKey("createdBy") : ("Missing Fileds!");
    }
}
