package com.udaan.expense.service.impl;

import com.udaan.expense.converter.ServiceDaoConverter;
import com.udaan.expense.dao.entities.PaymentDetails;
import com.udaan.expense.dao.entities.TripDetails;
import com.udaan.expense.dao.entities.TripExpenseDetails;
import com.udaan.expense.dao.repository.PaymentDetailsRepo;
import com.udaan.expense.dao.repository.TripDetailsRepo;
import com.udaan.expense.dao.repository.TripExpenseDetailsRepo;
import com.udaan.expense.request.PaymentRequest;
import com.udaan.expense.request.TripDetailsRequest;
import com.udaan.expense.response.TripDetailsResponse;
import com.udaan.expense.service.TripDetailsService;
import com.udaan.expense.service.UserLevelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TripDetailsServiceImpl implements TripDetailsService
{
	private TripDetailsRepo tripDetailsRepo;
	private TripExpenseDetailsRepo tripExpenseDetailsRepo;
	private ServiceDaoConverter converter;
	private UserLevelService userLevelService;
	private PaymentDetailsRepo paymentDetailsRepo;

	public TripDetailsServiceImpl (TripDetailsRepo tripDetailsRepo, ServiceDaoConverter converter, UserLevelService userLevelService,
			TripExpenseDetailsRepo tripExpenseDetailsRepo, PaymentDetailsRepo paymentDetailsRepo) {
		this.tripDetailsRepo = tripDetailsRepo;
		this.converter = converter;
		this.userLevelService = userLevelService;
		this.tripExpenseDetailsRepo = tripExpenseDetailsRepo;
		this.paymentDetailsRepo = paymentDetailsRepo;
	}

	@Override
	public TripDetailsResponse postTripDetails (TripDetailsRequest tripRequestDetails) {
		Map<Integer, String> userMap = userLevelService.getUserDetails(tripRequestDetails.getUserList());
		TripDetails tripDetails = converter.convertTripDetails(tripRequestDetails);
		tripDetailsRepo.save(tripDetails);

		for (Integer userID : userMap.keySet()) {
			TripExpenseDetails tripExpenseDetails = converter.convertToTripExpenseDetails(userID, tripDetails);
			tripExpenseDetailsRepo.save(tripExpenseDetails);
		}

		return converter.convertTripDataToResponse(tripDetails);
	}

	@Override
	public List<PaymentDetails> getTripPaymentDetails (Integer tripDetailsID) {
		return paymentDetailsRepo.getPaymentDetailsForTrip(tripDetailsID);
	}

	@Override
	public void updatePaymentDetailsForTrip (Integer paymentRequestID) {
		PaymentDetails paymentDetails = paymentDetailsRepo.getPaymentDetails(paymentRequestID);
		int tripDetailsID = paymentDetails.getTripDetailsID();
		int userID = paymentDetails.getUserID();
		TripExpenseDetails tripExpenseDetails = tripExpenseDetailsRepo.getTripExpenseDetails(tripDetailsID, userID);
		converter.updateTripExpenseDetails(tripExpenseDetails, paymentDetails);
		tripExpenseDetailsRepo.save(tripExpenseDetails);
	}
}
