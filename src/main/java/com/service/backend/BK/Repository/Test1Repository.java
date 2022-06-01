package com.service.backend.BK.Repository;

import com.service.backend.BK.Pojo.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface Test1Repository extends MongoRepository<Test,String> {
    @Query("{test1:'?0'}")
    Test findItemBytest1(String field);
}
