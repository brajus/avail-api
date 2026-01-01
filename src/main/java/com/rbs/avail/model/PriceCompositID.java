package com.rbs.avail.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PriceCompositID implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String resortCode;
	private String roomCode;
	
	
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
	
	public PriceCompositID() {
		super();
	}
	

	public PriceCompositID(String resortCode, String roomCode, String paxType) {
		super();
		this.resortCode = resortCode;
		this.roomCode = roomCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(resortCode, roomCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceCompositID other = (PriceCompositID) obj;
		return  Objects.equals(resortCode, other.resortCode)
				&& Objects.equals(roomCode, other.roomCode);
	}

	@Override
	public String toString() {
		return "PriceCompositID{" +
				"resortCode='" + resortCode + '\'' +
				", roomCode='" + roomCode + '\'' +
				'}';
	}
}
