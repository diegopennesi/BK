package com.service.backend.BK.Pojo;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("AccessLevel")
public class AccessLevel {

    @Id
    private String id;
    private int accessLevelId;
    private String accessLevelDescription;
    // limit of how many request can user have
    private int accessLevelPendingOrderLimit;
    // limit of how many non paid order can user have, user can't request pending if reach active order limit
    private int accessLevelActiveOrderLimit;
    // limit of how many unfulfilled order can user have, SYSO\MOD can't update pending order to active if reach unfulfill order
    private int accesslevelUnFulfilledOrderLimit;
    // sum of every pending item cost, user can't request any other pending order if reach this limit
    private double accesslevelMaximumAmountPendingRequest;
    // sum of every order request item cost, SYSO\MOD can't update pending order to order request if reach this limit
    private double accesslevelMaximumAmountOrderRequest;
    @Nullable // accesselevel dosen't require payment before turn order from pending to active.
    // it can be whitelisted or blacklisted
    private Boolean accesslevelReliable;
    private String createdBy;
    @Field
    private int castle;
    @Field
    private int realm;

    public AccessLevel() {
    }


    public int getAccessLevelId() {
        return accessLevelId;
    }

    public String getAccessLevelDescription() {
        return accessLevelDescription;
    }

    public int getAccessLevelPendingOrderLimit() {
        return accessLevelPendingOrderLimit;
    }

    public int getAccessLevelActiveOrderLimit() {
        return accessLevelActiveOrderLimit;
    }

    public int getAccesslevelUnFulfilledOrderLimit() {
        return accesslevelUnFulfilledOrderLimit;
    }

    public double getAccesslevelMaximumAmountPendingRequest() {
        return accesslevelMaximumAmountPendingRequest;
    }

    public double getAccesslevelMaximumAmountOrderRequest() {
        return accesslevelMaximumAmountOrderRequest;
    }

    @Nullable
    public Boolean getAccesslevelReliable() {
        return accesslevelReliable;
    }

    public void setAccessLevelId(int accessLevelId) {
        this.accessLevelId = accessLevelId;
    }

    public void setAccessLevelDescription(String accessLevelDescription) {
        this.accessLevelDescription = accessLevelDescription;
    }

    public void setAccessLevelPendingOrderLimit(int accessLevelPendingOrderLimit) {
        this.accessLevelPendingOrderLimit = accessLevelPendingOrderLimit;
    }

    public void setAccessLevelActiveOrderLimit(int accessLevelActiveOrderLimit) {
        this.accessLevelActiveOrderLimit = accessLevelActiveOrderLimit;
    }

    public void setAccesslevelUnFulfilledOrderLimit(int accesslevelUnFulfilledOrderLimit) {
        this.accesslevelUnFulfilledOrderLimit = accesslevelUnFulfilledOrderLimit;
    }

    public void setAccesslevelMaximumAmountPendingRequest(double accesslevelMaximumAmountPendingRequest) {
        this.accesslevelMaximumAmountPendingRequest = accesslevelMaximumAmountPendingRequest;
    }

    public void setAccesslevelMaximumAmountOrderRequest(double accesslevelMaximumAmountOrderRequest) {
        this.accesslevelMaximumAmountOrderRequest = accesslevelMaximumAmountOrderRequest;
    }

    public void setAccesslevelReliable(@Nullable Boolean accesslevelReliable) {
        this.accesslevelReliable = accesslevelReliable;
    }

    public int getCastle() {
        return castle;
    }

    public void setCastle(int castle) {
        this.castle = castle;
    }

    public int getRealm() {
        return realm;
    }

    public void setRealm(int realm) {
        this.realm = realm;
    }

    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        return "AccessLevel{" +
                "accessLevelId=" + accessLevelId +
                ", accessLevelDescription='" + accessLevelDescription + '\'' +
                ", accessLevelPendingOrderLimit=" + accessLevelPendingOrderLimit +
                ", accessLevelActiveOrderLimit=" + accessLevelActiveOrderLimit +
                ", accesslevelUnFulfilledOrderLimit=" + accesslevelUnFulfilledOrderLimit +
                ", accesslevelMaximumAmountPendingRequest=" + accesslevelMaximumAmountPendingRequest +
                ", accesslevelMaximumAmountOrderRequest=" + accesslevelMaximumAmountOrderRequest +
                ", accesslevelReliable=" + accesslevelReliable +
                ", castle=" + castle +
                ", realm=" + realm +
                '}';
    }
}
