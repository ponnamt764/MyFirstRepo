package com.webapp.Bankapp.model;

import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Embeddable
@Table(name="CustProService")

public class CustomerProductService {
	
	@Id
	private int cust_id;
	private String pro_name;
	private int Prod_amt;
	private String Prod_startDate;
	private String Prod_endDate;
	
	
	@OneToMany(targetEntity = CustomerInformation.class, mappedBy = "cust_id", orphanRemoval = false, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<CustomerInformation> custInfo;
	
	public Set<CustomerInformation> getCustInfo() {
		return custInfo;
	}
	public void setCustInfo(Set<CustomerInformation> custInfo) {
		this.custInfo = custInfo;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getProd_amt() {
		return Prod_amt;
	}
	public void setProd_amt(int prod_amt) {
		Prod_amt = prod_amt;
	}
	public String getProd_startDate() {
		return Prod_startDate;
	}
	public void setProd_startDate(String prod_startDate) {
		Prod_startDate = prod_startDate;
	}
	public String getProd_endDate() {
		return Prod_endDate;
	}
	public void setProd_endDate(String prod_endDate) {
		Prod_endDate = prod_endDate;
	}
	
	@Override
	public String toString() {
		return "CustomerProductService [cust_id=" + cust_id + ", pro_name=" + pro_name + ", Prod_amt=" + Prod_amt
				+ ", Prod_startDate=" + Prod_startDate + ", Prod_endDate=" + Prod_endDate + "]";
	
	}
}