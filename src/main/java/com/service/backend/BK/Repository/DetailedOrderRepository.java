package com.service.backend.BK.Repository;

import com.service.backend.BK.Pojo.DetailedOrder;
import com.service.backend.BK.Pojo.Test;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DetailedOrderRepository extends MongoRepository<DetailedOrder,String> {
    @Query("{'baseOrder._id':'?0'}")
    List<Document> searchBaseOrderById(String field);
    @Query("{'_id:'?0'}")
    Document updateBaseOrderById(Document updatedDocument);
}
