package com.rbs.avail.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PACKAGE")
public class Offer implements Serializable {
	
	/*
	 
	 
PKG_CODE        NOT NULL VARCHAR2(20) 
PKG_NAME        NOT NULL VARCHAR2(30) 
CREATE_DATE     NOT NULL DATE         
MODIFY_DATE     NOT NULL DATE         
SALE_START_DATE NOT NULL DATE         
SALE_END_DATE   NOT NULL DATE         
USER_MODIFIED   NOT NULL VARCHAR2(30) 
DISCOUNT        NOT NULL NUMBER(2)

	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PKG_CODE")
	private String pkgCode;
	
	@Column(name = "PKG_NAME")
	private String pkgNAME;
	
	@Column(name = "SALE_START_DATE")
	private Date saleStartDate;
	
	@Column(name = "SALE_END_DATE")
	private Date saleEndDate;
	
	@Column(name = "DISCOUNT")
	private String discount;

	public String getPkgCode() {
		return pkgCode;
	}

	public void setPkgCode(String pkgCode) {
		this.pkgCode = pkgCode;
	}

	public String getPkgNAME() {
		return pkgNAME;
	}

	public void setPkgNAME(String pkgNAME) {
		this.pkgNAME = pkgNAME;
	}

	public Date getSaleStartDate() {
		return saleStartDate;
	}

	public void setSaleStartDate(Date saleStartDate) {
		this.saleStartDate = saleStartDate;
	}

	public Date getSaleEndDate() {
		return saleEndDate;
	}

	public void setSaleEndDate(Date saleEndDate) {
		this.saleEndDate = saleEndDate;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	
	
		
}
