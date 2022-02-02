package com.udaan.expense.service.impl;

import com.udaan.expense.converter.ServiceDaoConverter;
import com.udaan.expense.dao.entities.TripExpenseDetails;
import com.udaan.expense.dao.entities.UserDetails;
import com.udaan.expense.dao.repository.TripExpenseDetailsRepo;
import com.udaan.expense.dao.repository.UserDetailsRepo;
import com.udaan.expense.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserLevelServiceImpl implements UserLevelService
{
	private UserDetailsRepo userDetailsRepo;
	private ServiceDaoConverter converter;
	private TripExpenseDetailsRepo tripExpenseDetailsRepo;

	@Autowired
	public UserLevelServiceImpl(UserDetailsRepo userDetailsRepo, ServiceDaoConverter converter, TripExpenseDetailsRepo tripExpenseDetailsRepo) {
		this.userDetailsRepo = userDetailsRepo;
		this.converter = converter;
		this.tripExpenseDetailsRepo = tripExpenseDetailsRepo;
	}

	@Override
	public Map<Integer, String> getUserDetails (List<String> userList) {
		List<UserDetails> userDetailsList = userDetailsRepo.getUserDetails(userList);
		return converter.getUserDetailsMap(userDetailsList);
	}

	@Override
	public List<TripExpenseDetails> getTripBalanceInfo (Integer tripID) {
		return tripExpenseDetailsRepo.getTripExpenseDetailsList(tripID);
	}
}
