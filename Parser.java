package ie.gmit.sw;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.net.*;

public class Parser extends FourSquareCipher{
	public void parseFile(String file) {
		//Declaring objects needed for file reading
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedReader br = null;
		try {
			///Declaring objects and variables
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);	
			br = new BufferedReader(new InputStreamReader(bis, StandardCharsets.UTF_8));
			String line;
			int i;
			char charA, charB;
			boolean consoleOrFile = true;
			
			while ((line = br.readLine()) != null) {
				//Replacing each j with an i, each q with an o
				line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('J', 'I').replace("Q", "O"); 
				if (line.length() % 2 != 0) {
					line += " ";
				}
				for (i = 0; i < line.length(); i+=2) {
					charA = line.charAt(i); 
					charB  = line.charAt(i+1);
					if (charA == ' ' || charB == ' ') {
						System.out.print(" ");
					}
				//	FourSquareCipher.encrypt(alphabet1D, charA, charB, keyOne, keyTwo);
					FourSquareCipher.decrypt(keyOne1D,keyTwo1D, charA, charB, alphabet);
				}
			}
			br.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}// eo parse
	
	 public void parseURL(String url) throws Exception {
	        
		 	URL website = new URL(url);
	        URLConnection connection = website.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	
	        //StringBuilder response = new StringBuilder();
	        String line;
	        int i;
	        char charA, charB;
	
	        while ((line = in.readLine()) != null) {
	        	//Replacing each j with an i, each q with an o
	        	line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('J', 'I').replace("Q", "O"); 
				if (line.length() % 2 != 0) {
					line += " ";
				}
				for (i = 0; i < line.length(); i+=2) {
					charA = line.charAt(i); 
					charB  = line.charAt(i+1);
					System.out.print(charA+""+charB);
					//FourSquareCipher.encrypt(alphabet1D, charA, charB, keyOne, keyTwo);
					//FourSquareCipher.decrypt(alphabet);
				}
	        }
	        in.close();
	    }
}//eo class

