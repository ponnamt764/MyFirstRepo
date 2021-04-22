package com.webapp.Bankapp.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Embeddable
@Table(name="CustomerInfo")

public class CustomerInformation {
	@Id
	private int cust_id;
	private String cust_name;	
	private String cust_type;
	private String cust_status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id" , insertable = false, updatable = false )
	@Fetch(FetchMode.JOIN)
	
	private CustomerProductService custProSer;
	
	public CustomerProductService getCustProSer() {
		return custProSer;
	}
	public void setCustProSer(CustomerProductService custProSer) {
		this.custProSer = custProSer;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_type() {
		return cust_type;
	}
	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}
	public String getCust_status() {
		return cust_status;
	}
	
	public void setCust_status(String cust_status) {
		this.cust_status = cust_status;
	}
	
	@Override 
	public String toString() {
		return "CustomerInformation [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_type=" + cust_type
				+ ", cust_status=" + cust_status + "]";
	}
	
}
