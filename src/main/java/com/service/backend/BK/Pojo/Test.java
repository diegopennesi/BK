package com.service.backend.BK.Pojo;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("test1")
public class Test  {

    @Id
    private String id;
    @Nullable
    private String test1;

    public Test() {
    }

    public Test(String id, @Nullable String test1) {
        this.id = id;
        this.test1 = test1;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTest1() {
        return test1;
    }
    public void setTest1(String test1) {
        this.test1 = test1;
    }
}
