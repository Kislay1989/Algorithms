package com.udaan.expense.converter;

import com.udaan.expense.dao.entities.PaymentDetails;
import com.udaan.expense.dao.entities.TripDetails;
import com.udaan.expense.dao.entities.TripExpenseDetails;
import com.udaan.expense.dao.entities.UserDetails;
import com.udaan.expense.request.TripDetailsRequest;
import com.udaan.expense.response.TripDetailsResponse;

import java.util.List;
import java.util.Map;

public interface ServiceDaoConverter
{
	TripDetails convertTripDetails(TripDetailsRequest request);

	TripDetailsResponse convertTripDataToResponse(TripDetails details);

	Map<Integer, String> getUserDetailsMap (List<UserDetails> userDetailsList);

	TripExpenseDetails convertToTripExpenseDetails (Integer userID, TripDetails tripDetails);

	void updateTripExpenseDetails (TripExpenseDetails tripExpenseDetails, PaymentDetails paymentDetails);
}
