package com.bank.blogic;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bank.controller.ATMCardServer;
import com.bank.exceptions.InSufficientFundsException;
import com.bank.exceptions.InvalidAmountException;
import com.bank.exceptions.InvalidCustomerData;

public class ICICIBank implements ATMCardServer{
	private double balance = 70000;
	Map<String,Long> customer =new LinkedHashMap<>();
	public ICICIBank() {
		System.out.println("~ WEL-COME to ICICI ATM Services ~");
		customer.put("Manu",7876_5432_1123_4561L);
		customer.put("Kumar",7876_5432_1123_4562L);
		customer.put("Manoj",7876_5432_1123_4563L);
		customer.put("dhanu",7876_5432_1123_4564L);
		customer.put("mahesh",7876_5432_1123_4565L);
		customer.put("mohan",7876_5432_1123_4566L);
		customer.put("Divya",7876_5432_1123_4567L);
	}
	public boolean checkCustomerData(long cardNum) {
		if (customer.containsValue(cardNum)) {
			return true;
		}
		return false;
	}
	@Override
	public void deposite(double amt) throws InvalidAmountException {
		if(amt<=0) {
			throw new InvalidAmountException(amt+" is invalid amount");
		}
		balance = balance+amt;
	}

	@Override
	public double withdraw(double amt) throws InvalidAmountException, InSufficientFundsException {
		if(amt<=0) {
			throw new InvalidAmountException(amt+" is invalid amount");
		}
		if (balance<amt) {
			throw new InSufficientFundsException("Insuficiant Funds");
		}
		balance = balance-amt;
		return amt;
	}

	@Override
	public double balanceEnquiry() { 
		return balance;
	}
}