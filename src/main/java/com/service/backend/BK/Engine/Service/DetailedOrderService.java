package com.service.backend.BK.Engine.Service;
import com.service.backend.BK.Pojo.DetailedOrder;
import com.service.backend.BK.Engine.Repository.DetailedOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailedOrderService {

    @Autowired
    DetailedOrderRepository repo;
    @Autowired
    MongoTemplate mongoDb;


    public void insert(DetailedOrder order){
        repo.insert(order);}

    public List<DetailedOrder> searchBaseOrderById(String DetailOrderId){
        return repo.searchBaseOrderById(DetailOrderId);
    }

    public DetailedOrder findTheBiggestBy(String byWhat){
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC,byWhat)).limit(1);
        return mongoDb.findOne(query,DetailedOrder.class);
    }

 //imnplementare metodi di Template in DAO non in RepositoryPattern



   }
    

