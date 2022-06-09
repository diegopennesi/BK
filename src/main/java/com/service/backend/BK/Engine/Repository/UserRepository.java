package com.service.backend.BK.Engine.Repository;

import com.service.backend.BK.Pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {

    List<User> findAllByRealmClassification(int[] realm);
}
