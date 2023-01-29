package com.nalyvaiko.igor.containercontent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nalyvaiko.igor.containercontent.dom.CargoDelivery;
import com.nalyvaiko.igor.containercontent.dto.CargoDeliveryContentItemDto;
import com.nalyvaiko.igor.containercontent.dto.CargoDeliveryDto;
import com.nalyvaiko.igor.containercontent.service.ContainerContentServiceImpl;

@RestController
@RequestMapping("/api")
public class ContainerContentController {
	
	@Autowired
	ContainerContentServiceImpl containerContentService;
	
	@GetMapping(value = "/{deliveryNumber}")
	public ResponseEntity<CargoDelivery> getByNumber(@PathVariable String deliveryNumber) {
		CargoDelivery cargoDelivery = containerContentService.getByNumber(deliveryNumber);
		return new ResponseEntity<>(cargoDelivery, HttpStatus.OK);
	}
	
	@PostMapping(value = "/delivery", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addCargoDelivery(@RequestBody CargoDeliveryDto cargoDeliveryDto) {
		containerContentService.addCargoDelivery(cargoDeliveryDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/delivery/{number}/content", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addCargoDeliveryContent(@RequestBody List<CargoDeliveryContentItemDto> deliveryContent, @PathVariable String number) {
		containerContentService.addCargoDeliveryContent(number, deliveryContent);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
