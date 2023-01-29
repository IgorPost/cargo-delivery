package com.nalyvaiko.igor.containercontent.dom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CargoDelivery {
	
	@Id
    private String id;
	
	private String number;
	private Partner partner;
	private List<Container> containers = new ArrayList<>();
	
	public CargoDelivery(String number, Partner partner) {
		this.number = number;
		this.partner = partner;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CargoDelivery other = (CargoDelivery) obj;
		return Objects.equals(number, other.number);
	}
	
}
