package com.service.backend.BK.Controller;

import com.google.gson.Gson;
import com.service.backend.BK.Constants.Constant;
import com.service.backend.BK.Pojo.BaseOrder;
import com.service.backend.BK.Pojo.DetailedOrder;
import com.service.backend.BK.Repository.DetailedOrderRepository;
import com.service.backend.BK.Service.Test1Service;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("test")
public class Test {

    @Autowired
    Test1Service testService;
    @Autowired
    DetailedOrderRepository repo;

    @GetMapping
    public String ping(){
        return "Richiamato metodo ping";
    }

    @GetMapping("mongo")
    public List<com.service.backend.BK.Pojo.Test> mongotest(){
      return  testService.getAll();
    }
    @GetMapping("mongowrite")
    public List<String> mongowrite(){
        List<Integer> listt= new ArrayList<>();
        listt.add(3);
        DetailedOrder dt= new DetailedOrder("Oggetto di test",10.00,listt,9);
        repo.insert(dt);
        return Collections.singletonList(dt.toString());
    }
    @GetMapping("yoda")
    public DetailedOrder yoda(){
        List<Integer> listt= new ArrayList<>();
        listt.add(3);
        DetailedOrder dt= new DetailedOrder("Oggetto di test",10.00,listt,9);
        System.out.println(dt.toString());
        return dt;
    }
    @GetMapping("mongoread")
        public List<DetailedOrder> mongoread(){
       List< DetailedOrder> responseDoc= repo.searchBaseOrderById("6");
        return responseDoc;
        }
    @GetMapping("mongoupd")
    public DetailedOrder mongoupd(){
        List<DetailedOrder> responseDoc= repo.searchBaseOrderById("5555");
        responseDoc.get(0).getBaseOrder().setDescription("oggetto modificato!!!!!!!!!!");
        ObjectId test = new ObjectId("629df5716d228f48d1ef6097");
        System.out.println(test.getTimestamp());

        System.out.println(responseDoc.toString());
        return repo.save(responseDoc.get(0));
    }

    @GetMapping("mongowrite2")
    public List<String> mongowrite2(){
        List<Integer> listt= new ArrayList<>();
        listt.add(3);
        DetailedOrder dt= new DetailedOrder("Oggetto di test",10.00,listt,9);
        //dt.setId("33");
        return Collections.singletonList(dt.getBaseOrder().toString());

    }
}
