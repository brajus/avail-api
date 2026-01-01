package com.rbs.avail.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOM_TYPES")
public class RoomType implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="RESORT_CODE")
	private String resortCode;
	
	@Id
	@Column(name="ROOM_CODE")
	private String roomCode;
	
	@Column(name="ROOM_TYPE")
	private String roomType;
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
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	
	

}
