package com.udaan.expense.dao.repository;

import com.udaan.expense.dao.entities.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepo extends CrudRepository<UserDetails, Integer>
{
	List<UserDetails> getUserDetails(List<String> userNameList);
}
