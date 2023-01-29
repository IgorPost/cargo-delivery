package com.nalyvaiko.igor.containercontent.exception;

public class CargoDeliveryAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 2190935081191956505L;

	public CargoDeliveryAlreadyExistsException() {
		super();
	}

	public CargoDeliveryAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CargoDeliveryAlreadyExistsException(String message) {
		super(message);
	}

	public CargoDeliveryAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
}
