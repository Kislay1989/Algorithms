package com.udaan.expense.dao.repository;

import com.udaan.expense.dao.entities.TripExpenseDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripExpenseDetailsRepo extends CrudRepository<TripExpenseDetails, Integer>
{
	List<TripExpenseDetails> getTripExpenseDetailsList(int tripDetailsID);

	TripExpenseDetails getTripExpenseDetails(int tripDetailsID, int userID);
}
