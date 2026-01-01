package com.rbs.avail.dto;

import java.util.Objects;

import lombok.Data;

@Data
public class ResortOfferResponseDTO implements Comparable<ResortOfferResponseDTO>{
	
	private String pkgCode;
	private String resortName;
	private float totalPrice;
	private String discount;
	private String roomType;
	
	private int lengthOfStay;
	
	public int getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(int lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getPkgCode() {
		return pkgCode;
	}

	public void setPkgCode(String pkgCode) {
		this.pkgCode = pkgCode;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getResortName() {
		return resortName;
	}

	public void setResortName(String resortName) {
		this.resortName = resortName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(discount);
	}

	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; ResortOfferResponseDTO other = (ResortOfferResponseDTO) obj; return
	 * Objects.equals(discount, other.discount); }
	 */

	//Overriden for sorting the results to descending order for discount.
	@Override
	public int compareTo(ResortOfferResponseDTO o) {
		// TODO Auto-generated method stub
		if(Integer.parseInt(this.getDiscount())>Integer.parseInt(o.getDiscount()))
			return -1;
		else
			return 0;
	}
}
