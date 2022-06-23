package com.service.backend.BK.Engine;

import com.google.gson.Gson;
import com.service.backend.BK.Engine.Repository.UserRepository;
import com.service.backend.BK.Pojo.AccessLevel;
import com.service.backend.BK.Pojo.Address;
import com.service.backend.BK.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EngineLogic {
    Gson gson = new Gson();
    @Autowired
    UserRepository repoUser;
    @Autowired
    Dao dao;

    User createUserTest(){
        // access level are realm resized, every realm can customize access level, they will came from DB
        //Assuming calling DAO to retrive specific access level info
        Byte [] pic = new Byte[0];
        User r= new User("TestN","TestC","TestFb");
        r.setUsername("User");
        r.setPassword("Pass");
        r.setSesntiviveBuyAllowed(true);
        r.setActive(true);
        r.setBanned(true);
        r.setAccessLevel(createAccessLevelTest());
        List<String> addresList= new ArrayList<>();
        System.out.println(createAddresstest());
        addresList.add(0,createAddresstest());
        r.setAddresses(addresList);
        Map<Integer,Integer> realmCity = new HashMap<>();
        realmCity.put(1,1);
        r.setCityCastleAccess(realmCity);
        r.setLastJWT("JWT_TEST");
        r.setLastLogin(new Date());
        return r;
    }
    String createAddresstest(){
        Address ad= new Address();
        ad.setCountry("TestCountry");
        ad.setState("TestState");
        ad.setCity("TestCity");
        ad.setAdress1("Address1");
        ad.setNote("Note001");
        ad.setCap("00001");
        return  ad.toDocumentFormat(ad);
    }
    List<AccessLevel> createAccessLevelTest(){
        AccessLevel ac= new AccessLevel();
        ac.setAccessLevelId(1);
        ac.setAccessLevelDescription("Test Access Level");
        ac.setAccessLevelPendingOrderLimit(1);
        ac.setAccesslevelUnFulfilledOrderLimit(1);
        ac.setAccesslevelMaximumAmountOrderRequest(1);
        ac.setAccesslevelMaximumAmountOrderRequest(1);
        ac.setAccesslevelReliable(true);
        ac.setCity(1);
        List<AccessLevel> response= new ArrayList<>();
        response.add(ac);
        return response;


    }
    ////~~~REGISTER CONTROLLER~~~////
    public boolean changePassword(Map map) throws Exception {
        User a = gson.fromJson(gson.toJson(map), User.class);
        dao.getUserByUsername(a.getUsername(), false);
        repoUser.save(a);
        return true;
    }
    public boolean registerNewUser(Map map) throws Exception {
        // we will recive MultivaluedMAP and then convert it into our MODEL
        User a = gson.fromJson(gson.toJson(map), User.class);
        dao.getUserByUsername(a.getUsername(), true);
        repoUser.save(a);
        return true;
    }
    ////~~~USER CONTROLLER~~~////
    public boolean addUser(){
        // search into DB if username\fbprofile Exist if true
        User user=createUserTest();
        //repoUser.save(user);
        repoUser.save(user);
        return false;
    }
    public List<User> searchAllUser(){
      return  dao.searchAlluser();
    }
    public User getuserbyId(String username) throws Exception {
        User s = dao.getUserByUsername(username,false);
        return s;
    }
    public Address getuserAddressbyId(String username) throws Exception {
        User s = dao.getUserByUsername(username,false);
        Gson gson = new Gson();
        return gson.fromJson(s.getAddresses().get(0),Address.class);
    }

}
