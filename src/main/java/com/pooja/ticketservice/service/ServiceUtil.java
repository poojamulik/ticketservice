package com.pooja.ticketservice.service;

import java.util.ArrayList;
import java.util.List;

public class ServiceUtil {
	
	private static List<SeatHold> holdList = new ArrayList<>();
	private static List<SeatReserve> reserveList = new ArrayList<>();
	private static int holdId = 1;
	private static int reserveId = 1;
	
	
	public static int getHoldId() {
		 return holdId++;
	}
	
	public static void saveHold(SeatHold seatHold) {
		holdList.add(seatHold);
	}
	
	public static SeatHold getHold(int holdId, String email) throws Exception {
		int holdIndexToReturn = -1;
		for(int i = 0; i < holdList.size(); i++) {
			if(holdList.get(i).getSeatHoldID() == holdId) {
				holdIndexToReturn = i;
				break;
			}
		}
		if(holdIndexToReturn > -1 && holdList.get(holdIndexToReturn).getCustomerEmail().equals(email)) {
			return holdList.get(holdIndexToReturn);
		} else {
			throw new Exception("Invalid hold id or email");
		}
	}
	
	public static int getReserveId() {
		 return reserveId++;
	}
	
	public static void saveReserve(SeatReserve seatReserve) {
		int holdIndexToRemove = -1;
		for(int i = 0; i < holdList.size(); i++) {
			if(holdList.get(i).getSeatHoldID() == seatReserve.getHoldId()) {
				holdIndexToRemove = i;
				break;
			}
		}
		if(holdIndexToRemove > -1) {
			holdList.remove(holdIndexToRemove);
		}		
		reserveList.add(seatReserve);
	}
	

}
