package com.udaan.expense.controller;

import com.udaan.expense.dao.entities.TripExpenseDetails;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public interface UserLevelController
{
	@RequestMapping(path = "")
	Map<Integer, String> getUserDetails(@RequestBody List<String> userList);

	@RequestMapping(path = "")
	List<TripExpenseDetails> getTripBalanceInfo(@RequestBody Integer tripID);
}
