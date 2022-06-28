package com.service.backend.BK.Engine.Repository;

import com.service.backend.BK.Pojo.AccessLevel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessLevelRepository extends MongoRepository<AccessLevel,String> {
}
