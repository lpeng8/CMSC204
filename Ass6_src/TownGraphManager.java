import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Assignment 6
 * @author pengl
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {

	private Graph graph = new Graph();
	
	/**
	 * add roads
	 * @return true it is added
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town t1, t2;
		boolean added = false;
		t1 = new Town(town1); t2 = new Town(town2);
		if( graph.addEdge(t1, t2, weight, roadName) != null)
			added = true;
		return added;
	}

	/**
	 * get road
	 * @return return the road's name 
	 */
	@Override
	public String getRoad(String town1, String town2) {
		Town t1, t2;
		t1 = new Town(town1); t2 = new Town(town2);
		
		return graph.getEdge(t1, t2).getName();
	}

	/**
	 * add a vertex
	 * @return true if added
	 */
	@Override
	public boolean addTown(String v) {
		Town t1;
		t1 = new Town(v); 
	
		return graph.addVertex(t1);
	}

	/**
	 * get a vertex
	 * @return a object of Town
	 */
	@Override
	public Town getTown(String name) {
		Town t1;
		t1 = new Town(name); 
		for(Town t: graph.vertexSet()) {
			if(t.equals(t1))
				return t;
		}
		return null;
	}

	/**
	 * check if a vertex is included
	 * @return true if it is
	 */
	@Override
	public boolean containsTown(String v) {
		Town t1;
		t1 = new Town(v); 
		
		return graph.containsVertex(t1);
	}

	/**
	 * check if a road connection is included
	 * @return true if it is
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town t1,t2;
		t1 = new Town(town1); 
		t2 = new Town(town2);
		return graph.containsEdge(t1, t2);
	}

	/**
	 * get all roads in a arraylist
	 * @return string arraylist of roads
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> temp = new ArrayList<>();
		for(Road r : graph.edgeSet())
			temp.add(r.getName());
		Collections.sort(temp);
		return temp;
	}

	/**
	 * deleta a road connection
	 * @return true if it is deleted
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1,t2;
		t1 = new Town(town1); 
		t2 = new Town(town2);
		int degrees = 0;
		String roadName="";
		boolean delete = false;
		for(Road r : graph.edgeSet()) {
			if(r.contains(t1) && r.contains(t2))
				degrees = r.getDegrees();
			roadName = r.getName();
		}
	   if( graph.removeEdge(t1, t2, degrees, roadName) != null)
		   delete = true;
		return delete;
	}

	/**
	 * detele a town
	 * @return true if it is deleted
	 */
	@Override
	public boolean deleteTown(String v) {
		Town t1;
		t1 = new Town(v); 
		
		return graph.removeVertex(t1);
	}

	/**
	 * get a string arraylist of towns
	 * @return arraylist of all towns 
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> temp = new ArrayList<>();
		for(Town t : graph.vertexSet())
			temp.add(t.getName());
		Collections.sort(temp);
		return temp;
	}

	/**
	 * get the shortestpath between two towns
	 * @return a arraylist of the path
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town t1,t2;
		t1 = new Town(town1); 
		t2 = new Town(town2);
		return graph.shortestPath(t1, t2) ;
	}
	/**
	 * add all towns in a file into a graph
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void populateTownGraph(File file) 

            throws FileNotFoundException, IOException {

        Scanner input = new Scanner(file);

        String text = "";

        while (input.hasNextLine()) {

            text += input.nextLine() + " ";

        }

        input.close();

        String[] roads = text.split(" ");
        String[][] description = new String[roads.length][];

        

        for (int i = 0; i < description.length; i++) {

            

            description[i] = new String[4];

            description[i][0] = roads[i].split(";")[0].split(",")[0];
            description[i][1] = roads[i].split(";")[0].split(",")[1];
            description[i][2] = roads[i].split(";")[1];
            description[i][3] = roads[i].split(";")[2];

            addTown(description[i][2]);
            addTown(description[i][3]);
            addRoad(description[i][2], description[i][3], 

            Integer.parseInt(description[i][1]), description[i][0]);

        }

    }

}
