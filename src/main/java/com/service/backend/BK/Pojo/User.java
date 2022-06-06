package com.service.backend.BK.Pojo;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Document("User")
public class User {

    @Id
    private String id;
    @Field
    private String exteralId;
    @Field
    private String username;
    @Field
    private String password;
    @Field
    // allow user to require sensitive order, by default null, turn on or off
    private Boolean sesntiviveBuyAllowed;
    @Field
    private boolean isActive;
    @Field
    private boolean isBanned;
    @Field
    // user minimal info
    private PrivateInfo privateInfo;
    @Field
    //user access level Profile
    private AccessLevel accessLevel;
    @Field
    //user minimal address
    private List<Address> addresses;
    @Field
    private int realmClassification;
    @Field
    private String lastJWT;
    @Field
    private DateTime lastLogin;
    @Field
    private MultiValueMap<String,BaseOrder> orderListSimple;
    //################################################################################################################//
}
