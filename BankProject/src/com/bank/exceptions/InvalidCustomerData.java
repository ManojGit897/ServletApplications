package com.bank.exceptions;

public class InvalidCustomerData extends Exception {
	public InvalidCustomerData() {
		super();
	}
	public InvalidCustomerData(String msg) {
		super(msg);
	}
}