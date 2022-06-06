package com.service.backend.BK.Pojo;

import com.service.backend.BK.Constants.Constant;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Document("Orders")
public class DetailedOrder {

    @Id
    private String id;
   // private BaseOrder baseOrder;
    @Field
    private List<Integer> category;
    // 1 junk to 10 Pristine
    @Field
    private Integer quality;
    @Field
    private BaseOrder baseOrder;
    @Field
    private String qualityDescription;

    public DetailedOrder(){}
    public DetailedOrder(String Description,Double price, List<Integer> category, Integer quality) {
        this.category = category;
        this.quality = quality;
        this.qualityDescription = qualityDescriptionPairFactory(quality);
        this.baseOrder=new BaseOrder(Description,price);
    }



    public List<Integer> getCategory() {
        return category;
    }
    public void setCategory(List<Integer> category) {
        this.category = category;
    }
    public Integer getQuality() {
        return quality;
    }
    public void setQuality(Integer quality) {
        this.quality = quality;
    }
    public String getQualityDescription() {
        return qualityDescription;
    }
    public void setQualityDescription(String qualityDescription) {
        this.qualityDescription = qualityDescription;}
    private String qualityDescriptionPairFactory(int quality){
        switch (quality){
            case 1:return Constant.Quality.NOGRAD.label;
            case 2:return Constant.Quality.HEAVYDMN.label;
            case 3:return Constant.Quality.LOOSE.label;
            case 4:return Constant.Quality.POOR.label;
            case 5:return Constant.Quality.LIGHTDMN.label;
            case 6:return Constant.Quality.GOOD.label;
            case 7:return Constant.Quality.EXCELENT.label;
            case 8:return Constant.Quality.NEARMINT.label;
            case 9:return Constant.Quality.MINT.label;
            case 10:return Constant.Quality.NEWUNRL.label;
            default:return Constant.Quality.NOGRAD.label;        }
    }
    @Override
    public String toString() {
        return "DetailedOrder{" +
                "id='" + id + '\'' +
                ", baseOrder='" + getBaseOrder().returnBaseOrder() + '\'' +
                ", category=" + category +
                ", quality=" + quality +
                ", qualityDescription='" + qualityDescription + '\'' +
                '}';
    }

    public BaseOrder getBaseOrder() {
        return baseOrder;
    }

    public void setBaseOrder(BaseOrder baseOrder) {
        this.baseOrder = baseOrder;
    }

    public void setId(String id) {
        this.id = id;
    }
}
