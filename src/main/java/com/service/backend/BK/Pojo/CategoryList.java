package com.service.backend.BK.Pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Category")
public class CategoryList {

    @Field
    private int internalValue;
    @Field
    private String Description;
    @Field
    private int realmClassification;

}
