package com.bank.blogic;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bank.controller.ATMCardServer;
import com.bank.exceptions.InSufficientFundsException;
import com.bank.exceptions.InvalidAmountException;
import com.bank.exceptions.InvalidCustomerData;

public class HDFCBank implements ATMCardServer{
	private double balance = 50000;
	
	Map<String,Long> customer =new LinkedHashMap<>();
	public HDFCBank() {
		System.out.println("~ WEL-COME to HDFC ATM Services ~");
		customer.put("Manojkumar",9876_5432_1123_4560L);
		customer.put("Divya ",9876_5432_1123_4561L);
		customer.put("Anu",9876_5432_1123_4562L);
		customer.put("Madhu babu",9876_5432_1123_4563L);
		customer.put("madhan",9876_5432_1123_4564L);
		customer.put("Dharani",9876_5432_1123_4565L);
		customer.put("Ganesh",9876_5432_1123_4566L);
		customer.put("Laksmi",9876_5432_1123_4567L);                           
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