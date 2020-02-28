
public class DonationPackage {
  String description;
  double weight;
  
  public DonationPackage() {
	  description="";
	  weight = 0.0;
  }
  public DonationPackage(String  d, double  w) {
	  
	  this.description=d;
	  this.weight = w;
  }
  public DonationPackage(String d) {
	  this.description = d;
	  
  }
 public String getDescription() {
	return description;
 }
 public void setDescription(String description) {
	this.description = description;
 }
 public double getWeight() {
	return weight;
 }
 public void setWeight(double weight) {
	this.weight = weight;
 }
 public boolean isHeavy() {
	 if(this.weight > 20)
		 return true;
	 else return false;
 }
@Override
public String toString() {
	return description;
}

  
}
