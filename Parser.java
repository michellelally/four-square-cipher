package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class Parser {
	
	public Parser(String fileName) {
		this.parse(fileName);
	}

	public void parse (String file) {
		try {
			//Declaring objects and variables
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int i;
			char charA, charB;
			
			//Reading in each line of the file 
			while ((line = br.readLine()) != null) {
				//Replacing each j with an i, each q with an o
				line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('J', 'I').replace("Q", "O"); 
				if (line.length() % 2 != 0) {
					line += "";
				}
				for (i = 0; i < line.length(); i+=2) {
						charA = line.charAt(i); 
						charB  = line.charAt(i+1);
						FourSquareCipher.encrypt(charA, charB);
				}
			}
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
}

