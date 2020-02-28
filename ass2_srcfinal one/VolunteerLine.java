/**
 * 
 * @author lpeng8
 *
 */
public class VolunteerLine implements VolunteerLineInterface {
   
	MyQueue <Volunteer> VLine;
	/**
	 * constructor
	 * @param size
	 */
	public VolunteerLine(int size) {
		  VLine= new MyQueue<>(size);
	}
	/**
	 * constructor
	 */
	public VolunteerLine() {
		VLine = new MyQueue<>(5);
	}
	
	/**
	 * @return true if add a volunteer successfully
	 */
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		if(VLine.isFull())
		throw new VolunteerException ("Volunteer queue is full");
		else
		{
			VLine.enqueue(v);
			return true;
		}
	}
    /**
     * @return the volunteer been turned
     */
	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		if(VLine.isEmpty())
		throw new VolunteerException("Volunteer queue is empty");
		else {
			Volunteer temp = VLine.dequeue();
			VLine.enqueue(temp);
			return temp;
		}
		
	}
    /**
     * @return true if the volunteer line is empty
     */
	@Override
	public boolean volunteerLineEmpty() {
		if(VLine.isEmpty())
			return true;
		return false;
	}
    /**
     *@return an array of volunteer
     */
	@Override
	public Volunteer[] toArrayVolunteer() {
		Object []temp= VLine.toArray();
		Volunteer[] array = new Volunteer[temp.length];
		for(int i = 0; i<temp.length; i++)
		{
			array[i]= (Volunteer)temp[i];
		}
		return array;
	}

}
