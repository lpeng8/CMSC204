
import java.util.Iterator;
import java.util.LinkedList;
/**
 * 
 * @author pengl
 *Assignment 4
 */
public class ConcordanceDataElement implements Comparable<ConcordanceDataElement>{

	private String word;
	private LinkedList<Integer> lineNumbers;
	/**
	 * default constructor
	 * @param word
	 */
	ConcordanceDataElement(String word){
		this.word = word;

		lineNumbers = new LinkedList<Integer>()	;
	}
	/**
	 * add page number
	 * @param lineNum
	 */
	public void addPage(int lineNum) {
		if(!lineNumbers.contains(lineNum)) {

			lineNumbers.add(lineNum);

		}
		
	}
	/**
	 * compare elemetns
	 * @return the result
	 */
	@Override
	public int compareTo(ConcordanceDataElement arg0) {
		return this.word.compareToIgnoreCase(arg0.getWord());
	}
    /**
     * get the line numbers
     * @return an integer linked list
     */
	public LinkedList<Integer> getList(){
		return  lineNumbers;
	}
	/**
	 * get word
	 * @return word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * get hash value
	 * @return has value
	 */
	public int hashCode() {
		return word.hashCode();
	}
	
	/**
	 * display word and line numbers
	 * @return a string of word with line numbers
	 */
	public String toString() {
		Iterator<Integer> itr = lineNumbers.iterator();
		String display;
		if(itr.hasNext()) {
		 display = ""+word+": " + itr.next();
		}
		else display = ""+word+": ";
	
		while(itr.hasNext()) {

			display += ", "+itr.next();

		}
            display +="\n";
		return display;
		
	}
}
