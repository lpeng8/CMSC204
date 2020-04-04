import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * assignment 4
 * @author pengl
 *
 */
public class ConcordanceDataManager implements ConcordanceDataManagerInterface{

	private ConcordanceDataStructure ccdTable;
	
	/**
	 * create a concordance array
	 * @return a string ArrayList
	 */
	@Override
	public ArrayList<String> createConcordanceArray(String input) {
		int lineNumber = 0;
		int size;
		String line;
		Scanner wordS;
		Scanner lineS;
		String word;
		String newInput = input.replaceAll("[,.!?\"_]", "").toLowerCase();
		
		lineS = new Scanner(newInput);
		size =newInput.split(" ").length;

		ccdTable = new ConcordanceDataStructure(size);

		while(lineS.hasNext()) {

			lineNumber++;

			line = lineS.nextLine();

			wordS = new Scanner(line);

			while(wordS.hasNext()) {

				word = wordS.next();

				if(!(word.equals("and")||word.equals("the")||word.length()<3))

					ccdTable.add(word,lineNumber);

			}
			wordS.close();
		}

		lineS.close();
		return ccdTable.showAll();
	}
	/**
	 * create an concordanceFile based on input from user
	 * @return true if file is created.
	 */
	@Override
	public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
		StringBuilder fileString = new StringBuilder("");
		Scanner lineS = new Scanner(input);
		ArrayList<String> dataArr;

		while(lineS.hasNext()) {
			fileString.append(lineS.nextLine().toLowerCase()+"\n");
		
		}
		
		dataArr = createConcordanceArray(fileString.toString());

		lineS.close();
		
		FileWriter fileWriter;
		try {

			fileWriter = new FileWriter(output);
			PrintWriter printWriter = new PrintWriter(fileWriter);

		    for(String str: dataArr) {

		    	printWriter.print(str+"\n");

		    }

		    printWriter.close();

		} catch (IOException e) {

			System.out.println("IOException is thrown");
		}

		return true;
	}

}
