package com.bank.exceptions;

public class InSufficientFundsException extends Exception {
	public InSufficientFundsException() {
		super();
	}
	public InSufficientFundsException(String msg) {
		super(msg);
	}
}
