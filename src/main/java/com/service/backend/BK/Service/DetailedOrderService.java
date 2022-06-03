package com.service.backend.BK.Service;

import com.service.backend.BK.Pojo.DetailedOrder;
import com.service.backend.BK.Repository.DetailedOrderRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailedOrderService {

    @Autowired
    DetailedOrderRepository repo;

    public void insert(DetailedOrder order){
        repo.insert(order);}

    public List<Document> searchBaseOrderById(String DetailOrderId){
        return repo.searchBaseOrderById(DetailOrderId);
    }
    public Document updateDocument(Document oldDocument){}
    
}
