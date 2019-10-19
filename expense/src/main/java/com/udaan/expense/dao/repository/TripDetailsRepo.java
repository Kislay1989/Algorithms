package com.udaan.expense.dao.repository;

import com.udaan.expense.dao.entities.TripDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDetailsRepo extends CrudRepository<TripDetails, Integer>
{

}
