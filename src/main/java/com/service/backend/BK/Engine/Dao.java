package com.service.backend.BK.Engine;

import com.service.backend.BK.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Dao {

    @Autowired
    MongoTemplate db;

    public void test(){}
    public List<User> searchAlluser(){
        List<User> result = db.findAll(User.class);
        return result;
    }
    public User getUserByUsername(String username,boolean nullable) throws Exception {
        Query q = new Query();
        q.addCriteria(new Criteria().andOperator(
                Criteria.where("username").is(username)));
        User respose= db.findOne(q,User.class);
        // Nullable check if i need or not a return NULL for my search
        if (respose == null && !nullable){// there is no record, i do not accept nullable record. I NEED a record!
            throw new Exception("Entity not found!");
        }
        else if (respose != null && nullable){
            throw new Exception("Entity Already present!");
        }
        return respose;
    }
}
