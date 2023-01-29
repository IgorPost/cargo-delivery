package com.nalyvaiko.igor.containercontent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nalyvaiko.igor.containercontent.converter.CargoDeliveryConverter;
import com.nalyvaiko.igor.containercontent.dom.CargoDelivery;
import com.nalyvaiko.igor.containercontent.dom.Container;
import com.nalyvaiko.igor.containercontent.dto.CargoDeliveryContentItemDto;
import com.nalyvaiko.igor.containercontent.dto.CargoDeliveryDto;
import com.nalyvaiko.igor.containercontent.exception.CargoDeliveryAlreadyExistsException;
import com.nalyvaiko.igor.containercontent.exception.CargoDeliveryNotFoundException;
import com.nalyvaiko.igor.containercontent.repository.CargoDeliveryRepository;

@Service
public class ContainerContentServiceImpl {
	
	private CargoDeliveryConverter cargoDeliveryConverter;
	private CargoDeliveryRepository сargoDeliveryRepository;

	@Autowired
	public ContainerContentServiceImpl(CargoDeliveryConverter cargoDeliveryConverter, CargoDeliveryRepository сargoDeliveryRepository) {
		this.cargoDeliveryConverter = cargoDeliveryConverter;
		this.сargoDeliveryRepository = сargoDeliveryRepository;
	}

	public CargoDelivery getByNumber(String number) {
		return сargoDeliveryRepository.findByNumber(number);
	}

	public void addCargoDelivery(CargoDeliveryDto cargoDeliveryDto) {
		
		CargoDelivery cargoDelivery = cargoDeliveryConverter.convert(cargoDeliveryDto);
		
		if (сargoDeliveryRepository.existsByNumber(cargoDelivery.getNumber())) {
			throw new CargoDeliveryAlreadyExistsException("CargoDeliveryAlreadyExists");
		}
		
		сargoDeliveryRepository.insert(cargoDelivery);
		
	}

	public void addCargoDeliveryContent(String number, List<CargoDeliveryContentItemDto> deliveryContent) {
		
		if (!сargoDeliveryRepository.existsByNumber(number)) {
			throw new CargoDeliveryNotFoundException("CargoDeliveryNotFound");
		}
		
		CargoDelivery cargoDelivery = сargoDeliveryRepository.findByNumber(number);
		
		List<Container> content = cargoDeliveryConverter.convert(deliveryContent);
		
		cargoDelivery.setContainers(content);
		
		сargoDeliveryRepository.save(cargoDelivery);
		
	
	}

}
