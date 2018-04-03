package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class Parser extends FourSquareCipher{
	
	public Parser(String fileName) {
		this.parse(fileName);
	}

	public void parse (String file) {
		try {
			//Declaring objects and variables
			BufferedReader br = new BufferedReader(new FileReader(file));
		//	ArrayDeque<String> ad = new ArrayDeque<String>();
			String line;
			int i;
			char charA, charB;
		//	String bigram;
			
			//Reading in each line of the file 
			while ((line = br.readLine()) != null) {
				//Replacing each j with an i, each q with an o
				line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('J', 'I').replace("Q", "O"); 
				if (line.length() % 2 != 0) {
					line += " ";
				}
				for (i = 0; i < line.length(); i+=2) {
					charA = line.charAt(i); 
					charB  = line.charAt(i+1);
					FourSquareCipher.encrypt(alphabet1D, charA, charB, keyOne, keyTwo);
					FourSquareCipher.decrypt(alphabet);
					//String[] cipher = bigram.split("\\s+");
					//ad.addAll(Arrays.asList(cipher));
				}
			}
			br.close();	
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
}

