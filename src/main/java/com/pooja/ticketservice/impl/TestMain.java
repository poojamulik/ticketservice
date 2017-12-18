package com.pooja.ticketservice.impl;

import com.pooja.ticketservice.service.TicketService;

public class TestMain {

	public static void main(String[] args) {

		TicketService impl = new TicketServiceImpl(5, 5);
		System.out.println(impl.numSeatsAvailable());
		
		impl.findAndHoldSeats(5, "b");
		
	}

}
