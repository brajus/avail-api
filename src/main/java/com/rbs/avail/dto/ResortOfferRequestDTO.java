package com.rbs.avail.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public class ResortOfferRequestDTO {
	
	private String pkgCode;
	
	private String resortCode;
	
	private String roomCode;
	
	@NotBlank(message ="Arrival Date is required")
	private Date arrivalDate;
	
	@NotBlank(message ="Departure Date is required")
	private Date departureDate;
	
	@NotBlank(message ="Pax Audult count is required")
	private int adultCount;
	
	@NotBlank(message ="Pax child count is required")
	private int childCount;
	
	@NotBlank(message ="Pax infant count is required")
	private int infantCount;
	
	private int lengthOfStay;
	
	public int getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(int lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}
	
	public String getPkgCode() {
		return pkgCode;
	}
	public void setPkgCode(String pkgCode) {
		this.pkgCode = pkgCode;
	}
	public String getResortCode() {
		return resortCode;
	}
	public void setResortCode(String resortCode) {
		this.resortCode = resortCode;
	}
	public String getRoomCode() {
		return roomCode;
	}
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public int getAdultCount() {
		return adultCount;
	}
	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}
	public int getChildCount() {
		return childCount;
	}
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
	public int getInfantCount() {
		return infantCount;
	}
	public void setInfantCount(int infantCount) {
		this.infantCount = infantCount;
	}
}
