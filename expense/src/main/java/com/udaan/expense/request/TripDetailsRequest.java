package com.udaan.expense.request;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class TripDetailsRequest implements Serializable
{
	private int ownerID;
	private String name;
	private Date startDate;
	private Date endDate;
	private String location;
	private int expense;
	private List<String> userList;

	public int getOwnerID () {
		return ownerID;
	}

	public void setOwnerID (int ownerID) {
		this.ownerID = ownerID;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
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

	public int getExpense () {
		return expense;
	}

	public void setExpense (int expense) {
		this.expense = expense;
	}

	public List<String> getUserList () {
		return userList;
	}

	public void setUserList (List<String> userList) {
		this.userList = userList;
	}
}
