package com.nalyvaiko.igor.containercontent.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nalyvaiko.igor.containercontent.dom.CargoDelivery;

public interface CargoDeliveryRepository extends MongoRepository<CargoDelivery, String> {

	boolean existsByNumber(String number);
	
	CargoDelivery findByNumber(String number);
	
}
