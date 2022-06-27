package com.service.backend.BK.Engine.Repository;

import com.service.backend.BK.Pojo.User;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

public interface UserRepository extends MongoRepository<User,String> {



}
