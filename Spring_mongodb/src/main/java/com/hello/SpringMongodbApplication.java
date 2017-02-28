package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongodbApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository cs;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		cs.deleteAll();
		
		cs.save(new Customer("Manoj","chevvuri"));
		cs.save(new Customer("mike","chevvuri"));
		
		System.out.println("Printing all customers:");
		
		for(Customer cust:cs.findAll()){
			System.out.println(cust.toString());
		}
		
	}
}
