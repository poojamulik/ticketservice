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
		rowList.sort(new RowIdCompare());
		for(int i = 0; i < rowList.size(); i++) {
			for(int j = 0; j < rowList.get(i).getSeats().size(); j++) {
				System.out.print((rowList.get(i).getSeats().get(j).isAvailable() == true ? 0 : 1) + "\t");
			}
			System.out.println("\n");
		}
	}

	public SeatHold findAndHoldSeats(int totalSeats, String email) throws Exception {
	    SeatHold sh = getPrivateSeats(totalSeats, email);
	    if(sh == null) {
	    	sh = getAvailableSeats(totalSeats, email);
	    	if(sh == null) {
	    		throw new Exception("Insufficient seats");
	    	}
	    }
	    return sh;		
	}
	
	private SeatHold getPrivateSeats(int totalSeats, String email) {
		List<Seat> seats = new ArrayList<>();
		for (int i = rowID - 1; i >= 0; i--) {
			Row r = rowList.get(i);
			List<Seat> temp = r.getAvailableSeat(totalSeats);
			if(temp.size() >= totalSeats) {
				seats = temp;
				break;
			} 
		}
		return buildSeatHold(seats, email);
	}
	
	private SeatHold getAvailableSeats(int totalSeats, String email) {
		rowList.sort(new RowSeatSizeCompare());	
		List<Seat> seats = new ArrayList<>();
		for(Row row : rowList) {
			List<Seat> s = row.getRemainingSeats(totalSeats);
			seats.addAll(s);
			totalSeats = totalSeats - s.size();
			if(totalSeats == 0) {
				rowList.sort(new RowIdCompare());
				break;
			}
		}
		if(totalSeats > 0) {
			seats = new ArrayList<>();
		} 
		return buildSeatHold(seats, email);
	}
	
	private SeatHold buildSeatHold(List<Seat>seats, String email) {
		if(seats.size() > 0) {
			return new SeatHold(seats, email);
		} else {
			return null;
		}
	}
	
	
	
}