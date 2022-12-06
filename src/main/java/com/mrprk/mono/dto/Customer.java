package com.mrprk.mono.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
	private int id;
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private String name;

}
