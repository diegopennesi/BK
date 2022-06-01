package com.service.backend.BK.Pojo;

import com.mongodb.lang.Nullable;

public class AccessLevel {

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


}
