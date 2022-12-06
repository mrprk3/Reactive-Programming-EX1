package com.mrprk.mono.dao;
import java.time.Duration;
// This act as publisher
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.mrprk.mono.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {
	
	//======================== Starting of Normal Flow of Program ==================================
	
	public static void sleepExecution(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Customer> getCustomer() {
		return IntStream.range(1, 10)
				.peek(CustomerDao::sleepExecution)
				.peek(i -> System.out.println("processing count" + i))
				.mapToObj(i -> new Customer(i, "customer" + i))
				.collect(Collectors.toList());
	}
	
	// In this above program until the process count is completed i will not get the result so here need to wait for complete the process count then we will get the result
	//======================== Ending of Normal Flow of Program ==================================

	
	//Lets implement the reactive programming 
	
	public Flux<Customer> getCustomerStream() {
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("processing count :"+i))
				.map(i->new Customer(i,"customer"+i));
	}
		
		
		public Flux<Customer> getCustomersList() {
			return Flux.range(1, 10)
					.doOnNext(i->System.out.println("processing count :"+i))
					.map(i->new Customer(i,"customer"+i));				
				
	}
	
}
