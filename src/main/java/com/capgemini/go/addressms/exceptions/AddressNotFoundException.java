package com.capgemini.go.addressms.exceptions;

@SuppressWarnings("serial")
public class AddressNotFoundException extends RuntimeException {

	public AddressNotFoundException() {}
	
	
	public AddressNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
	}

	public AddressNotFoundException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}


}
