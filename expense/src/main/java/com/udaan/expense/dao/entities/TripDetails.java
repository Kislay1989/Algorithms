package com.udaan.expense.dao.entities;

import javax.persistence.Entity;

@Entity
public class TripDetails
{
	private int tripDetailsID;

	public int getTripDetailsID () {
		return tripDetailsID;
	}

	public void setTripDetailsID (int tripDetailsID) {
		this.tripDetailsID = tripDetailsID;
	}
}
