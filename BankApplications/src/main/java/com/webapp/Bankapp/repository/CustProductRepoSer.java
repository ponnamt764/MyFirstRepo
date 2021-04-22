package com.webapp.Bankapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapp.Bankapp.model.CustomerProductService;

@Repository
//CustProductRepoSer = customer product repository service
public interface CustProductRepoSer extends CrudRepository<CustomerProductService, Integer>{

}
