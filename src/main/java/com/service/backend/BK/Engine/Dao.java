package com.service.backend.BK.Engine;

import com.service.backend.BK.Pojo.AccessLevel;
import com.service.backend.BK.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.Map.Entry;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
            throw new Exception("No Entity Found!");
        }
        else if (respose != null && nullable){
            throw new Exception("Entity Already present!");
        }
        return respose;
    }
    public List<User> getUserByFilters(Map request, boolean nullable) throws Exception {
        Query q = new Query();
        Criteria c = new Criteria();
        request.forEach((k, v) ->
                q.addCriteria((Criteria.where(demapper(k)).is(v))));
        List<User> respose = db.find(q, User.class);
        if (respose == null && !nullable) {// no record, and i need a record
            throw new Exception("No Entity Found!");
        } else if (respose != null && nullable) {// record is present, i need nullable, error
            throw new Exception("Entity Already present!");
        }
        return respose;
    }
    private String demapper(Object k) {
        String response = "";
        switch (k.toString()) {
            case "realm":
                response = "accessLevel.realm";
                break;
            case "castle":
                response = "accessLevel.castle";
                break;
            case "accessLevelId":
                response = "accessLevel._id";
                break;
            case "facebookProfile":
                response = "privateInfo.facebookProfile";
                break;
            default:
                response = k.toString();
        }
        return response;
    }
    /////////////////////////////////
    // query in order to check the increment, we could write into another document, but it would be non secure way to
    // track internal incremental ID.
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
    public List<AccessLevel> searchAccessLevel(Map<String,Integer[]> request){
        // this method should be allow admin to see just own Realm x City it dosen't
        // perform too well for an cross-Realm Admin.
        // admin query TBD in v2
        Query q = new Query();
        Criteria c = new Criteria();
        List<AccessLevel> response = new ArrayList<>();
        for (String k : request.keySet()
             ) {
            q.addCriteria(c.andOperator(
                    Criteria.where("realm").is(Integer.parseInt(k)),
                    Criteria.where("castle").in(Arrays.asList(request.get(k)))));
            response.addAll(db.find(q,AccessLevel.class));
            q=new Query();
            c=new Criteria();
        }
        return response;
    }
}
