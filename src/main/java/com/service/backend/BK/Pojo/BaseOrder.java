package com.service.backend.BK.Pojo;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

 public class BaseOrder {
     private String id;
     private String description;
     private Double desideredPrice;
     //Pending,active,Rejected,Hault,etc etc
     private int status;
     //###############################################################################################################//
     protected  BaseOrder(){}
     protected  BaseOrder(String description, Double desideredPrice) {
          this.id = pseudIncrementalValue();
          this.description = description;
          this.desideredPrice = desideredPrice;
     }
     public String returnBaseOrder(){
          return "BaseOrder{" +
                  "id='" + id + '\'' +
                  ", description='" + description + '\'' +
                  ", desideredPrice=" + desideredPrice +
                  ", status=" + status +
                  '}';
     }
     //###############################################################################################################//
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
     public String getId() {
          return id;
     }
     public void setId(String id) {
          this.id = id;
     }
     //###############################################################################################################//
     private String pseudIncrementalValue(){
         DateTime td=new DateTime();
         StringBuilder sb = new StringBuilder();
         sb.append(td.getChronology());
         return sb.toString();
     }
}
