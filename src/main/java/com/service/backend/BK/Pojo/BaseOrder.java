package com.service.backend.BK.Pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("baseOrder")
public class BaseOrder {


     private String baseOrderId;
     private String description;
     private Double desideredPrice;
     //Pending,active,Rejected,Hault,etc etc
     private int status;

     protected  BaseOrder(){}
     protected  BaseOrder(String description, Double desideredPrice) {
          this.baseOrderId ="5555";
          this.description = description;
          this.desideredPrice = desideredPrice;
     }
     public String returnBaseOrder(){
          return "BaseOrder{" +
                  "id='" + baseOrderId + '\'' +
                  ", description='" + description + '\'' +
                  ", desideredPrice=" + desideredPrice +
                  ", status=" + status +
                  '}';
     }

     public String getBaseOrderId() {
          return baseOrderId;
     }

     public void setBaseOrderId(String baseOrderId) {
          this.baseOrderId = baseOrderId;
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

     public int getStatus() {
          return status;
     }

     public void setStatus(int status) {
          this.status = status;
     }
}
