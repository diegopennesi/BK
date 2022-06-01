package com.service.backend.BK.Pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document("Orders")
public class DetailedOrder extends BaseOrder {

    @Id
    private String id;
    private BaseOrder baseOrder;
    private List<Integer> category;
    // 1 junk to 10 Pristine
    private Integer quality;
    private String qualityDescription;



}
