package com.pooja.ticketservice.impl;


import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import com.pooja.ticketservice.service.SeatHold;
import com.pooja.ticketservice.service.TicketService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketServiceTest {

	static TicketService service;
	
	@BeforeClass
	public static void runOnceBeforeClass() {
		 service = new TicketServiceImpl(5, 5);	
	}
    
    @Test
    public void test1SuccessGetNumberOfAvailableSeatsBeforeBooking() {
    	assertEquals(25, service.numSeatsAvailable());
    }

    @Test
    public void test2SuccessHold5Tickets() throws Exception
    {
    	SeatHold seatHold = service.findAndHoldSeats(5, "pmulik2288@gmail.com");
    	Assert.assertNotNull(seatHold.getSeatHoldID());
    	assertEquals(20, service.numSeatsAvailable());
    }
    
    @Test
    public void test3SuccessHold6Tickets() throws Exception {
    	SeatHold seatHold = service.findAndHoldSeats(6, "pmulik2288@gmail.com");
    	Assert.assertNotNull(seatHold.getSeatHoldID());
    	assertEquals(14, service.numSeatsAvailable());
    }
    
    @Test
    public void test4SuccessHold5PrivateTickets() throws Exception {
    	SeatHold seatHold = service.findAndHoldSeats(5, "pmulik2288@gmail.com");
    	Assert.assertNotNull(seatHold.getSeatHoldID());
    	assertEquals(9, service.numSeatsAvailable());
    }
    
    @Test
    public void test5SuccessHold4PrivateTickets() throws Exception {
    	SeatHold seatHold = service.findAndHoldSeats(4, "pmulik2288@gmail.com");
    	Assert.assertNotNull(seatHold.getSeatHoldID());
    	assertEquals(5, service.numSeatsAvailable());
    }
    
    @Test
    public void test6ExceptionHold8PrivateTickets() {
    	try {
    		service.findAndHoldSeats(8, "pmulik2288@gmail.com");
    	} catch (Exception e) {
    		assertEquals("Insufficient seats", e.getMessage());;
    	}
    }
    
    @Test
    public void test7SuccessGetNumberOfAvailableSeatsAfterBooking() {
    	assertEquals(5, service.numSeatsAvailable());
    }
    
    @Test
    public void test8SuccessReserve2Tickets() throws Exception {
    	//service.printStage();
    	SeatHold seatHold = service.findAndHoldSeats(2, "pmulik2288@gmail.com");
    	//service.printStage();
    	String message = service.reserveSeats(seatHold.getSeatHoldID(), "pmulik2288@gmail.com");
    	assertEquals(3, service.numSeatsAvailable());
    	System.out.println(message);
    }
   
    @Test
    public void test9SuccessGetNumberOfAvailableSeatsAfterBooking1() throws InterruptedException {
    	Thread.sleep(6000);
    	assertEquals(23, service.numSeatsAvailable());
    }
    
    @Test
    public void testEmptyStage() throws InterruptedException {
    	try {
	    	service = new TicketServiceImpl(0, 0);	
	    	service.findAndHoldSeats(4, "pmulik2288@gmail.com");
    	} catch(Exception e) {
    		assert(true);
    	}
    }
    
}
