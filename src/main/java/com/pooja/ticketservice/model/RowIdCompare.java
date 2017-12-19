package com.pooja.ticketservice.model;

import java.util.Comparator;

public class RowIdCompare implements Comparator<Row>{

	@Override
	public int compare(Row r1, Row r2) {
		return r1.getRowID().compareTo(r2.getRowID());
	}

}
