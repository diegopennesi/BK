package com.service.backend.BK.Engine;

import com.service.backend.BK.Pojo.AccessLevel;
import com.service.backend.BK.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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
        }
        else if (respose != null && nullable){
            throw new Exception("Entity Already present!");
        }
        return respose;
    }



    /////////////////////////////////
    public int findGreaterAMONGUS(int castle,int realm,boolean nullable){
        Query q = new Query();
        q.addCriteria(new Criteria().andOperator(
                (Criteria.where("realm").is(realm).and("castle").is(castle))))
                .with(Sort.by("accessLevelId").descending())
                .limit(1);
        AccessLevel response=db.findOne(q,AccessLevel.class);
        if(response==null) return 1;
        return response.getAccessLevelId()+1;
    }

    public AccessLevel getAccessLevelByIDByRealmByCastle(int id,int realm,int castle,boolean nullable) throws Exception {
            Query q = new Query();
            q.addCriteria(new Criteria().andOperator(
                    Criteria.where("accessLevelId").is(id).where("realm").is(realm).where("castle").is(castle)));
            AccessLevel response=db.findOne(q,AccessLevel.class);
        if (response == null && !nullable){// there is no record, i do not accept nullable record. I NEED a record!
        }
        else if (response != null && nullable){
            throw new Exception("Entity Already present!");
        }
        return response;
    }
    public AccessLevel searchAccessLevel(Map<String,Integer[]> request){
        Query q = new Query();
        Criteria c = new Criteria();
        request.forEach((k,v)-> {
            for (int i: Arrays.asList(v)
                 ) {
                System.out.println(k+"-"+i);
                // lets' change it to criteria add HERE!
            }
        });

        // for eache key set Realm and iterate for each Castle
        // add a new Criteria here Realm x Castle for every combination in every KeySet
        // q.addCriteria(c.andOperator(c.where()))
        return null;
    }
}
