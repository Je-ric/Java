import java.util.Scanner;

public class Account{
	private String name;
	private int accNumber;
	private double balance;

	public Account (String name, int accNumber, double balance) {
		this.name = name;
		this.accNumber = accNumber;
		this.balance = balance;
	}

	public String getName () {
		return name;
	}
	public int getAccNumber() {
		return accNumber;
	}
	public double getBalance() {
		return balance;
	}	
	public void setName(String name) {
		this.name = name;
	}
	public void setAccNumber(int accNumber) {		
		this.accNumber = accNumber;
	}
	public void setBalance (double balance ) {
		this.balance = balance;
	}

	public void withdraw (double amount) {
		if (amount <= balance){
			balance -= amount;
			System. out. println("Withdrawn: " + amount);
		} 
		else {
			System.out. println("Insufficient balance... ") ;
		}
	}
		
	public void deposit(double amount) {
	    if (amount >= 0){  
	        balance += amount;
	        System.out.println("Deposited: " + amount);
	    } 
	    else {
	        System.out.println("Invalid deposit amount...");
	    }
	}
}