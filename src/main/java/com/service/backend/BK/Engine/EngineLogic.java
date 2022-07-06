package com.service.backend.BK.Engine;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.service.backend.BK.Engine.Repository.AccessLevelRepository;
import com.service.backend.BK.Engine.Repository.UserRepository;
import com.service.backend.BK.Pojo.AccessLevel;
import com.service.backend.BK.Pojo.Address;
import com.service.backend.BK.Pojo.RealmCastle;
import com.service.backend.BK.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EngineLogic {
    Gson gson = new Gson();
    @Autowired
    UserRepository repoUser;
    @Autowired
    AccessLevelRepository repoAccess;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    Dao dao;


    User createUserTest() {
        // access level are realm resized, every realm can customize access level, they will came from DB
        //Assuming calling DAO to retrive specific access level info
        Byte[] pic = new Byte[0];
        User r = new User("TestN", "TestC", "TestFb");
        r.setUsername("User");
        r.setPassword("Pass");
        r.setSesntiviveBuyAllowed(true);
        r.setActive(true);
        r.setBanned(true);
        r.setAccessLevel(createAccessLevelTest());
        List<String> addresList = new ArrayList<>();
        System.out.println(createAddresstest());
        addresList.add(0, createAddresstest());
        r.setAddresses(addresList);
        Map<Integer, Integer> realmCity = new HashMap<>();
        realmCity.put(1, 1);
        r.setRealmCastleAccess(realmCity);
        r.setLastJWT("JWT_TEST");
        r.setLastLogin(new Date());
        return r;
    }

    String createAddresstest() {
        Address ad = new Address();
        ad.setCountry("TestCountry");
        ad.setState("TestState");
        ad.setCity("TestCity");
        ad.setAdress1("Address1");
        ad.setNote("Note001");
        ad.setCap("00001");
        return ad.toDocumentFormat(ad);
    }

    List<AccessLevel> createAccessLevelTest() {
        AccessLevel ac = new AccessLevel();
        ac.setAccessLevelId(1);
        ac.setAccessLevelDescription("Test Access Level");
        ac.setAccessLevelPendingOrderLimit(1);
        ac.setAccesslevelUnFulfilledOrderLimit(1);
        ac.setAccesslevelMaximumAmountOrderRequest(1);
        ac.setAccesslevelMaximumAmountOrderRequest(1);
        ac.setAccesslevelReliable(true);
        ac.setCastle(1);
        ac.setRealm(1);
        List<AccessLevel> response = new ArrayList<>();
        response.add(ac);
        return response;


    }

    ////~~~REGISTER CONTROLLER~~~////
    public boolean changePassword(Map map) throws Exception {
        User a = gson.fromJson(gson.toJson(map), User.class);
        User b = dao.getUserByUsername(a.getUsername(), false);
        a.setPassword(b.getPassword());
        repoUser.save(a);
        return true;
    }

    public boolean registerNewUser(Map map) throws Exception {
        User a = gson.fromJson(gson.toJson(map), User.class);
        List<AccessLevel> listAcceslevel = new ArrayList<>();
        // assuming now just 1 access level, we need to iterate for each entry
        listAcceslevel.add(dao.getAccessLevelByIDByRealmByCastle(
                (int) map.get("LevelOfAccess"),
                (int) map.get("realm"),
                (int) map.get("castle"), false));
        if (listAcceslevel.get(0) == null) throw new Exception("No access level Found!");
        a.setAccessLevel(listAcceslevel);
        dao.getUserByUsername(a.getUsername(), true);
        repoUser.save(a);
        return true;
    }
    public String login (Map request) throws Exception{
        User a=dao.getUserByFilters(request,false);
        //do something over JWT token
        // SAVE LAST ACCESS
        return gson.toJson(a);
    }

    public boolean addUser() {
        // search into DB if username\fbprofile Exist if true
        User user = createUserTest();
        //repoUser.save(user);
        repoUser.save(user);
        return false;
    }

    public List<User> searchAllUser() {
        return dao.searchAlluser();
    }

    public User getuserbyId(String username) throws Exception {
        User s = dao.getUserByUsername(username, false);
        return s;
    }

    public Address getuserAddressbyId(String username) throws Exception {
        User s = dao.getUserByUsername(username, false);
        Gson gson = new Gson();
        return gson.fromJson(s.getAddresses().get(0), Address.class);
    }


    public String putAccessLevel(Map request) throws Exception {
        // search into DB if username\fbprofile Exist if true
        AccessLevel a = gson.fromJson(gson.toJson(request), AccessLevel.class);
        a.setAccessLevelId(dao.findGreaterAMONGUS((int) request.get("castle"), (int) request.get("realm"), false));
        repoAccess.save(a);
        return a.getId();
    }

    public String searchAccessLevel(Map request) {
        return gson.toJson(dao.searchAccessLevel(request));
    }

    @Deprecated
    public boolean putAccessLevel() {
        // search into DB if username\fbprofile Exist if true
        AccessLevel accessLevel = createUserTest().getAccessLevel().get(0);
        //repoUser.save(user);
        repoAccess.save(accessLevel);
        return false;
    }

    public Boolean deleteAccessLevel(JsonObject request) throws Exception {
        AccessLevel search = dao.getAccessLevelByIDByRealmByCastle(
                Integer.parseInt(request.get("accessLevelId").toString()),
                Integer.parseInt(request.get("realm").toString()),
                Integer.parseInt(request.get("castle").toString()), false);
        boolean response = request.get("id").getAsJsonPrimitive().getAsString().equals(search.getId());
        if (response) {
            repoAccess.delete(search);
            return true;
        }
        return false;
    }


    /////////////////////////UTILITY////////////////////////////////////////
    private <T> Object fromMapToModel(Map request, Class<T> instance) {
        return gson.fromJson(gson.toJson(request), instance);
    }

}
