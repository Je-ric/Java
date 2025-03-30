import java.util.Scanner;

public class Bank {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.print(" Enter your name: ");
		String name = scanner.nextLine();
		
		System.out.print(" Enter account number: ");
		int accNumber = scanner.nextInt();

		System.out.print(" Enter balance: ");
		double balance = scanner.nextDouble();
		Account account = new Account (name, accNumber, balance);

		int choice;
		while(true){
			System.out.println("* * * BANK ACCOUNT * * *");
			System.out.println("[1] Display Data");
			System.out.println("[2] Set Balance");
			System.out.println("[3] Set Name");
			System.out.println("[4] Set Account Number");
			System.out.println("[5] Deposit");
			System.out.println("[6] Withdraw");
			System.out.println("[7] Exit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
		
			switch(choice){
				case 1:
					System.out.println("Name: " + account.getName());
					System.out.println("Account Number: "+ account.getAccNumber());
					System.out.println ("Balance: " + account.getBalance());
					break;	

				case 2:
					System.out.print("Enter new balance: ");
					double newBalance = scanner.nextDouble();
					account.setBalance(newBalance);
					break;
					
				case 3:
					System.out.print("Enter new name: ");
					scanner.nextLine();
					String newName = scanner.nextLine();
					account.setName(newName);
					break;
					
				case 4:
					System.out.print("Enter new account number: ");
					int newAccNumber = scanner. nextInt ();
					account.setAccNumber(newAccNumber);
					break;

				case 5:
					System.out.print("Enter amount to deposit: ");
					double depositAmount = scanner.nextDouble();
					account.deposit(depositAmount);
					break;

				case 6:
					System.out.print(" Enter amount to withdraw: ");
					double withdrawAmount = scanner.nextDouble();
					account.withdraw(withdrawAmount);
					break;

				case 7:
					System.out.print("Exiting Program...");
					break;

				default:
					System.out.println("Invalid choice. ");
			}
			if(choice == 7){
				break;
			}
		}
	}
}