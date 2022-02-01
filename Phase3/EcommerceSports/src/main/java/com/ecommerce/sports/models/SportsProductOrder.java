package com.ecommerce.sports.models;

public class SportsProductOrder {

	private SportsUser user;
	private SportsProducts product;
	public SportsUser getUser() {
		return user;
	}
	public void setUser(SportsUser user) {
		this.user = user;
	}
	public SportsProducts getProduct() {
		return product;
	}
	public void setProduct(SportsProducts product) {
		this.product = product;
	}

}
