package com.nalyvaiko.igor.containercontent.dom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Container {
	
	private String barcode;
	private String description;
	private List<Pallet> pallets = new ArrayList<>();
	
	public Container(String barcode, String description) {
		this.barcode = barcode;
		this.description = description;
	}

	public void add(Pallet pallet) {
		pallets.add(pallet);
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
	
	public List<Pallet> getPallets() {
		return pallets;
	}
	
	public void setPallets(List<Pallet> pallets) {
		this.pallets = pallets;
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
		Container other = (Container) obj;
		return Objects.equals(barcode, other.barcode);
	}
	
}
