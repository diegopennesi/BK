package com.service.backend.BK.Controller;

import com.service.backend.BK.Engine.EngineLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("accessLevel")
public class AccessLevel {
    @Autowired
    EngineLogic engine;

    @PostMapping
    public ResponseEntity addAccessLevel(@RequestBody Map request) throws Exception {
        // assuming we calidate request by security
        // assuming we recive userID who operate via JWT
        // moking into request till implementation of security JWT
        request.put("createdBy","Admin");
        boolean response = false;
        try {
            checkMap(request);
            response = engine.putAccessLevel(request);
        } catch (AssertionError | Exception x) {
            return org.springframework.http.ResponseEntity.status(HttpStatus.BAD_REQUEST).body(x.getMessage());
        }
        return org.springframework.http.ResponseEntity.status(200).body(response);
        }

        @GetMapping
        public ResponseEntity searchAccessLevel (@RequestBody Map<String,Integer[]> request) throws Exception {
            Map<String,String> response = new HashMap<>();
            // assuming we calidate request by security
            // assuming we recive userID who operate via JWT
            // moking into request till implementation of security JWT
            // assuming we will recive a Map of our pojo RealmCastle
            try{
                for (String x: request.keySet()
                     ) {
                    Integer.parseInt(x);
                }
                response = engine.searchAccessLevel(request);
            }catch (AssertionError | Exception x) {
                return org.springframework.http.ResponseEntity.status(HttpStatus.BAD_REQUEST).body(x.getMessage());
            }
            return org.springframework.http.ResponseEntity.status(200).body(response);
        }


    private void checkMap(Map map) throws AssertionError{
        assert map.containsKey("accessLevelDescription"):("Missing Fileds!");
        assert map.containsKey("accessLevelPendingOrderLimit"):("Missing Fileds!");
        assert map.containsKey("accessLevelActiveOrderLimit"):("Missing Fileds!");
        assert map.containsKey("accesslevelUnFulfilledOrderLimit"):("Missing Fileds!");
        assert map.containsKey("accesslevelMaximumAmountPendingRequest"):("Missing Fileds!");
        assert map.containsKey("accesslevelMaximumAmountOrderRequest"):("Missing Fileds!");
        assert map.containsKey("accesslevelReliable"):("Missing Fileds!");
        assert map.containsKey("castle"):("Missing Fileds!");
        assert map.containsKey("realm"):("Missing Fileds!");
        assert map.containsKey("createdBy"):("Missing Fileds!");
    }
}
