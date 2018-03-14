package ie.gmit.sw;

import java.io.*;

public class Parser {
	
	public void parse (String file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			int i;
			char charA, charB;
			String cipher;
			
			while ((line = br.readLine()) != null) {
				line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('j', 'i'); 
				for (i = 0; i < line.length(); i+=2) {
					try {
						charA = line.charAt(i); 
						charB = line.charAt(i+1);
						cipher = ""+charA+charB;
						System.out.println(cipher);
						charA = charB = ' ';
						cipher = null;
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

