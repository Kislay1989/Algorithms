package com.udaan.expense.dao.entities;

import javax.persistence.Entity;

@Entity
public class PaymentDetails
{
	private int paymentDetailsID;

	private int tripDetailsID;
	private int userID;
	private int amountPaid;

	public int getPaymentDetailsID () {
		return paymentDetailsID;
	}

	public void setPaymentDetailsID (int paymentDetailsID) {
		this.paymentDetailsID = paymentDetailsID;
	}

	public int getTripDetailsID () {
		return tripDetailsID;
	}

	public void setTripDetailsID (int tripDetailsID) {
		this.tripDetailsID = tripDetailsID;
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
