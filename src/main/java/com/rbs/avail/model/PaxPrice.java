package com.rbs.avail.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="PRICE_PER_PAX")

public class PaxPrice implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PriceCompositID priceCompositID;
	
	@Column(name = "ADULT_PRICE")
	private float adultPrice;

	@Column(name = "CHILD_PRICE")
	private float childPrice;
	
	@Column(name = "INFANT_PRICE")
	private float infantPrice;

	

	public PriceCompositID getPriceCompositID() {
		return priceCompositID;
	}

	public void setPriceCompositID(PriceCompositID priceCompositID) {
		this.priceCompositID = priceCompositID;
	}

	public float getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(float adultPrice) {
		this.adultPrice = adultPrice;
	}

	public float getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(float childPrice) {
		this.childPrice = childPrice;
	}

	public float getInfantPrice() {
		return infantPrice;
	}

	public void setInfantPrice(float infantPrice) {
		this.infantPrice = infantPrice;
	}
	
	
		
}
