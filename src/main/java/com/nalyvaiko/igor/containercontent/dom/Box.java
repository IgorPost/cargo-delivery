package com.nalyvaiko.igor.containercontent.dom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box {

	private String barcode;
	private String description;
	private List<Item> items = new ArrayList<>();
	
	public Box(String barcode, String description) {
		this.barcode = barcode;
		this.description = description;
	}

	public void add(Item item) {
		items.add(item);
	}

	public String getBarcode() {
		return barcode;
	}
	
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		return Objects.equals(barcode, other.barcode);
	}
	
}
