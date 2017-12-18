package com.pooja.ticketservice.service;

import java.util.ArrayList;
import java.util.List;

import com.pooja.ticketservice.model.Seat;

public class SeatHold {
	
	private int seatHoldID;
	
	private String customerEmail;
	
	private List<Seat> seatsOnHold = new ArrayList<>();

	public SeatHold(List<Seat> seats, String email) {
		seats.forEach((s) -> {s.hold(); s.setEmail(email);});
		this.seatHoldID = ServiceUtil.getHoldId();
		this.customerEmail = email;
		this.seatsOnHold = seats;
		ServiceUtil.saveHold(this);
	}

	public int getSeatHoldID() {
		return seatHoldID;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public List<Seat> getSeatsOnHold() {
		return seatsOnHold;
	}
	
}
