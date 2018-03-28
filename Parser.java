package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class Parser extends FourSquareCipher {
	public void parse (String file) {
		try {
			//Declaring objects and variables
			BufferedReader br = new BufferedReader(new FileReader(file));
			//ArrayDeque<String> ad = new ArrayDeque<String>();
			String line;
			int i;
			char charA, charB;
			String bigram;
			
			//Reading in each line of the file 
			while ((line = br.readLine()) != null) {
				//Replacing each j with an i, each q with an o
				line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('J', 'I').replace("Q", "O"); 
				for (i = 0; i < line.length(); i+=2) {
					if (line.length() % 2 != 0) {
						line += " ";
					}
					try {
						charA = line.charAt(i); 
						charB  = line.charAt(i+1);
						bigram = ""+charA+charB;
						//System.out.println(bigram);
						FourSquareCipher.getBigram(charA, charB);
						FourSquareCipher.encrypt();
						//String[] cipher = bigram.split("\\s+");
						//ad.addAll(Arrays.asList(cipher));
						charA = charB = ' ';
						bigram = null;
					} catch (StringIndexOutOfBoundsException siobe){
							System.out.print(" ");
					}
				}
			}
			br.close();	
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
}

