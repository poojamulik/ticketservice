package com.pooja.ticketservice.service;

import java.util.ArrayList;
import java.util.List;

import com.pooja.ticketservice.model.Seat;

public class SeatReserve {
	
	private int seatReserveId;
	
	private int seatHoldID;
	
	private String customerEmail;
	
	private List<Seat> seatsReserved = new ArrayList<>();
	
	public int getHoldId() {
		return 0;
	}

	public SeatReserve(SeatHold seatHold) {
		seatHold.getSeatsOnHold().forEach((s) -> s.reserve());
		this.seatsReserved = seatHold.getSeatsOnHold();
		this.seatReserveId = ServiceUtil.getReserveId();
		this.seatHoldID = seatHold.getSeatHoldID();
		this.customerEmail = seatHold.getCustomerEmail();
		ServiceUtil.saveReserve(this);
	}

	public int getSeatHoldID() {
		return seatHoldID;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public int getSeatReserveId() {
		return seatReserveId;
	}

	public List<Seat> getSeatsReserved() {
		return seatsReserved;
	}

}
