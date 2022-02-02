package com.udaan.expense.response;

import com.udaan.expense.dao.entities.TripExpenseDetails;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class TripDetailsResponse implements Serializable
{
	private int tripID;
	private int ownerID;
	private String tripName;
	private Date startDate;
	private Date endDate;
	private String location;
	private List<TripExpenseDetails> tripExpenseDetailsList;

	public int getTripID () {
		return tripID;
	}

	public void setTripID (int tripID) {
		this.tripID = tripID;
	}

	public int getOwnerID () {
		return ownerID;
	}

	public void setOwnerID (int ownerID) {
		this.ownerID = ownerID;
	}

	public String getTripName () {
		return tripName;
	}

	public void setTripName (String tripName) {
		this.tripName = tripName;
	}

	public Date getStartDate () {
		return startDate;
	}

	public void setStartDate (Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate () {
		return endDate;
	}

	public void setEndDate (Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation () {
		return location;
	}

	public void setLocation (String location) {
		this.location = location;
	}

	public List<TripExpenseDetails> getTripExpenseDetailsList () {
		return tripExpenseDetailsList;
	}

	public void setTripExpenseDetailsList (List<TripExpenseDetails> tripExpenseDetailsList) {
		this.tripExpenseDetailsList = tripExpenseDetailsList;
	}
}
