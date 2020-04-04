import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
/**
 * Assignment 4
 * @author pengl
 *
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {

	private LinkedList<ConcordanceDataElement>[] ccdTable;
	private int size;
	/**
	 * default constructor
	 * @param num
	 */
	public ConcordanceDataStructure(int num) {
		size = fourKPlus3((int)(num/1.5));
		ccdTable = new LinkedList[size];
       
	}
	/**
	 * test constructor
	 * @param test
	 * @param size
	 */
	public ConcordanceDataStructure(String test, int size) {
		this.size = size;
		ccdTable = new LinkedList[size];
	}
	/**
	 * get table size
	 * @return size
	 */
	@Override
	public int getTableSize() {
		return size;
	}
	/**
	 * get a list of words
	 * @return a arraylist of words
	 */
	@Override
	public ArrayList<String> getWords(int index) {
		ArrayList<String> wordsList = new ArrayList<String>();

		LinkedList<ConcordanceDataElement> temp = ccdTable[index];

		for (int i = 0; i < temp.size(); i++) {

			wordsList.add(temp.get(i).getWord());

		}

		return wordsList;
		
	}
	/**
	 * get a list of page numbers
	 * @return a arraylist of pagenumbers
	 */
	@Override
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {
		ArrayList<LinkedList<Integer>> numberList = new ArrayList<LinkedList<Integer>>();

		LinkedList<ConcordanceDataElement> temp = ccdTable[index];

		for (int i = 0; i < temp.size(); i++) {

			numberList.add(temp.get(i).getList());

		}

		return numberList;
		
	}
	/**
	 * add concordance element
	 */
	@Override
	public void add(String word, int lineNum) {
		int index;
		boolean added = false;

		ConcordanceDataElement element = new ConcordanceDataElement(word.toLowerCase());

		index = Math.abs(element.hashCode() % size);

		if (ccdTable[index] != null) {

			for (int i = 0; i < ccdTable[index].size(); i++) {

				if (ccdTable[index].get(i).compareTo(element) == 0) {
					ccdTable[index].get(i).addPage(lineNum);
					added = true;
				}
			}

		} 
		else 
		{

			LinkedList<ConcordanceDataElement> temp = new LinkedList<ConcordanceDataElement>();

			temp.add(element);

			ccdTable[index] = temp;

			ccdTable[index].getFirst().addPage(lineNum);

			added = true;

		}

		if (added == false) {

			ccdTable[index].add(element);

			ccdTable[index].getLast().addPage(lineNum);

		}
		
	}
	/**
	 * display all words and line numbers in alphabetical order
	 * @return a arraylist of string that displays all words and line numbers
	 */
	@Override
	public ArrayList<String> showAll() {
        ArrayList<String> orderedWords = new ArrayList<String>();

		for(LinkedList<ConcordanceDataElement> temp: ccdTable) {

			if(temp != null) {

				for(ConcordanceDataElement concordance: temp) {

					if(concordance.getWord()!=null)

						orderedWords.add(concordance.toString());

				}

			}

		}

		Collections.sort(orderedWords);
		return orderedWords;
		
	}
	/**
	 * generate a 4k + 3 prime number
	 * @param n
	 * @return the prime number
	 */
	private int fourKPlus3(int n) 
    { 
		double k;
		int prime;
		
        BigInteger b = new BigInteger(String.valueOf(n)); 
       
        prime = Integer.parseInt(b.nextProbablePrime().toString()); 

    	k = (prime-3.0)%4.0;

    	while((prime-3.0)%4.0!=0) {

        	b = new BigInteger(String.valueOf(prime+1)); 

        	prime = Integer.parseInt(b.nextProbablePrime().toString()); 

        	k = (prime-3.0)/4.0;
        }

    	return prime;

    } 
	

}
