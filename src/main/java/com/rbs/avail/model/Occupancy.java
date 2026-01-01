package com.rbs.avail.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOM_OCCUPANCY")

public class Occupancy implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String resort_code;
	@Id
	private String room_code;
	private String occupancy;
	
	public String getResort_code() {
		return resort_code;
	}
	public void setResort_code(String resort_code) {
		this.resort_code = resort_code;
	}
	public String getRoom_code() {
		return room_code;
	}
	public void setRoom_code(String room_code) {
		this.room_code = room_code;
	}
	public String getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}	

}
