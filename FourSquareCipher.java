package ie.gmit.sw;

public class FourSquareCipher {
	private char[][] alphabet =  {
			{'A', 'B', 'C', 'D', 'E'},
			{'F', 'G', 'H', 'I', 'K'},
			{'L', 'M', 'N', 'O', 'P'},
			{' ', 'R', 'S', 'T', 'U'},
			{'V', 'W', 'X', 'Y', 'Z'}
	};
	
	private char[][] keyOne =  {
			{'Z', 'G', 'P', 'T', 'F'},
			{'O', 'I', 'H', 'M', 'U'},
			{'W', 'D', 'R', 'C', 'N'},
			{'Y', 'K', 'E', ' ', 'A'},
			{'X', 'V', 'S', 'B', 'L'}
	};
	
	private char[][] keyTwo = {
		{'M', 'F', 'N', 'B', 'D',},
		{'C', 'R', 'H', 'S', 'A'},
		{'X', 'Y', 'O', 'G', 'V'},
		{'I', 'T', 'U', 'E', 'W'},
		{'L', ' ', 'Z', 'K', 'P'}
	};

}
