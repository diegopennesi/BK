package com.service.backend.BK.Pojo;

import org.springframework.data.annotation.PersistenceConstructor;

public class PrivateInfo {

    private String name;
    private String surname;
    private String facebookProfile;
    private String telegramProfile;
    private String whatsAppProfile;
    //NYI after release
    private Byte[] profilePic;

    @PersistenceConstructor
    protected PrivateInfo(String name, String surname, String facebookProfile, String telegramProfile, String whatsAppProfile, Byte[] profilePic) {
        this.name = name;
        this.surname = surname;
        this.facebookProfile = facebookProfile;
        this.telegramProfile = telegramProfile;
        this.whatsAppProfile = whatsAppProfile;
        this.profilePic = profilePic;
    }
    protected  PrivateInfo(String name,String surname,String facebookProfile){
        this.name=name;
        this.surname=surname;
        this.facebookProfile=facebookProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFacebookProfile() {
        return facebookProfile;
    }

    public void setFacebookProfile(String facebookProfile) {
        this.facebookProfile = facebookProfile;
    }

    public String getTelegramProfile() {
        return telegramProfile;
    }

    public void setTelegramProfile(String telegramProfile) {
        this.telegramProfile = telegramProfile;
    }

    public String getWhatsAppProfile() {
        return whatsAppProfile;
    }

    public void setWhatsAppProfile(String whatsAppProfile) {
        this.whatsAppProfile = whatsAppProfile;
    }

    public Byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Byte[] profilePic) {
        this.profilePic = profilePic;
    }

}
