package com.ecommerce.sports.service;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce.sports.models.SportsProductOrder;
import com.ecommerce.sports.models.SportsProducts;
import com.ecommerce.sports.models.SportsUser;

@Repository
public class SportsProductOrderMySQLDAO {
	private final JdbcTemplate jdbcTemplate;
	public SportsProductOrderMySQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	 
	public List<SportsProductOrder> getAllPurchaseOrders() {
		return jdbcTemplate.query("SELECT * FROM product_order", (rs, rowNum) -> {
			
			SportsProductOrder order = new SportsProductOrder();
			int productId = rs.getInt(2);
			int userId = rs.getInt(3);
			
			SportsProducts product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE product_id = ?", (rs1, rowNum1) -> {
				SportsProducts productInner = new SportsProducts();
				System.out.println(rs1.getInt(1)+"----------------Product ID-------------");
				productInner.setProductId(rs1.getInt(1));
				productInner.setProductBrand(rs1.getString(2));
				productInner.setProductCategory(rs1.getString(3));
				productInner.setProductColor(rs1.getString(4));
				productInner.setProductCreatedDate(rs1.getString(5));
				productInner.setProductDiscount(rs1.getInt(6));
				productInner.setProductPrice(rs1.getInt(7));
				productInner.setProductName(rs1.getString(8));
				productInner.setProductQuantity(rs1.getInt(9));
				return productInner;
			}, productId);
			SportsUser user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE user_id = ?", (rs2, rowNum2) -> {
				SportsUser u = new SportsUser();
				u.setUserId(rs2.getInt(1));
				u.setEmailId(rs2.getString(2));
				u.setPassWord(rs2.getString(3));
				u.setContact(rs2.getString(4));
				u.setUserName(rs2.getString(5));
				return u;
			}, userId);
			
			order.setProduct(product);
			order.setUser(user);
			return order;
					
		});
		
	}
	
	public List<SportsProductOrder> getFilteredOrders(String date, String category) {
        List<SportsProductOrder> orders = getAllPurchaseOrders();

        if (date != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getProductCreatedDate().toString().equals(date))
                    .toList();
        }
        if (category != null) {
            orders = orders
                    .stream()
                    .filter(order -> order.getProduct().getProductCategory().equals(category))
                    .toList();
        }
        return orders;
    }
}
