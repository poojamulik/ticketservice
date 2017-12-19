package com.pooja.ticketservice.model;

import java.util.ArrayList;
import java.util.List;

public class Row implements Comparable<Row>{
	
	private Integer rowID;
	
	private int stageColumnSize;
	
	private List<Seat> seats;
	
	public Row(int rowID, int stageColumnSize) {
		this.rowID = rowID;
		this.stageColumnSize = stageColumnSize;
		
		initializeRow();
	}
	
	private void initializeRow() {
		seats = new ArrayList<>();
		for (int i = 0; i < stageColumnSize; i++) {
			seats.add(new Seat(rowID, i));
		}
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Integer getRowID() {
		return rowID;
	}

	public void setRowID(int rowID) {
		this.rowID = rowID;
	}

	public int getStageColumnSize() {
		return stageColumnSize;
	}

	public void setStageColumnSize(int stageColumnSize) {
		this.stageColumnSize = stageColumnSize;
	}
	
	public Integer getNumSeatsAvailable() {
		int numSeatsAvailable = 0;
		for(Seat seat: seats) {
			if(seat.isAvailable()) numSeatsAvailable++;
		}
		return numSeatsAvailable;
	}
	
	public List<Seat> getAvailableSeat(int numberOfSeats) {
		List<Seat> availableSeats = new ArrayList<>();
		if(numberOfSeats > 0) {
			for(int i = 0; i < seats.size(); i++) {
				Seat seat = seats.get(i);
				if(seat.isAvailable()) {
					availableSeats.add(seat);
					numberOfSeats--;
				}
				if (numberOfSeats == 0) break;
			}	
		}
		return availableSeats;
	}
	
	public List<Seat> getRemainingSeats() {
		List<Seat> remainingSeats = new ArrayList<>();
		for(int i = 0; i < seats.size(); i++) {
			Seat seat = seats.get(i);
			if(seat.isAvailable()) {
				remainingSeats.add(seat);
			}
		}	
		return remainingSeats;
	}


	@Override
	public int compareTo(Row o) {
		return this.getNumSeatsAvailable().compareTo(o.getNumSeatsAvailable());
	}
	
	
}
