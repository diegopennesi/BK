package com.service.backend.BK.Pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("baseOrder")
public class BaseOrder {
     @Id
     private String id;
     private String description;
     private Double desideredPrice;
     //Pending,active,Rejected,Hault,etc etc
     private String status;

     public BaseOrder(String description, Double desideredPrice) {
          this.description = description;
          this.desideredPrice = desideredPrice;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public Double getDesideredPrice() {
          return desideredPrice;
     }

     public void setDesideredPrice(Double desideredPrice) {
          this.desideredPrice = desideredPrice;
     }
}
