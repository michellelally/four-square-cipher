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
	static char letterOneEnc, letterTwoEnc; 
	static int letterOneRow, letterOneColumn, letterTwoRow, letterTwoColumn;
	char let1, let2;

	char[]alphabet1D =  {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', ' ', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	
	char[][] alphabet =  {
		{'A', 'B', 'C', 'D', 'E'},
		{'F', 'G', 'H', 'I', 'K'},
		{'L', 'M', 'N', 'O', 'P'},
		{' ', 'R', 'S', 'T', 'U'},
		{'V', 'W', 'X', 'Y', 'Z'}
	};	
	
	char[][] keyOne =  {
		{'Z', 'G', 'P', 'T', 'F'},
		{'O', 'I', 'H', 'M', 'U'},
		{'W', 'D', 'R', 'C', 'N'},
		{'Y', 'K', 'E', 'Q', 'A'},
		{'X', 'V', 'S', 'B', 'L'}
	};
	
	char[][] keyTwo = {
		{'M', 'F', 'N', 'B', 'D'},
		{'C', 'R', 'H', 'S', 'A'},
		{'X', 'Y', 'O', 'G', 'V'},
		{'I', 'T', 'U', 'E', 'W'},
		{'L', 'Q', 'Z', 'K', 'P'}
	};
	
	
	public static void getIndexesLetterOne(char[] array, char let1) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == let1) {
				letterOneRow = i / 5;
				letterOneColumn = i % 5;
			}
		}
	}

	
	public static void getIndexesLetterTwo(char[] array, char let2) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == let2) {
				letterTwoRow = i / 5;
				letterTwoColumn = i % 5;
			}
		}
	}

	public static void encrypt(char array[], char let1, char let2, char key1[][], char key2[][]) {
		getIndexesLetterOne(array, let1);
		getIndexesLetterTwo(array, let2);
		letterOneEnc = key1[letterOneRow][letterTwoColumn];
		letterTwoEnc = key2[letterTwoRow][letterOneColumn];
	/*	System.out.println("\nA Row: " + letterOneRow);
		System.out.println("A Column: " + letterOneColumn);
		System.out.println("B Row: " + letterTwoRow);
		System.out.println("B Column: " + letterTwoColumn); */
	//	String bigram = letterOneEnc+""+letterTwoEnc;
	//	System.out.print(bigram);
	}
	
	//----------------------------------------------------------------------------------------------------------
	//---------------------------------------------DECRYPTION---------------------------------------------------
	//----------------------------------------------------------------------------------------------------------
	
	static char letterOneDec, letterTwoDec;
	static int letterOneEncRow, letterOneEncColumn, letterEncTwoRow, letterEncTwoColumn;
	
	public static void getIndexesEncLetterOne(char[][] alpha) {
		letterOneDec = alpha[letterOneRow][letterOneColumn];
	/*	
		for(int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == let1) {
					letterOneEncRow = i / 5;
					letterOneEncColumn = i % 5;
				}
			}
		}*/
	}

	
	public static void getIndexesEncLetterTwo(char[][] alpha) {
		letterTwoDec =  alpha[letterTwoRow][letterTwoColumn];
		
	/*	for(int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == let2) {
					letterOneEncRow = i / 5;
					letterOneEncColumn = i % 5;
				}
			}
		}*/
	}

	public static void decrypt(char[][] alphabet) {
		getIndexesEncLetterOne(alphabet);
		getIndexesEncLetterTwo(alphabet);
		System.out.print(letterOneDec+""+letterTwoDec);
	/*	letterOneDec = alphabet[letterOneRow][letterTwoColumn];
		letterTwoDec = keyTwo[letterTwoRow][letterOneColumn];
		

	/*			

	*/ 
	}
	
}//end of class

/*
 * 

 */
