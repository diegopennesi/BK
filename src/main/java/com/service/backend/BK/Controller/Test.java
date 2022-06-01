package com.service.backend.BK.Controller;

import com.service.backend.BK.Constants.Constant;
import com.service.backend.BK.Pojo.BaseOrder;
import com.service.backend.BK.Pojo.DetailedOrder;
import com.service.backend.BK.Service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
        BaseOrder bs=new BaseOrder("Test1",90.0000);
        List<Integer> listt= new ArrayList<>();
        listt.add(3);
        DetailedOrder dt= new DetailedOrder(bs,listt,9, Constant.Quality.MINT);
    }
}
