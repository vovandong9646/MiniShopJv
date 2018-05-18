package com.dongvv2.persistence.data;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_type")
	private TypeProductEntity typeProductEntity;
	
	private String description;
	
	@Column(name="unit_price")
	private float unitPrice;
	
	@Column(name="promotion_price")
	private float promotionPrice;
	
	private String image;
	private String unit;

	@Column(name = "new")
	private int news;

	private Timestamp created_at;
	private Timestamp updated_at;
	
	@OneToMany(mappedBy="productEntity", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<BillDetailEntity> listBillDetailEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
