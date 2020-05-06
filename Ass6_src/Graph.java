import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author pengl
 *Assignment 6
 */
public class Graph implements GraphInterface<Town, Road>{

	final int NoEdge = Integer.MAX_VALUE;
	final int NoPath = Integer.MAX_VALUE;
	
	private ArrayList<String> shortestPath = new ArrayList<>();
	private Set<Town> towns = new HashSet<>();
	private Set<Road> roads = new HashSet<>();
	private Town destination;
    private int endTown;
    
    /**
     * get edge of two vertices
     * @return an edge
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		Road road = null;

        for (Road r : roads) {
            if (r.contains(sourceVertex) && r.contains(destinationVertex)){
                road = r;
           }
        }

        return road;
	}

	/**
	 * add a edge between two vertices
	 * @return the edge been added
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
	    if(sourceVertex == null || destinationVertex == null)
	    	throw new NullPointerException();
	    
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(road);
		return road;
	}

	/**
	 * add a vertex
	 * @return true if added
	 */
	@Override
	public boolean addVertex(Town v) {
		if(v == null)
			throw new NullPointerException();
		if(!towns.contains(v)) {
		towns.add(v);
		return true;
		}
		else return false;
	}

	/**
	 * check if an edge exists
	 * @return true if contains
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		
		for(Road temp : roads) {
			if(temp.contains(sourceVertex) && temp.contains(destinationVertex))
				return true;
		}
		return false;
	}

	/**
	 * check if an vertex exists
	 * @return true if the vertex exists
	 */
	@Override
	public boolean containsVertex(Town v) {
		for(Town temp : towns) {
			if(temp.getName().equals(v.getName()))
				return true;
		}
		return false;
	}
 
	/**
	 * get a set of roads
	 * @return  all roads
	 */
	@Override
	public Set<Road> edgeSet() {
		
		return roads;
	}

	/**
	 * find edges of a vertex
	 * @return edges of a vertex
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> temp = new HashSet<>();
				for(Road r : roads) {
					if(r.contains(vertex)) 
						temp.add(r);
				}
		return temp;
	}

	/**
	 * remove a edge from graph
	 * @return the removed edge
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Set<Road> temp = new HashSet<>();
		Road road = null;
		for(Road r : roads) {
			if(r.contains(destinationVertex)&& r.contains(sourceVertex) 
					&&(weight >-1) && description !=null)
				road = r;
		}
		if (roads.remove(road))
			return road;
		else return null;
	}

	/**
	 * remove a vertex
	 * @return true if removed
	 */
	@Override
	public boolean removeVertex(Town v) {
		
		return towns.remove(v);
	}

	/**
	 * get a set of all vertices
	 * @return all vertices
	 */
	@Override
	public Set<Town> vertexSet() {
		
		return towns;
	}

	/**
	 * find the shortestPath bewteen two Vertex
	 * @return an arraylist of string that describe paths
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
      
		     destination = destinationVertex;
	        dijkstraShortestPath(sourceVertex);

	        String sPath = "";

	        int totalMi = 0;

	        for (int i = 0; i < shortestPath.size() - 1; i++) {
               
	            Town source = new Town(shortestPath.get(i));
	            Town dest = new Town(shortestPath.get(i + 1));
	            Road road = getEdge(source, dest);
              
             
              
	            totalMi += road.getDegrees();

	            sPath += source + " via " + road.getName() + " to " + dest 

	                    + " " + road.getDegrees() + " mi;";
              

	        }

	        shortestPath.clear();

	        for (String temp : sPath.split(";")) {

	            shortestPath.add(temp);

	        }

	        shortestPath.add("Total mi: " + totalMi + " mi");

	        return shortestPath;

    
	}
	
	/**
	 * implement dijkstraShortestPath method
	 * 
	 */
	 @Override
	    public void dijkstraShortestPath(Town sourceVertex) {

	        shortestPath.clear();
	        Town[] allTowns = new Town[towns.size()];
	        
	        int index = 0;
	        
	        for (Town t : towns) {

	            allTowns[index] = new Town(t);
	            index++;
	        }        

	        int[][] adjacencyMatrix = new int[towns.size()][towns.size()];       

	        for (int i = 0; i < adjacencyMatrix.length; i++) {

	            for (int j = 0; j < adjacencyMatrix[i].length; j++) {

	                if (i == j || !containsEdge(allTowns[i], allTowns[j])) {

	                    adjacencyMatrix[i][j] = 0;

	                } else {

	                    int weight = getEdge(allTowns[i], allTowns[j]).getDegrees();
	                    adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = weight;

	                }
	            }
	        }
	        
	        int startTown = 0;
	        for (Town t : allTowns) {

	            if (!t.equals(sourceVertex)) {

	                startTown++;

	            } else {

	                break;

	            }

	        }

	        endTown = 0;

	        for (Town t : allTowns) {

	            if (!t.equals(destination)) {

	                endTown++;

	            } else {

	                break;

	            }
	        }

	        int numTowns = adjacencyMatrix[0].length; 
	        int[] smallestWeights = new int[numTowns];

	        boolean[] added = new boolean[numTowns];

	        for (int townIndex = 0; townIndex < numTowns; townIndex++) {

	            smallestWeights[townIndex] = NoEdge;
	            added[townIndex] = false;

	        }
	        smallestWeights[startTown] = 0;
	        int[] minLengthsPath = new int[numTowns];
	        minLengthsPath[startTown] = -1;

	        

	        for (int i = 1; i < numTowns; i++) {

	            int nearestTown = -1;

	            int smallestWeight = NoEdge;

	            for (int townIndex = 0; townIndex < numTowns; townIndex++) {

	                if (!added[townIndex] && 

	                        smallestWeights[townIndex] < smallestWeight) {

	                    nearestTown = townIndex;

	                    smallestWeight = smallestWeights[townIndex];

	                }

	            }

	            added[nearestTown] = true;

	            for (int townIndex = 0; townIndex < numTowns; townIndex++) {

	                int roadDist = adjacencyMatrix[nearestTown][townIndex]; 

	                if (roadDist > 0 && 

	                        ((smallestWeight + roadDist) < smallestWeights[townIndex])) {

	                    minLengthsPath[townIndex] = nearestTown;

	                    smallestWeights[townIndex] = smallestWeight + roadDist;
	                }
	            }           
	        }
	      addToPathArrayList(endTown, minLengthsPath); 

	    }
	 /**
	  * add all vertecis into an array
	  * @param sourceVertex
	  * @param minLengthsPath
	  */
	 private void addToPathArrayList(int sourceVertex, int[] minLengthsPath) {

	        

	        if (sourceVertex == -1) { 
	            return; 

	        } 

	        addToPathArrayList(minLengthsPath[sourceVertex], minLengthsPath); 

	        int townIndex = 0;

	        for (Town t : towns) {

	            if (townIndex == sourceVertex) {

	                shortestPath.add(t.getName()); 

	            }

	            townIndex++;

	        }

	    } 


	
	

}
