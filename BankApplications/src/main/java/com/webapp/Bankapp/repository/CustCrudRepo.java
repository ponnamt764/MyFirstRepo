package com.webapp.Bankapp.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.webapp.Bankapp.model.CustomerInformation;

@Repository 
public interface CustCrudRepo extends CrudRepository<CustomerInformation, Integer>, 
							PagingAndSortingRepository<CustomerInformation, Integer> {
	
}
