package com.udaan.expense.service;

import com.udaan.expense.dao.entities.PaymentDetails;
import com.udaan.expense.request.PaymentRequest;
import com.udaan.expense.request.TripDetailsRequest;
import com.udaan.expense.response.TripDetailsResponse;

import java.util.List;

public interface TripDetailsService
{
	TripDetailsResponse postTripDetails(TripDetailsRequest tripDetails);

	List<PaymentDetails> getTripPaymentDetails (Integer tripDetailsID);

	void updatePaymentDetailsForTrip (Integer paymentRequestID);
}
