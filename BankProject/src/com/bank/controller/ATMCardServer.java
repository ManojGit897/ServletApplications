
package com.bank.controller;

import com.bank.exceptions.*;

public interface ATMCardServer {
	public boolean checkCustomerData(long cardNum);
	public void deposite(double amt)
						throws InvalidAmountException;
	public double withdraw(double amt)
						throws InvalidAmountException,InSufficientFundsException;
	public double balanceEnquiry();
}    