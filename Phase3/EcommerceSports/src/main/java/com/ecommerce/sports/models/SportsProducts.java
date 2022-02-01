package com.ecommerce.sports.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="product")
public class SportsProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ProductId;
	
	private String ProductName;
	private String ProductBrand;
	private String ProductCategory;
	@Column(name="price")
	private int ProductPrice;
	private String ProductColor;
	
	@Column(name="created_date")
	private String ProductCreatedDate;
	private int ProductDiscount;
	private int ProductQuantity;
	
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		this.ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductBrand() {
		return ProductBrand;
	}
	public void setProductBrand(String productBrand) {
		ProductBrand = productBrand;
	}
	public String getProductCategory() {
		return ProductCategory;
	}
	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}
	public int getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}
	public String getProductColor() {
		return ProductColor;
	}
	public void setProductColor(String productColor) {
		ProductColor = productColor;
	}
	public String getProductCreatedDate() {
		return ProductCreatedDate;
	}
	public void setProductCreatedDate(String productCreatedDate) {
		ProductCreatedDate = productCreatedDate;
	}
	public int getProductDiscount() {
		return ProductDiscount;
	}
	public void setProductDiscount(int productDiscount) {
		ProductDiscount = productDiscount;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
	
	
}
