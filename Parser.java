package ie.gmit.sw;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.net.*;

public class Parser extends FourSquareCipher{
	public void parseFile(String file,int outputType) throws FileNotFoundException { //file or console, encrypting or decrypting
		//Declaring objects needed for file reading
	//	System.out.print("ENTERING PARSEFILE METHOD");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedReader br = null;
		try {
			///Declaring objects and variables
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);	
			br = new BufferedReader(new InputStreamReader(bis, StandardCharsets.UTF_8));
			String line;
			System.out.println("\nEncrypting file...\n");
			while ((line = br.readLine()) != null) {
				//Replacing each j with an i, each q with an o
				line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('J', 'I').replace("Q", "O"); 
				
				bigramAndEncrypt(line, outputType);
				
				
			}
			
			System.out.println("\n\nEncryption completed.");
			br.close();
			
		} catch (IOException e) {
		e.printStackTrace();
		}
	}// eo parse
	
	 public void parseURL(String url, int outputType) throws Exception {
		 	URL website = new URL(url);
	        URLConnection connection = website.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;

	        while ((line = in.readLine()) != null) {
	        	//Replacing each j with an i, each q with an o
	        	line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('J', 'I').replace("Q", "O");
	        	bigramAndEncrypt(line, outputType);
	        }
	        in.close();
	    }
	 
	 public void bigramAndEncrypt(String line, int outputType) {
		 char charA, charB;
		 int i;
			if (line.length() % 2 != 0) {
				line += " ";
			}
			for (i = 0; i < line.length(); i+=2) {
				charA = line.charAt(i); 
				charB  = line.charAt(i+1);
				FourSquareCipher.encrypt(alphabet1D, charA, charB, keyOne, keyTwo);
				//String output = ;
				
				System.out.print(letterOneEnc+""+letterTwoEnc);
			}
	 }
}//eo class

