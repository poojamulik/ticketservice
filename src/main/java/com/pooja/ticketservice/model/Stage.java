package com.pooja.ticketservice.model;

import java.util.ArrayList;
import java.util.List;

import com.pooja.ticketservice.service.SeatHold;


public class Stage {

	private int rowID;
	
	private int colID;
	
	private List<Row> rowList;
	
	public Stage(int rowID, int colID) {
		
		this.rowID = rowID;
		this.colID = colID;
		
		initializeRows();
	}

	private void initializeRows() {
		
		rowList = new ArrayList<>();
		for (int i = 0; i < rowID; i++) {
			rowList.add(new Row(i, colID));
		}
	}

	public int getNumSeatsAvailable() {
		return rowList.stream().map(r -> r.getNumSeatsAvailable()).reduce((a,b) -> a + b).get();
	}
	
	

	public void print() {
		for(int i = 0; i < rowList.size(); i++) {
			for(int j = 0; j < rowList.get(i).getSeats().size(); j++) {
				System.out.print((rowList.get(i).getSeats().get(j).isAvailable() == true ? 0 : 1) + "\t");
			}
			System.out.println("\n");
		}
	}

	public int findAndHoldSeats(int totalSeats, String customerEmail) {
		
		SeatHold seatHold;
		
		for (int i = rowID - 1; i >= 0; i--) {
			Row r = rowList.get(i);
			List<Seat> seats = r.getAvailableSeat(totalSeats);
			seatHold = new SeatHold(seats, customerEmail);
			return seatHold.getSeatHoldID();
		}
		return 0;
		
	}
	
	
	
}