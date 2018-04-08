package ie.gmit.sw;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Menu extends Parser {
	Scanner console = new Scanner(System.in);
	JFileChooser fc = new JFileChooser();
	public void go() throws Exception {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":                        Four Square Cipher                       :");
		System.out.println(":                                                                 :");
		System.out.println(":                              Menu                               :");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		keyOptions();
		
		System.out.println("\n" +"What would you like to do next?");
		System.out.println("\n" +  "|1| Encrypt" + "\n" + "|2| Decrypt" + "\n" + "|3| Change the key" + "\n" + "|4| Quit\n");
		System.out.print("|>|");
		byte choice = console.nextByte();
		
		while (choice !=4) {
			mainOptions(choice);
			System.out.println("\n\n" +"What would you like to do next?");
			System.out.println("\n" +  "|1| Encrypt" + "\n" + "|2| Decrypt" + "\n" + "|3| Change the key" + "\n" + "|4| Quit\n");
			System.out.print("|>|");
			choice = console.nextByte();
		}
			
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
				System.out.print("\n");
			break;
			case 2:
				System.out.println("Please enter the keyword." + "\n");
				String keyword = console.next();
				setKey(keyword, alphabet1D, keyOne);
				setKey(keyword, alphabet1D, keyTwo);
				displayKey(keyOne);
				displayKey(keyTwo);
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
	}
	
	public void mainOptions(byte choice) throws Exception {

			switch (choice) {
			case 1:
				cipherMenu(choice);
			break;
			case 2:
				cipherMenu(choice);
			break;
			case 3: 
				keyOptions();
				break;
			default:
				System.out.println("Please choose an option that is listed.");
		}
			
	}
	
	public void cipherMenu(byte choice) throws Exception {
			switch (readingFrom()) {
			case 1:
				parseFile(setPath(), outputType(), choice);			
				break;
			case 2:
				parseURL(choice);
				break;
			default:
				System.out.println("Please choose an option that is listed.");
				cipherMenu(choice);
			break;	
			}
	}

	
	public byte readingFrom() {
		System.out.println("\nPlease choose where you would like to read from.");
		System.out.println("\n" +"|1| File" + "\n" + "|2| URL" + "\n");
		System.out.print("|>|");
		byte choice = console.nextByte();
		return choice; 	
	}
	
	public String setPath() {
		String address = "";
		fc.setCurrentDirectory(new File("./Input/"));
        int fileChooseResult = fc.showOpenDialog(null);

        if (fileChooseResult == JFileChooser.APPROVE_OPTION) {
          address = fc.getSelectedFile().getAbsolutePath();
        }
        return address;
	}
	
	public void parseURL(byte choice) throws Exception {
		String input = JOptionPane.showInputDialog("Please enter the URL.");
        boolean urlValid = false;

        while (!urlValid) {
          try {
            urlValid = true;
            new ParseURL().parseURL(input, outputType(), choice);
          } catch (MalformedURLException e) {
            input = JOptionPane.showInputDialog("Invalid URL, try again!");
          }
        }
	}
      
	public byte outputType() {
		System.out.println("\nPlease choose where you would like the encrypted data to be displayed");
		System.out.println("\n" +"|1| Console" + "\n" + "|2| File" + "\n");
		System.out.print("|>|");
		byte choice = console.nextByte();
		return choice; 	
	}
	
}
