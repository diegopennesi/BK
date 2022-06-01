package com.service.backend.BK.Controller;

import com.service.backend.BK.Pojo.SimpleOrder;
import com.service.backend.BK.Service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class Test {

    @Autowired
    Test1Service testService;

    @GetMapping
    public String ping(){
        return "Richiamato metodo ping";
    }

    @GetMapping("mongo")
    public List<com.service.backend.BK.Pojo.Test> mongotest(){
      return  testService.getAll();
    }
    @GetMapping("mongowrite")
    public void mongowrite(){
        testService.insert(new com.service.backend.BK.Pojo.Test("id999","testInsert"));
      //  SimpleOrder sp = new SimpleOrder();
    }
}
