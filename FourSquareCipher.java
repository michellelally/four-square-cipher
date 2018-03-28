package ie.gmit.sw;

public class FourSquareCipher {
	
	static char letterOne, letterTwo, letterOneEnc, letterTwoEnc; 
	static int letterOneRow, letterOneColumn, letterTwoRow, letterTwoColumn, letterOneIndex, letterTwoIndex;

	static char[][] alphabet =  {
			{'A', 'B', 'C', 'D', 'E'},
			{'F', 'G', 'H', 'I', 'K'},
			{'L', 'M', 'N', 'O', 'P'},
			{' ', 'R', 'S', 'T', 'U'},
			{'V', 'W', 'X', 'Y', 'Z'}
	};	
	
	static char[][] keyOne =  {
			{'Z', 'G', 'P', 'T', 'F'},
			{'O', 'I', 'H', 'M', 'U'},
			{'W', 'D', 'R', 'C', 'N'},
			{'Y', 'K', 'E', ' ', 'A'},
			{'X', 'V', 'S', 'B', 'L'}
	};
	
	static char[][] keyTwo = {
		{'M', 'F', 'N', 'B', 'D',},
		{'C', 'R', 'H', 'S', 'A'},
		{'X', 'Y', 'O', 'G', 'V'},
		{'I', 'T', 'U', 'E', 'W'},
		{'L', ' ', 'Z', 'K', 'P'}
	};
	
	public static void getBigram(char a, char b){
		letterOne = a;
		letterTwo = b;
		
		//System.out.println("B: " + b);
	}
	

	public static void encrypt() {
		for (int i = 0; i < alphabet.length; i++) {
			for(int j = 0; j < alphabet.length; j++) {
				if (letterOne == alphabet[i][j]) {
					//System.out.println("A: " + letterOne);
					letterOneRow = i;
					letterOneColumn = j;
				}
			}
			for(int j = 0; j < alphabet.length; j++) {
				 if (letterTwo == alphabet[i][j]) {
					//System.out.println("B: " + letterTwo);
					letterTwoRow = i;
					letterTwoColumn = j;
				}
			}
				letterOneEnc = keyOne[letterOneRow][letterTwoColumn];
				letterTwoEnc = keyOne[letterTwoRow][letterOneColumn];				
		}
		System.out.println("A: " + letterOneEnc);
		System.out.println("B: " + letterTwoEnc);
		System.out.println("A: " + letterOneEnc);
		System.out.println("B: " + letterTwoEnc);
		
	}
	
	
}
