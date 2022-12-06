package com.mrprk.mono.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrprk.mono.dto.Customer;
import com.mrprk.mono.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService service;
	
	@GetMapping
	public List<Customer> getAllCustomer(){
		return service.loadAllCustomer();
	}
	
	
	@GetMapping(value="/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getAllCustomerStream(){
		return service.loadAllCustomerStream();
	}

}
