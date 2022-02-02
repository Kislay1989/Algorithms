package com.udaan.expense.service;

import com.udaan.expense.dao.entities.TripExpenseDetails;

import java.util.List;
import java.util.Map;

public interface UserLevelService
{
	Map<Integer, String> getUserDetails (List<String> userList);

	List<TripExpenseDetails> getTripBalanceInfo (Integer tripID);
}
