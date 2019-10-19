package com.udaan.expense.controller;

import com.udaan.expense.dao.entities.PaymentDetails;
import com.udaan.expense.request.PaymentRequest;
import com.udaan.expense.request.TripDetailsRequest;
import com.udaan.expense.response.TripDetailsResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public interface TripDetailsController
{
	@RequestMapping(path = "")
	TripDetailsResponse postTripDetails(@RequestBody TripDetailsRequest request);

	@RequestMapping(path = "")
	List<PaymentDetails> getTripPaymentDetails(@RequestBody Integer tripDetailsID);

	@RequestMapping(path = "")
	void updatePaymentDetailsForTrip(@RequestBody Integer PaymentRequestID);
}
