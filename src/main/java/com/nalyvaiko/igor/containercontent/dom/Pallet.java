package com.nalyvaiko.igor.containercontent.dom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pallet {

	private String barcode;
	private String description;
	private List<Box> boxes = new ArrayList<>();
	
	public Pallet(String barcode, String description) {
		this.barcode = barcode;
		this.description = description;
	}

	public void add(Box box) {
		boxes.add(box);
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
	
	public List<Box> getBoxes() {
		return boxes;
	}
	
	public void setBoxes(List<Box> boxes) {
		this.boxes = boxes;
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
		Pallet other = (Pallet) obj;
		return Objects.equals(barcode, other.barcode);
	}
	
}
