package com.udaan.expense.dao.entities;

import javax.persistence.Entity;

@Entity
public class TripExpenseDetails
{
	private int tripExpenseDetailsID;

	private int tripDetailsID;
	private int userID;
	private int tripExpense;
	private int expensePaid;
	private int expenseLeft;

	public int getTripExpenseDetailsID () {
		return tripExpenseDetailsID;
	}

	public void setTripExpenseDetailsID (int tripExpenseDetailsID) {
		this.tripExpenseDetailsID = tripExpenseDetailsID;
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

	public int getTripExpense () {
		return tripExpense;
	}

	public void setTripExpense (int tripExpense) {
		this.tripExpense = tripExpense;
	}

	public int getExpensePaid () {
		return expensePaid;
	}

	public void setExpensePaid (int expensePaid) {
		this.expensePaid = expensePaid;
	}

	public int getExpenseLeft () {
		return expenseLeft;
	}

	public void setExpenseLeft (int expenseLeft) {
		this.expenseLeft = expenseLeft;
	}
}
