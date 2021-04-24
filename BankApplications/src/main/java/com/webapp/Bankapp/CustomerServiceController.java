package com.webapp.Bankapp;

import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.webapp.Bankapp.model.CustomerInformation;
import com.webapp.Bankapp.model.CustomerProductService;
import com.webapp.Bankapp.repository.CustCrudRepo;
import com.webapp.Bankapp.repository.CustProductRepoSer;


@RestController
public class CustomerServiceController {
	
	@Autowired
	CustCrudRepo crud;
	//CustCrudRepo = customer crud repository
	
	@Autowired
	CustProductRepoSer service;
	//CustProductRepoSer = customer product repository service
		
	
	@GetMapping(value = "/displayCustDT", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)	
	public Set<CustomerInformation> displayCustDT(@RequestParam int page_num) {
		
		//Optional<CustomerInformation> custDt = crud.findById(cust_id);
	Pageable paging = PageRequest.of(page_num, 5, Sort.by("cust_type"));
	
	
	
		 Page<CustomerInformation> pagedResult = crud.findAll(paging);
		return pagedResult.toSet();	
	}

	/*
	 * @GetMapping(value = "/getcustsort") public List<CustomerInformation>
	 * getcustsort(@RequestParam int cust_id) { List<CustomerInformation> custobj =
	 * crud. //finbyIdAndSort(Sort.by("cust_type"),cust_id); return custobj;
	 * 
	 * }
	 */	
	@GetMapping(value = "/displayCustDTByID", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)	
	public CustomerInformation displayCustDTByID(@RequestParam int cust_id) {
	Optional<CustomerInformation> custDt = crud.findById(cust_id);
	return custDt.get();
		
	}
	@GetMapping(value = "/deleteCustDT", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)	
	public String deleteCustDT(@RequestParam int cust_id) {
	crud.deleteById(cust_id);
	return "The speified cust details are deleted.";
		
	}
	@PostMapping(value = "/insertUpdate", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)	
	public String insertUpdate(@RequestBody CustomerInformation custInfo) {
	service.save(custInfo.getCustProSer());
	crud.save(custInfo);	
	return "The speified cust details are Updated.";
	
	}
	
	// controller applications for the customer product service table
	
	@GetMapping(value = "/displayCustSerDT", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)	
	public CustomerProductService displayCustServiceDT(@RequestParam int cust_id) {
	Optional<CustomerProductService> custDt1 = service.findById(cust_id);
	return custDt1.get();
	
	}
	@GetMapping(value = "/deleteCustSerDT", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)	
	public String deleteCustSerDT(@RequestParam int cust_id) {
	service.deleteById(cust_id);
	return "The speified cust details are deleted.";
	}
	
	@PostMapping(value = "/insertUpdateSer", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)	
	public String insertUpdateSer(@RequestBody CustomerProductService custProSer) {
	service.save(custProSer);
	return "The speified custService details are Updated.";
	
	}
}