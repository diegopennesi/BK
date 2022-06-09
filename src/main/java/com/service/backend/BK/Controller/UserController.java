package com.service.backend.BK.Controller;

import com.service.backend.BK.Engine.EngineLogic;
import com.service.backend.BK.Pojo.Address;
import com.service.backend.BK.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    EngineLogic engine;


    @GetMapping("/ping")
        public ResponseEntity test(){
            return ResponseEntity.status(200).body("Ok");
        }

    @GetMapping("/insert")
    public ResponseEntity addUser(){
        // we are moking user, assuming reciving all info by body, still NYI full POJO so assuming all data is OK
        engine.addUser();

        return  ResponseEntity.status(200).body("Success!");
    }
    @GetMapping("/alluser")
    public <T> ResponseEntity alluser(){
        List<T> result= (List<T>) engine.searchAllUser();
                return ResponseEntity.status(200).body(result);
    }
    @GetMapping("/{id}")
    public <T> ResponseEntity getUserbyName(@PathVariable("id") String id) throws Exception {
        User result = engine.getuserbyId(id);
        return ResponseEntity.status(200).body(result);
    }
    @GetMapping("/{id}/address")
    public <T> ResponseEntity getAddressById(@PathVariable("id") String id) throws Exception {
        Address result = engine.getuserAddressbyId(id);
        return ResponseEntity.status(200).body(result);
    }


}
