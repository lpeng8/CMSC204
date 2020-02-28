
public class Volunteer extends VolunteerLine {
    String name;
    
    public Volunteer() {
    	name = "";
    }

    public Volunteer(String name) {
    	this.name = name;
    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	
    
}
