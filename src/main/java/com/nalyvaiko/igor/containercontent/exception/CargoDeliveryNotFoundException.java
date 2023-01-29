package com.nalyvaiko.igor.containercontent.exception;

public class CargoDeliveryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7483834355589851780L;

	public CargoDeliveryNotFoundException() {
		super();
	}

	public CargoDeliveryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CargoDeliveryNotFoundException(String message) {
		super(message);
	}

	public CargoDeliveryNotFoundException(Throwable cause) {
		super(cause);
	}

}
