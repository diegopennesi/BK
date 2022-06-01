package com.service.backend.BK.Pojo;

import org.springframework.data.annotation.Id;

public class SimpleOrder {
    @Id
    private String id;
    private String description;
    private BaseOrder detailedOrder;

    public SimpleOrder(DetailedOrder order){
        this.id=order.getId();
        this.description=order.getDescription();
    }
}
