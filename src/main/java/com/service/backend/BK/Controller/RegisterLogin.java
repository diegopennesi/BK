package com.service.backend.BK.Controller;

import com.service.backend.BK.Engine.EngineLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("register")
public class RegisterLogin {

    @Autowired
    EngineLogic engine;

    @GetMapping
    public ResponseEntity register() throws Exception {
        // assuming we recive from front\app a bodyrequest
        // assuming we validate body request
        // assuming we calidate request by security
        // we will send the body as Hashmap MAP java key: value and then parse via Bson\Json
        boolean response = false;
        Map<String, Object> body = new HashMap<>();
        body.put("username","Username01");
        body.put("password","Password01");
       try{  response=engine.registerNewUser(body);}
       catch (Exception e ){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
        return ResponseEntity.status(200).body(response);
    }//TO REMOVE
    @GetMapping("/changepass/{user}/{pass}")
        public ResponseEntity changepassword(@PathVariable("user") String user,@PathVariable("pass") String pass) throws Exception {
        boolean response = false;
        Map<String, Object> body = new HashMap<>();
        body.put("username",user);
        body.put("password",pass);
        response=engine.changePassword(body);
        return ResponseEntity.status(200).body(response);
        }

}
