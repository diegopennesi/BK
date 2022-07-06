package com.service.backend.BK.Controller;

import com.service.backend.BK.Engine.EngineLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping("register")
public class RegisterLogin {

    @Autowired
    EngineLogic engine;

    @PostMapping
    public ResponseEntity register(@RequestBody Map request) throws Exception {
        // assuming we recive from front\app a bodyrequest
        // assuming we validate body request
        // assuming we calidate request by security
        // we will send the body as Hashmap MAP java key: value and then parse via Bson\Json
        boolean response = false;
       /* Map<String, Object> body = new HashMap<>();
        body.put("username","Username01");
        body.put("password","Password01");*/
       try{
           checkMap(request);
           response=engine.registerNewUser(request);}
       catch (AssertionError | Exception x){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(x.getMessage());
       }
        return ResponseEntity.status(200).body(response);
    }
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map request) throws Exception{
        String response="";
        try{
            checkMapV2(request, Arrays.asList("username","password"));
            request.keySet().retainAll(new HashSet<>(Arrays.asList("username", "password")));
           // request.forEach((k,v)-> System.out.println(k+"."+v));
            response=engine.login(request);
        }catch (AssertionError | Exception x){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(x.getMessage());
        }
        return ResponseEntity.status(200).body(response);
    }

        private void checkMap(Map map) throws AssertionError{
           assert map.containsKey("username"):("Missing Fileds!");
           assert map.containsKey("password"):("Missing Fileds!");
           assert map.containsKey("privateInfo"):("Missing Fileds!");
           assert map.containsKey("LevelOfAccess"):("Missing Fileds!");
           assert map.containsKey("addresses"):("Missing Fileds!");
           assert map.containsKey("castle"):("Missing Fileds!");
           assert map.containsKey("realm"):("Missing Fileds!");
        }
        private void checkMapV2(Map request, List<String> tocheck){
            for (String fieldTocheck: tocheck
                 ) {
                assert request.containsKey(fieldTocheck):("Missing Fileds!");
            }
        }
}
