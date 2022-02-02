package com.udaan.expense.request;

import java.io.Serializable;

public class PaymentRequest implements Serializable
{
	private int tripDetails;
	private int userID;
	private int amountPaid;

	public int getTripDetails () {
		return tripDetails;
	}

	public void setTripDetails (int tripDetails) {
		this.tripDetails = tripDetails;
	}

	public int getUserID () {
		return userID;
	}

	public void setUserID (int userID) {
		this.userID = userID;
	}

	public int getAmountPaid () {
		return amountPaid;
	}

	public void setAmountPaid (int amountPaid) {
		this.amountPaid = amountPaid;
	}
}
