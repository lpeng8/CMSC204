import java.util.ArrayList;

/**
 * Assignment 6
 * @author pengl
 *
 */
public class Town implements Comparable<Town>{

	private String name;
	private ArrayList<Town> adjacentTowns;
	
	/**
	 * constructor
	 * @param name
	 */
	Town(String name){
		this.name = name;
	}
	
	/**
	 * constructor
	 * @param templateTown
	 */
	Town(Town templateTown){
		this.name=templateTown.name;
	}
	
	/**
	 * compare two objects
	 * @return an integer
	 */
	@Override
	public int compareTo(Town arg0) {
		
		return this.name.compareTo(arg0.name);
	}

	/**
	 * check if two object are euqals
	 * @return true if they are
	 */
	public boolean equals(Object obj) {
	   Town temp = (Town) obj;
		return this.name.equals(temp.name) ;
	}
	
	/**
	 * get name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * get hashcode of name
	 * @return hashcode
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * @return a string of name
	 */
	public String toString() {
		return name;
	}
}
