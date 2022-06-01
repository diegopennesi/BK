package com.service.backend.BK.Pojo;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Document("User")
public class User {

    @Id
    private String id;
    private String exteralId;
    private String username;
    private String password;
    // allow user to require sensitive order, by default null, turn on or off
    private Boolean sesntiviveBuyAllowed;
    private boolean isActive;
    private boolean isBanned;
    // user minimal info
    private PrivateInfo privateInfo;
    //user access level Profile
    private AccessLevel accessLevel;
    //user minimal address
    private List<Address> addresses;
    private String lastJWT;
    private DateTime lastLogin;
    private MultiValueMap<String,SimpleOrder> orderListSimple;

}
