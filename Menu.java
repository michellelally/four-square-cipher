package ie.gmit.sw;

import java.util.Scanner;

public class Menu extends Parser {
	Scanner console = new Scanner(System.in);
	public void go() throws Exception {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":                        Four Square Cipher                       :");
		System.out.println(":                                                                 :");
		System.out.println(":                              Menu                               :");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		keyOptions();
	}
	
	public void keyOptions() throws Exception {
		System.out.println("\nPlease begin with choosing how you would like to declare the key");
		System.out.println("|1| Generate a random key" + "\n" +  "|2| Enter key manually" + "\n" +  "|3| Use key from example" + "\n");
		System.out.print("|>|");
		byte choice = console.nextByte();
		switch (choice) {
			case 1:
				System.out.print("\nYour key is: ");
				generateRandomKey(keyOne);
				generateRandomKey(keyTwo);
				generateRandomKey(alphabet);
				displayKey(keyOne);
				displayKey(keyTwo);
			break;
			case 2:
				System.out.println("Please enter the keyword." + "\n");
				String keyword = console.next();
				setKey(keyword, alphabet1D, keyOne);
			break;
			case 3:
				System.out.print("\nYour key is: ");
				displayKey(keyOne);
				displayKey(keyTwo);
			break;
			default:
				System.out.println("Please choose an option that is listed.");
				keyOptions();
			break;
		}//eo switch
		mainOptions();
	}
	
	public void mainOptions() throws Exception {
		System.out.println("\n" +"What would you like to do next?");
		System.out.println("\n" +  "|1| Encrypt" + "\n" + "|2| Decrypt" + "\n" + "|3| Change the key" + "\n" + "|4| Quit\n");
		System.out.print("|>|");
		byte choice = console.nextByte();
		while (choice != 4) {
			switch (choice) {
			case 1:
				cipherMenu(choice);
			break;
			case 2:
				cipherMenu(choice);
			break;
			case 3: 
				keyOptions();
			case 4: 
				System.exit(0);
			default:
				System.out.println("Please choose an option that is listed.");
				mainOptions();
			break;
			}
		}
	}
	
	public void cipherMenu(byte choice) throws Exception {
		switch (readingFrom()) {
			case 1:
				parseFile(setAddress(), outputType(), choice);
			break;
			case 2:
				ParseURL p = new ParseURL();
				p.parseURL(setAddress(), outputType(), choice);
			break;
			default:
				System.out.println("Please choose an option that is listed.");
				cipherMenu(choice);
			break;	
		}
		mainOptions();
	}

	
	public byte readingFrom() {
		System.out.println("\nPlease choose where you would like to read from.");
		System.out.println("\n" +"|1| File" + "\n" + "|2| URL" + "\n");
		System.out.print("|>|");
		byte choice = console.nextByte();
		return choice; 	
	}
	
	public String setAddress() {
		System.out.println("\nPlease enter the address:\n");
		System.out.print("|>|");
		String address = console.next();
		return address;
	}
	
	public byte outputType() {
		System.out.println("\nPlease choose where you would like the encrypted data to be displayed");
		System.out.println("\n" +"|1| Console" + "\n" + "|2| File" + "\n");
		System.out.print("|>|");
		byte choice = console.nextByte();
		return choice; 	
	}
	

}
