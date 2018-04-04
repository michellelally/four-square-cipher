package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Random;

public class Runner {

	public static void main(String[] args) throws Exception {
	
		long startTime = System.currentTimeMillis();
		Parser p = new Parser();
		
		new Parser().parseFile("./Input/WarAndPeace.txt", 1);
		long runningTime = System.currentTimeMillis() - startTime; 
		System.out.println("\n\nRunning time (ms):" + (System.currentTimeMillis() - startTime));
	/*	Menu m = new Menu();
		m.go();
		//calculations.cal();
		/*	

	

		
		
		
*/
	}

}
