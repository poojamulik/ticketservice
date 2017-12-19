package com.pooja.ticketservice.impl;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.pooja.ticketservice.service.SeatHold;
import com.pooja.ticketservice.service.TicketService;

public class TicketServiceTest extends TestCase {

	TicketService service;
	
    public TicketServiceTest() {
    	service = new TicketServiceImpl(5, 5);
    }
    
    public void testSuccessGetNumberOfAvailableSeatsBeforeBooking() {
    	assertEquals(25, service.numSeatsAvailable());
    }

    public void testSuccessBook5Tickets()
    {
    	SeatHold seatHold = service.findAndHoldSeats(5, "pmulik2288@gmail.com");
    	Assert.assertNotNull(seatHold.getSeatHoldID());
    	assertEquals(20, service.numSeatsAvailable());
    }
    
    public void testSuccessBook6Tickets() {
    	testSuccessBook5Tickets();
    	SeatHold seatHold = service.findAndHoldSeats(6, "pmulik2288@gmail.com");
    	Assert.assertNotNull(seatHold.getSeatHoldID());
    	assertEquals(14, service.numSeatsAvailable());
    }
    
    public void testSuccessBook5PrivateTickets() {
    	testSuccessBook6Tickets();
    	SeatHold seatHold = service.findAndHoldSeats(5, "pmulik2288@gmail.com");
    	Assert.assertNotNull(seatHold.getSeatHoldID());
    	assertEquals(9, service.numSeatsAvailable());
    }
    
    public void testSuccessBook4PrivateTickets() {
    	testSuccessBook5PrivateTickets();
    	SeatHold seatHold = service.findAndHoldSeats(4, "pmulik2288@gmail.com");
    	Assert.assertNotNull(seatHold.getSeatHoldID());
    	assertEquals(5, service.numSeatsAvailable());
    }
    
    public void testExceptionBook8PrivateTickets() {
    	testSuccessBook4PrivateTickets();
    	try {
    		service.findAndHoldSeats(8, "pmulik2288@gmail.com");
    	} catch (Exception e) {
    		assertEquals("Insufficient seats", e.getMessage());;
    	}
    }
    
    public void testSuccessGetNumberOfAvailableSeatsAfterBooking() {
    	testSuccessBook4PrivateTickets();
    	assertEquals(5, service.numSeatsAvailable());
    }
    
}
