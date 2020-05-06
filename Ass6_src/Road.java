/**
 * 
 * @author pengl
 *Assignment 6
 */
public class Road implements Comparable<Road> {

	
	Town source, destination;
	int degrees;
	String name;
	
	/**
	 * constructor
	 * @param source
	 * @param destination
	 * @param degrees
	 * @param name
	 */
	
	Road(Town source, Town destination, int degrees, String name){
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
		this.name = name;
	}
	
	/**
	 * constructor
	 * @param source
	 * @param destination
	 * @param name
	 */
	Road(Town source, Town destination, String name){
		this.source = source;
		this.destination = destination;
		this.degrees = 1;
		this.name = name;
	}
	
	/**
	 * compare two road objects
	 * @return an integer
	 */
	@Override
	public int compareTo(Road o) {
		
		return this.name.compareTo(o.name);
	}
	
	/**
	 * check if a vertex is included
	 * @param town
	 * @return true if it is included
	 */
	public boolean contains(Town town) {
		return source.getName().equals(town.getName()) || destination.getName().equals(town.getName());
	}

	/**
	 * check if two object are equal
	 * @return true if they are
	 */
	 public boolean equals(Object r) {
	        Road temp = (Road) r;

	       if ((temp.destination.equals(this.destination) && temp.source.equals(this.source)) || 
	       (temp.destination.equals(this.source) && temp.source.equals(this.destination)))
	       return true;
	       else return false;
	 }

	 /**
	  * print out all varibles
	  * @return all varibles
	  */
	@Override
	public String toString() {
		return "Road [source=" + source + ", destination=" + destination + ", degrees=" + degrees + ", name=" + name
				+ "]";
	}

	/**
	 * get source
	 * @return source
	 */
	public Town getSource() {
		return source;
	}

	/**
	 * set sorce
	 * @param source
	 */
	public void setSource(Town source) {
		this.source = source;
	}

	/**
	 * get destination
	 * @return destination
	 */
	public Town getDestination() {
		return destination;
	}

	/**
	 * set destination
	 * @param destination
	 */
	public void setDestination(Town destination) {
		this.destination = destination;
	}

	/**
	 * get weight
	 * @return weight
	 */
	public int getDegrees() {
		return degrees;
	}

	/**
	 * set weight
	 * @param degrees
	 */
	public void setDegrees(int degrees) {
		this.degrees = degrees;
	}

	/**
	 * get name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	 
}
