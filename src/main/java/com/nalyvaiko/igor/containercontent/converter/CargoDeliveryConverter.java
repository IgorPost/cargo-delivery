package com.nalyvaiko.igor.containercontent.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nalyvaiko.igor.containercontent.dom.Box;
import com.nalyvaiko.igor.containercontent.dom.CargoDelivery;
import com.nalyvaiko.igor.containercontent.dom.Container;
import com.nalyvaiko.igor.containercontent.dom.Item;
import com.nalyvaiko.igor.containercontent.dom.Pallet;
import com.nalyvaiko.igor.containercontent.dom.Partner;
import com.nalyvaiko.igor.containercontent.dto.CargoDeliveryContentItemDto;
import com.nalyvaiko.igor.containercontent.dto.CargoDeliveryDto;

@Component
public class CargoDeliveryConverter {
	
	public CargoDelivery convert(CargoDeliveryDto dto) {
		Partner partner = new Partner(dto.partnerCode, dto.partnerDescription);
		return new CargoDelivery(dto.number, partner);
	}
	
	public List<Container> convert(List<CargoDeliveryContentItemDto> dto) {
		List<Container> containers = new ArrayList<>();
		for (CargoDeliveryContentItemDto dtoItem : dto) {
			Item item = new Item(dtoItem.itemBarcode, dtoItem.itemDescription);
			Box box = getBox(dtoItem, containers);
			box.add(item);
		}
		return containers;
	}

	private Box getBox(CargoDeliveryContentItemDto dtoItem, List<Container> containers) {
		
		Pallet pallet = getPallet(dtoItem, containers);
		
		Box box = pallet.getBoxes().stream()
				.filter(b -> b.getBarcode().equals(dtoItem.boxBarcode))
				.findAny()
				.orElse(null);
		
		if (box == null) {
			box = new Box(dtoItem.boxBarcode, dtoItem.boxDescription);
			pallet.add(box);
		}
		
		return box;
	}

	private Pallet getPallet(CargoDeliveryContentItemDto dtoItem, List<Container> containers) {
		
		Container container = getContainer(dtoItem, containers);
		
		Pallet pallet = container.getPallets().stream()
				.filter(p -> p.getBarcode().equals(dtoItem.palletBarcode))
				.findAny()
				.orElse(null);
		
		if (pallet == null) {
			pallet = new Pallet(dtoItem.palletBarcode, dtoItem.palletDescription);
			container.add(pallet);
		}
		
		return pallet;
	}

	private Container getContainer(CargoDeliveryContentItemDto dtoItem, List<Container> containers) {

		Container container = containers.stream()
				.filter(c -> c.getBarcode().equals(dtoItem.containerBarcode))
				.findAny()
				.orElse(null);
		
		if (container == null) {
			container = new Container(dtoItem.containerBarcode, dtoItem.containerDescription);
			containers.add(container);
		}
		
		return container;
	}

}
