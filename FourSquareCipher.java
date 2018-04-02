package ie.gmit.sw;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FourSquareCipher {
	static char letterOneEnc, letterTwoEnc, letterOneDec, letterTwoDec; 
	
	static int letterOneRow, letterOneColumn, letterTwoRow, letterTwoColumn;

	static char[]alphabet1D =  {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', ' ', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	private char[][] alphabet =  {
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
			{'Y', 'K', 'E', 'Q', 'A'},
			{'X', 'V', 'S', 'B', 'L'}
	};
	
	static char[][] keyTwo = {
		{'M', 'F', 'N', 'B', 'D',},
		{'C', 'R', 'H', 'S', 'A'},
		{'X', 'Y', 'O', 'G', 'V'},
		{'I', 'T', 'U', 'E', 'W'},
		{'L', 'Q', 'Z', 'K', 'P'}
	};
	
	public static void getIndexesLetterOne(char let1) {
		for(int i = 0; i < alphabet1D.length; i++) {
			if (alphabet1D[i] == let1) {
				letterOneRow = i / 5;
				letterOneColumn = i % 5;
			}
		}
	}

	
	public static void getIndexesLetterTwo(char let2) {
		for(int i = 0; i < alphabet1D.length; i++) {
			if (alphabet1D[i] == let2) {
				letterTwoRow = i / 5;
				letterTwoColumn = i % 5;
			}
		}
	}

	public static void encrypt(char let1, char let2) {
		getIndexesLetterOne(let1);
		getIndexesLetterTwo(let2);
		letterOneEnc = keyOne[letterOneRow][letterTwoColumn];
		letterTwoEnc = keyTwo[letterTwoRow][letterOneColumn];
		String bigram = letterOneEnc+""+letterTwoEnc;
		System.out.print(bigram);
	/*			
		System.out.println("\nA Row: " + letterOneRow);
		System.out.println("A Column: " + letterOneColumn);
		System.out.println("B Row: " + letterTwoRow);
		System.out.println("B Column: " + letterTwoColumn);
	*/ 
	}
	
	//----------------------------------------------------------------------------------------------------------
	//---------------------------------------------DECRYPTION---------------------------------------------------
	//----------------------------------------------------------------------------------------------------------
	
	public static void getIndexesEncLetterOne(char let1) {
		for(int i = 0; i < alphabet1D.length; i++) {
			if (alphabet1D[i] == let1) {
				letterOneRow = i / 5;
				letterOneColumn = i % 5;
			}
		}
	}

	
	public static void getIndexesEncLetterTwo(char let2) {
		for(int i = 0; i < alphabet1D.length; i++) {
			if (alphabet1D[i] == let2) {
				letterTwoRow = i / 5;
				letterTwoColumn = i % 5;
			}
		}
	}

	public static void decrypt(char let1, char let2) {
		getIndexesEncLetterOne(let1);
		getIndexesEncLetterTwo(let2);
		letterOneEnc = keyOne[letterOneRow][letterTwoColumn];
		letterTwoEnc = keyTwo[letterTwoRow][letterOneColumn];
		System.out.print(letterOneEnc+""+letterTwoEnc);

	/*			
		System.out.println("\nA Row: " + letterOneRow);
		System.out.println("A Column: " + letterOneColumn);
		System.out.println("B Row: " + letterTwoRow);
		System.out.println("B Column: " + letterTwoColumn);
	*/ 
	}
	
}//end of class

/*
 * 

 */
