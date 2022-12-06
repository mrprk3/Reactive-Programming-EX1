package com.mrprk.mono.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrprk.mono.dao.CustomerDao;
import com.mrprk.mono.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
	@Autowired
	CustomerDao dao;
	//======================== Starting of Normal Flow of Program ==================================
	public List<Customer> loadAllCustomer(){
		long start = System.currentTimeMillis();
		List<Customer> customer = dao.getCustomer();
		long end = System.currentTimeMillis();
		System.out.println("total execution time "+(end-start));
		return customer;
	}
	//======================== Ending of Normal Flow of Program ==================================

	
	//======================== Starting of Reactive Flow of Program ==================================

	public Flux<Customer> loadAllCustomerStream(){
		long start = System.currentTimeMillis();
		Flux<Customer> customer = dao.getCustomerStream();
		long end = System.currentTimeMillis();
		System.out.println("total execution time "+(end-start));
		return customer;
	}
	//======================== Ending of Reactive Flow of Program ==================================


}
