package com.udaan.expense.controller.impl;

import com.udaan.expense.controller.TripDetailsController;
import com.udaan.expense.dao.entities.PaymentDetails;
import com.udaan.expense.request.PaymentRequest;
import com.udaan.expense.request.TripDetailsRequest;
import com.udaan.expense.response.TripDetailsResponse;
import com.udaan.expense.service.TripDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TripDetailsControllerImpl implements TripDetailsController
{
	private TripDetailsService tripDetailsService;

	@Autowired
	public TripDetailsControllerImpl(TripDetailsService tripDetailsService) {
		this.tripDetailsService = tripDetailsService;
	}

	@Override
	public TripDetailsResponse postTripDetails (TripDetailsRequest request) {
		return tripDetailsService.postTripDetails(request);
	}

	@Override
	public List<PaymentDetails> getTripPaymentDetails (Integer tripDetailsID) {
		return tripDetailsService.getTripPaymentDetails(tripDetailsID);
	}

	@Override
	public void updatePaymentDetailsForTrip (Integer paymentRequestID) {
		tripDetailsService.updatePaymentDetailsForTrip(paymentRequestID);
	}
}
