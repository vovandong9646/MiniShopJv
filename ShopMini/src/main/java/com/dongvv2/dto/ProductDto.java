package com.dongvv2.dto;

import com.dongvv2.persistence.data.BillDetailEntity;
import com.dongvv2.persistence.data.TypeProductEntity;

import java.sql.Timestamp;
import java.util.List;

public class ProductDto {
    private int id;
    private String name;
    private TypeProductEntity typeProductEntity;
    private String description;
    private float unitPrice;
    private float promotionPrice;
    private String image;
    private String unit;
    private int news;
    private Timestamp created_at;
    private Timestamp updated_at;
    private List<BillDetailEntity> listBillDetailEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeProductEntity getTypeProductEntity() {
        return typeProductEntity;
    }

    public void setTypeProductEntity(TypeProductEntity typeProductEntity) {
        this.typeProductEntity = typeProductEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(float promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNews() {
        return news;
    }

    public void setNews(int news) {
        this.news = news;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public List<BillDetailEntity> getListBillDetailEntity() {
        return listBillDetailEntity;
    }

    public void setListBillDetailEntity(List<BillDetailEntity> listBillDetailEntity) {
        this.listBillDetailEntity = listBillDetailEntity;
    }
}
