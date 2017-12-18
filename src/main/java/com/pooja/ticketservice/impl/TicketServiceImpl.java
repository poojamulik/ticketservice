package com.pooja.ticketservice.impl;

import com.pooja.ticketservice.model.Stage;
import com.pooja.ticketservice.service.SeatHold;
import com.pooja.ticketservice.service.TicketService;

public class TicketServiceImpl implements TicketService {
	
	private Stage stage;
	
	TicketServiceImpl(int stageRows, int stageColumns) {
		stage = new Stage(stageRows, stageColumns);
	}

	public int numSeatsAvailable() {
		return stage.getNumSeatsAvailable();
	}

	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		
		try {
			stage.findAndHoldSeats(5, "a");
			stage.print();
			stage.findAndHoldSeats(4, "a");
			stage.print();
			stage.findAndHoldSeats(3, "a");
			stage.print();
			stage.findAndHoldSeats(2, "a");
			stage.print();
			stage.findAndHoldSeats(1, "a");
			stage.print();
			

			stage.findAndHoldSeats(3, "a");
			stage.print();
			stage.findAndHoldSeats(4, "a");
			stage.print();
			stage.findAndHoldSeats(3, "a");
			stage.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return null;
	}

	public String reserveSeats(int seatHoldId, String customerEmail) {
		return null;
	}
	
}
