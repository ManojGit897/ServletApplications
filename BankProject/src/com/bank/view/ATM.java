package com.bank.view;

import java.util.InputMismatchException;

import java.util.Scanner;
import com.bank.controller.ATMCardServer;
import com.bank.exceptions.InSufficientFundsException;
import com.bank.exceptions.InvalidAmountException;
import com.bank.exceptions.InvalidCustomerData;
import com.bank.blogic.SBIBank;



public class ATM {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
			
		outerloop:while (true) {
			System.out.println("Enter Your Bank-Name which Bank Card you have?");
			try {	
				Class cls = Class.forName(scn.nextLine());
				Object obj = cls.newInstance();
			innerloop1:while(true){
					System.out.println("Enter Your ATM Card number");
					long cardNum = scn.nextLong();scn.nextLine();
					ATMCardServer card = (ATMCardServer)obj;
					if(card.checkCustomerData(cardNum)) { 
						System.out.println("Card matched with our Bank Server ");
						System.out.println("Start your transactions");
					innerloop2:while(true) {
						System.out.println("Choose a option");
						System.out.println("1.Deposite");
						System.out.println("2.Withdraw");
						System.out.println("3.Balance Enquiry");
						System.out.println("4.Exit");
						
						System.out.println("Enter option number which operation you want to continue");
						int option = scn.nextInt();scn.nextLine();
						switch(option) {
							case 1:{
								while(true) {
									try {
										System.out.println("Enter ammount to Deposite");
										double amt = scn.nextDouble();scn.nextLine();
										card.deposite(amt);
										System.out.println(amt+" deposite successfully");
										System.out.println("Current Balance: "+card.balanceEnquiry());
										continue innerloop2;
									}//inner try
									catch (InputMismatchException e) {
										System.out.println("Error:Enter only numbers");
									}
									catch (InvalidAmountException e) {
										System.out.println("Error:"+e.getMessage());
									}
								}//inner while
							}//case:1
							case 2:{
								while(true) {
									try {
										System.out.println("Enter ammount to Withdraw");
										double amt = scn.nextDouble();scn.nextLine();
										card.withdraw(amt);
										System.out.println(amt+" Withdraw successfully");
										System.out.println("Current Balance: "+card.balanceEnquiry());
										continue innerloop2;
									}//inner try
									catch (InSufficientFundsException e) {
										System.out.println("Sorry: Insufficient Fund in your account");
									}
									catch (InvalidAmountException e) {
										System.out.println("Error:"+e.getMessage());
									}
								}//inner while
							}
							case 3: {
								System.out.println("Currents Balance: "+card.balanceEnquiry());
								continue innerloop2;
							}
							case 4:{
								break outerloop;
							}
							default:{
								System.out.println("Invalid Option: choose correct option");
							}
						}//switch
					}//while loop
					}//if
					else{
						System.out.println("Please: Try with a valid Bank Card");
					}
				}//innerwhile
			}//outer try
			catch (ClassNotFoundException | IllegalAccessException |NoClassDefFoundError|InstantiationException e) {
				
			System.out.println("Please: Enter a valid Bank Name");
				
			}catch (InputMismatchException e) {
				
				System.out.println("Enter only numbers");
				break;
			}
		}//outer while
		System.out.println("\n***************Thank-You,Visit Again**************");
	}//main
}//class
		