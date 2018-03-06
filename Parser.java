package ie.gmit.sw;

import java.io.*;

public class Parser {
	
	public void parse (String res) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(res));
			String line = null;
			
			while ((line = br.readLine()) != null) {
				line = line.toUpperCase().replaceAll("[^A-Z]", " ").replace('j', 'i'); 
				System.out.println(line);
		}
			br.close();	
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	

/*
	public String parse (String res, boolean unit) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(res)));
		String line = null;
		
		while ((line = br.readLine())!=null) {
			line = line.toUpperCase().replaceAll("[A-Za-a0-9]", " ").replace('j', 'i'); 
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
*/
	
}

