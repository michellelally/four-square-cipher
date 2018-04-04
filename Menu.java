package ie.gmit.sw;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu extends Parser{
	Scanner console = new Scanner(System.in);
	
	
	public void go() throws Exception {
		//System.out.println("\n");
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":                        Four Square Cipher                       :");
		System.out.println(":                                                                 :");
		System.out.println(":                              Menu                               :");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		System.out.println("\nPlease begin with choosing how you would like to declare the key");
		System.out.println("\n");
		keyOptions();
		mainOptions();
		
	
	}
	
	public void keyOptions() {
		System.out.println("|1| Generate a random key");
		System.out.println("|2| Enter key manually");
		System.out.println("|3| Use key from example \n");
		System.out.print("|>|");
		int choice = console.nextInt();
		switch (choice) {
			case 1:
				System.out.println("Generating key...");
				System.out.print("\nYour randomly generated key is: ");
				FourSquareCipher.generateRandomKey(keyOne);
				FourSquareCipher.generateRandomKey(keyTwo);
				FourSquareCipher.displayKey(keyOne);
				FourSquareCipher.displayKey(keyTwo);
			break;
			case 2:
				System.out.println("Please enter the key (Must be)");
			break;
			case 3:
				System.out.print("\nYour key is: ");
				FourSquareCipher.displayKey(keyOne);
				FourSquareCipher.displayKey(keyTwo);
			break;
			default:
				System.out.println("Please choose an option that is listed.");
				keyOptions();
			break;
		}//eo switch
		
	}
	
	public void mainOptions() throws Exception {
		System.out.println("\n");
		System.out.println("What would you like to do next?");
		System.out.println("|1| Encrypt");
		System.out.println("|2| Decrypt");
		System.out.println("|3| Change the key");
		System.out.println("|4| Quit\n");
		System.out.print("|>|");
		int choice = console.nextInt();
		while (choice != 4) {
			switch (choice) {
			case 1:
				encryptionMenu();
			break;
			default:
				System.out.println("Please choose an option that is listed.");
				mainOptions();
			break;
			}
		}
		
	}
	
	public void encryptionMenu() throws Exception {
		switch (readingFrom()) {
			case 1:
				long startTime = System.currentTimeMillis();
				new Parser().parseFile(setAddress(), outputType());
				System.out.println("\n\nRunning time (ms):" + (System.currentTimeMillis() - startTime));
			break;
			case 2:
				new Parser().parseURL(setAddress(), outputType());
			break;
			default:
				System.out.println("Please choose an option that is listed.");
				encryptionMenu();
			break;	
		}
		mainOptions();
	}
	
	public int readingFrom() {
		System.out.println("\nPlease choose where you would like to read from:");
		System.out.println("|1| File");
		System.out.println("|2| URL\n");
		System.out.print("|>|");
		int choice = console.nextInt();
		return choice; 	
	}
	
	public String setAddress() {
		System.out.println("\nPlease enter the address:\n");
		System.out.print("|>|");
		String address = console.next();
		return address;
	}
	
	
	public int outputType() {
		System.out.println("\nPlease choose where you would like the encrypted data to be displayed: ");
		System.out.println("|1| Console");
		System.out.println("|2| File\n");
		System.out.print("|>|");
		int choice = console.nextInt();
		return choice; 	
	}
	

}
