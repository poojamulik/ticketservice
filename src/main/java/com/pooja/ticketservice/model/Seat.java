package com.pooja.ticketservice.model;

import java.util.Date;

public class Seat {
	
	private int rowID;
	
	private int colID;

	private Date reservedTime;
	
	private Date holdTime;
	
	private String email;

	public Seat(int rowID, int colID) {
		this.rowID = rowID;
		this.colID = colID;
	}

	public int getRowID() {
		return rowID;
	}

	public int getColID() {
		return colID;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAvailable() {
		boolean isAvail = true;
		if(reservedTime != null) {
			isAvail = false;
		} else if(holdTime != null && getDateDiff(holdTime, new Date()) <= 5) {
			isAvail = false;
		}
		return isAvail;
	}

	private Long getDateDiff(Date oldDate, Date newDate) {
		 return (newDate.getTime() - oldDate.getTime())/(1000*60);
	}
	
	public void hold() {
		this.holdTime = new Date();
	}
	
	public void reserve() {
		this.reservedTime = new Date();
	}
	
}
