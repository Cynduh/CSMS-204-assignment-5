package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * @author Johnathan Duong
 */
public class MorseCodeConverter {

	private static MorseCodeTree morse = new MorseCodeTree();
	
	public MorseCodeConverter() {
		
	}
	/*
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param code - the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String[] letterCode;
		String[] wordCode = code.split(" / ");
		StringBuilder English  = new StringBuilder();
		
		for (String s : wordCode) {
			letterCode = s.split(" ");
			for(String temp : letterCode) {
				English.append(morse.fetch(temp));
			}
			English.append(" ");
		}
		return English.toString().trim();
	}
	/*
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	 * @param codeFile
	 * @return the English translation of the file
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		StringBuilder sb = new StringBuilder();
		InputStream input = new FileInputStream(codeFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		
		br.lines().forEach(s -> sb.append(convertToEnglish(s)).append("\n"));
		try {
			br.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return sb.toString().trim();
	}
	
	/*
	 * returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree It should return the data in this order:
	 *"h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 *Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal, the root would come between the right most child of the left 
	 *tree (j) and the left most child of the right tree (b). This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree()
	{
		String output="";
		ArrayList<String> tree = new ArrayList<>();
		tree = morse.toArrayList();
		for (int i=0; i< tree.size(); i++)
		{	
			if (tree.get(i).equals("o"))
				output +=tree.get(i);
			else output += tree.get(i)+" ";
		}
		return output;
	}
}
