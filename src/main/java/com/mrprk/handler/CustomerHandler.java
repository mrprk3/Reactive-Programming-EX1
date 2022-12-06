package com.mrprk.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mrprk.mono.dao.CustomerDao;
import com.mrprk.mono.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {
	@Autowired
	private CustomerDao dao;
	
	public Mono<ServerResponse> loadCustomers(ServerResponse request){
		Flux<Customer> customerList = dao.getCustomersList();
		return ServerResponse.ok().body(customerList, Customer.class);
	}

}
