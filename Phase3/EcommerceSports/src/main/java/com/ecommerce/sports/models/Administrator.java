package com.ecommerce.sports.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Administrator {

	@Id
	@Column(name="adminId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String AdminId;
	
	private String Pass;
	
	public String getAdminId() {
		return AdminId;
	}
	
	public void setAdminId(String adminId) {
		this.AdminId = adminId;
	}
	
	public String getPass() {
		return Pass;
	}
	
	public void setPass(String password) {
		this.Pass = password;
	}
	
	
}
