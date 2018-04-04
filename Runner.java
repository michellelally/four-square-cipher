package ie.gmit.sw;

public class Runner {

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		Parser p = new Parser();
		p.parseFile("./Input/WarAndPeace.txt");
		long runningTime = System.currentTimeMillis() - startTime; 
		System.out.println("\n\nRunning time (ms):"+ runningTime);
		
/*
		

		
		Menu m = new Menu();
		m.go();
		
*/
	}

}
