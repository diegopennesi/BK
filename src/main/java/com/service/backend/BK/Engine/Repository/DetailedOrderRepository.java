package com.service.backend.BK.Engine.Repository;
import com.service.backend.BK.Pojo.DetailedOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DetailedOrderRepository extends MongoRepository<DetailedOrder,String>{
    @Query("{'baseOrder._id':'?0'}")
    List<DetailedOrder> searchBaseOrderById(String field);
    DetailedOrder findTheBiggestBy(String field);

}
