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
			return stage.findAndHoldSeats(numSeats, customerEmail);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String reserveSeats(int seatHoldId, String customerEmail) {
		return null;
	}

	public void printStage() {
		stage.print();
	}

}
