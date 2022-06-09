package com.service.backend.BK.Pojo;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document("User")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    // allow user to require sensitive order, by default null, turn on or off
    private Boolean sesntiviveBuyAllowed;
    private boolean isActive;
    private boolean isBanned;
    // user minimal info
    private PrivateInfo privateInfo;
    //user access level Profile, user can have multiple access level per Realm, but 1 access level per Castle
    private List<AccessLevel> accessLevel;
    //user minimal address
    private List<String> addresses;
    private Map<Integer,Integer> cityCastleAccess;
    private String lastJWT;
    private Date lastLogin;
    private HashMap<String,BaseOrder> orderListSimple;
    @PersistenceConstructor
    public User(String id, String username, String password, Boolean sesntiviveBuyAllowed, boolean isActive, boolean isBanned, @Nullable PrivateInfo privateInfo, List<AccessLevel> accessLevel, List<String> addresses, Map<Integer,Integer> cityCastleAccess, @Nullable String lastJWT, @Nullable Date lastLogin, @Nullable HashMap<String, BaseOrder> orderListSimple) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sesntiviveBuyAllowed = sesntiviveBuyAllowed;
        this.isActive = isActive;
        this.isBanned = isBanned;
        this.privateInfo = privateInfo;
        this.accessLevel = accessLevel;
        this.addresses = addresses;
        this.cityCastleAccess = cityCastleAccess;
        this.lastJWT = lastJWT;
        this.lastLogin = lastLogin;
        this.orderListSimple = orderListSimple;
    }

    //################################################################################################################//
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSesntiviveBuyAllowed() {
        return sesntiviveBuyAllowed;
    }

    public void setSesntiviveBuyAllowed(Boolean sesntiviveBuyAllowed) {
        this.sesntiviveBuyAllowed = sesntiviveBuyAllowed;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public PrivateInfo getPrivateInfo() {
        return privateInfo;
    }

    public void setPrivateInfo(PrivateInfo privateInfo) {
        this.privateInfo = privateInfo;
    }
    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
    public String getLastJWT() {
        return lastJWT;
    }

    public void setLastJWT(String lastJWT) {
        this.lastJWT = lastJWT;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<AccessLevel> getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(List<AccessLevel> accessLevel) {
        this.accessLevel = accessLevel;
    }
    public Map<Integer,Integer> getCityCastleAccess() {
        return cityCastleAccess;
    }
    public void setCityCastleAccess(Map<Integer,Integer> cityCastleAccess) {
        this.cityCastleAccess = cityCastleAccess;
    }
    public HashMap<String, BaseOrder> getOrderListSimple() {
        return orderListSimple;
    }

    public void setOrderListSimple(HashMap<String, BaseOrder> orderListSimple) {
        this.orderListSimple = orderListSimple;
    }
    //################################################################################################################//

    public User(String name, String surname,String profileFb){
        this.privateInfo = new PrivateInfo(name,surname,profileFb);
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sesntiviveBuyAllowed=" + sesntiviveBuyAllowed +
                ", isActive=" + isActive +
                ", isBanned=" + isBanned +
                ", privateInfo=" + privateInfo +
                ", accessLevel=" + accessLevel +
                ", addresses=" + addresses +
                ", realmClassification=" + cityCastleAccess + // todo print inline map!
                ", lastJWT='" + lastJWT + '\'' +
                ", lastLogin=" + lastLogin +
                ", orderListSimple=" + orderListSimple +
                '}';
    }

}
