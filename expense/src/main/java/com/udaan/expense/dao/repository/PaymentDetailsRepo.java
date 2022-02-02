package com.udaan.expense.dao.repository;

import com.udaan.expense.dao.entities.PaymentDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDetailsRepo extends CrudRepository<PaymentDetails, Integer>
{
	List<PaymentDetails> getPaymentDetailsForTrip (Integer tripDetailsID);

	PaymentDetails getPaymentDetails(Integer paymentDetailsID);
}
