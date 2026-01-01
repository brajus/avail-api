package com.rbs.avail.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Supplier implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUPPLIER_CODE")
	private String supplierCode;
	
	@Column(name="SUPPLIER_NAME")
	private String supplierName;
	
	@Column(name="SUPPLIER_LOC")
	private String supplierLoc;

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierLoc() {
		return supplierLoc;
	}

	public void setSupplierLoc(String supplierLoc) {
		this.supplierLoc = supplierLoc;
	}
	

}
