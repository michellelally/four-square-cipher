package ie.gmit.sw;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;



public class FourSquareCipher {
	
	static char letterOneEnc, letterTwoEnc; 
	static int letterOneRow, letterOneColumn, letterTwoRow, letterTwoColumn;
//	char let1, let2;

	char[]alphabet1D =  {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', ' ', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	char[] keyOne1D =  {'Z', 'G', 'P', 'T', 'F','O', 'I', 'H', 'M', 'U', 'W', 'D', 'R', 'C', 'N','Y', 'K', 'E', 'Q', 'A','X', 'V', 'S', 'B', 'L'};
	char[] keyTwo1D = {'M', 'F', 'N', 'B', 'D','C', 'R', 'H', 'S', 'A','X', 'Y', 'O', 'G', 'V','I', 'T', 'U', 'E', 'W','L', 'Q', 'Z', 'K', 'P'};
	

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
	
	//Running time: O(N)
	static void getIndexesLetterOne(char[] array, char let1) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == let1) {
				letterOneRow = i / 5;
				letterOneColumn = i % 5;
			}
		}
	}

	//Running time: O(N)
	static void getIndexesLetterTwo(char[] array, char let2) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == let2) {
				letterTwoRow = i / 5;
				letterTwoColumn = i % 5;
			}
		}
	}

	//Running time: O(N^2)
	static void encrypt(char array[], char let1, char let2, char key1[][], char key2[][]) {
		getIndexesLetterOne(array, let1);
		getIndexesLetterTwo(array, let2);
		if (let1 == ' ') {
			letterOneEnc = ' ';
		} else {
			letterOneEnc = key1[letterOneRow][letterTwoColumn];
		}
		if (let2 == ' ') {
			letterTwoEnc = ' ';
		} else {
			letterTwoEnc = key2[letterTwoRow][letterOneColumn];
		}
	}
	
	//----------------------------------------------------------------------------------------------------------
	//---------------------------------------------DECRYPTION---------------------------------------------------
	//----------------------------------------------------------------------------------------------------------
	
	static char letterOneDec, letterTwoDec;
	static int letterOneEncRow, letterOneEncColumn, letterTwoEncRow, letterTwoEncColumn;
	
	public static void getIndexesEncLetterOne(char[] array, char let1) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == let1) {
				letterOneEncRow = i / 5;
				letterOneEncColumn = i % 5;
			}
		}
	}

	
	public static void getIndexesEncLetterTwo(char[] array, char let2) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == let2) {
				letterTwoEncRow = i / 5;
				letterTwoEncColumn = i % 5;
			}
		}
	}

	public static void decrypt(char key1[], char key2[], char let1, char let2, char[][] alphabet) {
		getIndexesEncLetterOne(key1, let1);
		getIndexesEncLetterTwo(key2, let2);
		letterOneDec = alphabet[letterOneEncRow][letterTwoEncColumn];
		letterTwoDec = alphabet[letterTwoEncRow][letterOneEncColumn];
		System.out.print(letterOneDec+""+letterTwoDec);
}
	
	//Fisher-Yates algorithm for shuffling an array, modified for a two dimensional array
	public static void generateRandomKey(char key[][]) {
		Random random = new Random();
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				int m = random.nextInt(i + 1);
	            int n = random.nextInt(j + 1);
	            char temp = key[i][j];
	            key[i][j] = key[m][n];
	            key[m][n] = temp;
	           
			}
		}
	}
	
	public static void displayKey(char key[][]) {
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(key[i][j]);
			}
		}
	}

	
}//end of class
