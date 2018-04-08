package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class ParseURL extends Parser{
	
	//O(n^n)
	 public void parseURL(String url, byte outputType, byte encOrDec) throws Exception {
	 	URL website = new URL(url);
        URLConnection connection = website.openConnection();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        String line;
        
		File fileOutput = new File("./Output.txt");
		fileOutput.createNewFile();
		PrintWriter pw = new PrintWriter(fileOutput); 

        while ((line = in.readLine()) != null) {
        	//Replacing each j with an i, each q with an o
        	line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('J', 'I');
        	bigramAndCipher(line, outputType, encOrDec, pw);
        }
        in.close();
        pw.close();
	 }

}
