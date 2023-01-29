package com.nalyvaiko.igor.containercontent.dom;

import java.util.Objects;

public class Item {
	
	private String barcode;
	private String description;
	
	public Item(String barcode, String description) {
		this.barcode = barcode;
		this.description = description;
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
		Item other = (Item) obj;
		return Objects.equals(barcode, other.barcode);
	}
	
}
