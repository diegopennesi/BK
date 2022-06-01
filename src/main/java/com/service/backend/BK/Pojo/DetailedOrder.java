package com.service.backend.BK.Pojo;

import com.service.backend.BK.Constants.Constant;
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

    public DetailedOrder(BaseOrder baseOrder, List<Integer> category, Integer quality, Constant.Quality qualityDescription) {
        super(baseOrder.getDescription(), baseOrder.getDesideredPrice());
        this.baseOrder = baseOrder;
        this.category = category;
        this.quality = quality;
        this.qualityDescription = qualityDescription;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public BaseOrder getBaseOrder() {
        return baseOrder;
    }

    public void setBaseOrder(BaseOrder baseOrder) {
        this.baseOrder = baseOrder;
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
        this.qualityDescription = qualityDescription;
    }
}
