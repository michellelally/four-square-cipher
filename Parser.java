package ie.gmit.sw;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Parser extends FourSquareCipher {	
	//O(n)
	 public void bigramAndCipher(String line, byte outputType, byte encOrDec, PrintWriter out) {
		 char charA, charB;
		 int i;
			if (line.length() % 2 != 0) {
				line += " ";
			}
			for (i = 0; i < line.length(); i+=2) {
				charA = line.charAt(i); 
				charB  = line.charAt(i+1);
				switch(encOrDec) {
				case 1:
					encrypt(alphabet1D, charA, charB, keyOne, keyTwo);
					output(letterOneEnc, letterTwoEnc, outputType, out);
					break;
				case 2: 
					decrypt(keyOne1D,keyTwo1D, charA, charB, alphabet);
					output(letterOneDec, letterTwoDec, outputType, out);
					break;
				default:
					break;	
				}
			}
	 }
	 
	 public void output(char charA, char charB, byte outputType, PrintWriter out){
		 switch (outputType) {
		 case 1:
			 System.out.print(charA+""+charB);
			 break;
		 case 2:
			 out.print(charA+""+charB);
			 break;
		 }
		 
	 }
	
	//O(n^n)
	public void parseFile(String file, byte outputType, byte encOrDec) throws FileNotFoundException {
		//Declaring objects needed for file reading
		long startTime = System.currentTimeMillis();
		int bufferSize = 10240; 
		
		try {
			///Declaring objects needed for reading the file
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"), bufferSize);
				
			///Declaring objects needed for outputting the file
			File fileOutput = new File("./Output/Output.txt");
			fileOutput.createNewFile();
			PrintWriter pw = new PrintWriter(fileOutput); 
			
			//Variables
			String line;
			
			System.out.println("\nReading... Ciphering...\n");
			//Reading the file line by line, Replacing each j with an i, each q with an o and then calling the bigramAndCipher() method
			while ((line = br.readLine()) != null) {
				line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('J', 'I'); 
				bigramAndCipher(line, outputType, encOrDec, pw);
			}
			
			System.out.println("\nCipher complete in :" + (System.currentTimeMillis() - startTime) + "(ms)");
			br.close();	
			pw.close();
			
		} catch (IOException e) {
		e.printStackTrace();
		}
	}// eo parse
	 
}//eo class

