package com.pooja.ticketservice.model;

import java.util.Comparator;

public class RowSeatSizeCompare implements Comparator<Row>{

	@Override
	public int compare(Row r2, Row r1) {
		Integer a = r2.getNumSeatsAvailable().compareTo(r1.getNumSeatsAvailable());
		Integer b = r2.getRowID().compareTo(r1.getRowID());
		return a.compareTo(b);
	}

}
