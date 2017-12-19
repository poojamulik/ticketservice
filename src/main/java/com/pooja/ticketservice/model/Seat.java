package com.pooja.ticketservice.model;

import java.util.Date;

public class Seat {
	
	private int rowID;
	
	private int colID;

	private Date reservedTime;
	
	private Date holdTime;
	
	private String email;
	
	private double waitTime;

	public Seat(int rowID, int colID, double waitTime) {
		this.rowID = rowID;
		this.colID = colID;
		this.waitTime = waitTime;
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
		} else if(holdTime != null && getDateDiff(holdTime, new Date()) <= this.waitTime) {
			isAvail = false;
		}
		return isAvail;
	}

	private Long getDateDiff(Date oldDate, Date newDate) {
		 return (newDate.getTime() - oldDate.getTime())/(1000);
	}
	
	public void hold() {
		this.holdTime = new Date();
	}
	
	public void reserve() {
		this.reservedTime = new Date();
	}
	
}
