import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * Assignment 5
 * @author pengl
 *
 */

public class MorseCodeConverter {

	
	private static MorseCodeTree morseCode = new MorseCodeTree();

/**
 * convert morse code to english
 * @param code
 * @return decrypted words in english
 */
	public static String convertToEnglish(String code) {

        String[] letter;
		String[] word = code.split(" / ");
		String decryptedWords = "";


		for(String temp: word) {

			letter = temp.split(" ");

			for(String tempLetter: letter) {

				decryptedWords +=morseCode.fetch(tempLetter);

			}

			decryptedWords += " ";

		}

		return decryptedWords.trim();
	}
	/**
	 * convert a morse code file into english
	 * @param codeFile
	 * @return decrypted words
	 * @throws FileNotFoundException
	 */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException{

		Scanner s1 = new Scanner(codeFile);
		String fileStr = "";

		while(s1.hasNextLine())

			fileStr += s1.nextLine() + "\n"; 

		s1.close();

		return convertToEnglish(fileStr.trim());

	}


/**
 * display tree 
 * @return a tree in LNR order
 */
	public static String printTree() {

		ArrayList<String> tree = morseCode.toArrayList();

		String print = "";

		for(String letters: tree) {

			print += letters + " ";

		}

		return print.trim();

	}

}