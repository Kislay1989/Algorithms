package com.udaan.expense.controller.impl;

import com.udaan.expense.controller.UserLevelController;
import com.udaan.expense.dao.entities.TripExpenseDetails;
import com.udaan.expense.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserLevelControllerImpl implements UserLevelController
{
	private UserLevelService userLevelService;

	@Autowired
	public UserLevelControllerImpl(UserLevelService userLevelService) {
		this.userLevelService = userLevelService;
	}

	@Override
	public Map<Integer, String> getUserDetails (List<String> userList) {
		return userLevelService.getUserDetails(userList);
	}

	@Override
	public List<TripExpenseDetails> getTripBalanceInfo (Integer tripID) {
		return userLevelService.getTripBalanceInfo(tripID);
	}
}
