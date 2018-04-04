package ie.gmit.sw;

import java.util.Scanner;

public class Menu extends Parser{
	Scanner console = new Scanner(System.in);
	public void go() {
		//System.out.println("\n");
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":                        Four Square Cipher                       :");
		System.out.println(":                                                                 :");
		System.out.println(":                              Menu                               :");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		System.out.println("\nPlease begin with choosing how you would like to declare the key");
		System.out.println("\n");
		keyOptions();
		
	
	}
	
	public void keyOptions() {
		System.out.println("|1| Generate a random key");
		System.out.println("|2| Enter key manually\n");
		System.out.print("|>|");
		int choice = console.nextInt();
		if (choice == 1) {
			System.out.println("Generating key...");
			//FourSquareCipher fsc = new FourSquareCipher();
			System.out.print("\nYour randomly generated key is: ");
			FourSquareCipher.generateRandomKey(keyOne);
			FourSquareCipher.generateRandomKey(keyTwo);
		}
		
	}
}
