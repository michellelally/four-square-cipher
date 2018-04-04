package ie.gmit.sw;

import java.io.BufferedWriter;
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
	char let1, let2;
	private static final String FILENAME = "./Output//Output.txt";

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
	
	//Running time: O(N)
	public static void getIndexesLetterOne(char[] array, char let1) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == let1) {
				letterOneRow = i / 5;
				letterOneColumn = i % 5;
			}
		}
	}

	//Running time: O(N)
	public static void getIndexesLetterTwo(char[] array, char let2) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == let2) {
				letterTwoRow = i / 5;
				letterTwoColumn = i % 5;
			}
		}
	}

	//Running time: O(N^2)
	public static void encrypt(char array[], char let1, char let2, char key1[][], char key2[][]) {
		getIndexesLetterOne(array, let1);
		getIndexesLetterTwo(array, let2);
		letterOneEnc = key1[letterOneRow][letterTwoColumn];
		letterTwoEnc = key2[letterTwoRow][letterOneColumn];
		
		System.out.print(letterOneEnc+""+letterTwoEnc+"");
		//System.out.print(output);
	/*	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
			bw.write(letterOneEnc+""+letterTwoEnc);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
 
	/*	System.out.println("\nA Row: " + letterOneRow);
		System.out.println("A Column: " + letterOneColumn);
		System.out.println("B Row: " + letterTwoRow);
		System.out.println("B Column: " + letterTwoColumn); */
		
		
	}
	
	//----------------------------------------------------------------------------------------------------------
	//---------------------------------------------DECRYPTION---------------------------------------------------
	//----------------------------------------------------------------------------------------------------------
	
	//Running time: O(1)
	public static char getIndexesEncLetterOne(char[][] alpha) {
		char letterOneDec = alpha[letterOneRow][letterOneColumn];
		return letterOneDec;
	}

	//Running time: O(1)
	public static char getIndexesEncLetterTwo(char[][] alpha) {
		char letterTwoDec =  alpha[letterTwoRow][letterTwoColumn];
		return letterTwoDec;
	}

	//Running time: O(1)
	public static void decrypt(char[][] alphabet)  {
		String output = getIndexesEncLetterOne(alphabet)+""+getIndexesEncLetterTwo(alphabet);
		//System.out.print(output);
	/*	try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
			
			bw.write(output);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
 */
	}
	
	public static void generateRandomKey(char key[][]) {
		Random r = new Random();
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				//System.out.print("j length: " + key.length);
				char c = (char)(r.nextInt(26) + 'a');
				if (c == 'j') {
					c = (char)(r.nextInt(26) + 'a');
				}
				key[i][j] = c;
				System.out.print(key[i][j]);
			}
		}
		
		/*			
			System.out.print(c);*/
	}
	
}//end of class
