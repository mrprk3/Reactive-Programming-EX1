package com.mrprk.mono;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//public class MonoFluxTest {
//
//	public static void main(String args[]) {
//
//		Mono<String> monoString1 = Mono.just("Atim").log(); // publisher
//		monoString1.subscribe(System.out::println); // subscribe
//
//		// lets make some error so that we can handle
////		Mono<Object> monoString = Mono.just("Atim").then(Mono.error(new RuntimeException("Exception occoured"))) .log(); // publisher
////		monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage())); // subscribe
//		
//		Flux<String> fluxString = Flux.just("Jhon","Rohit","Virat").concatWithValues("Rick") .log();
//		fluxString.subscribe(System.out::println);
//	}
//}