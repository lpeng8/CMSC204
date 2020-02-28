/**
 * 
 * @author lpeng8
 *
 */
public class DonationManager implements DonationManageInterface {

	
   VolunteerLine v = new VolunteerLine();
   Container c = new Container();
   RecipientLine r = new RecipientLine();
   DonationPackage d = new DonationPackage();
   Volunteer v1 = new Volunteer();
   Recipient r1 = new Recipient();
   /**
    * @return true if the add a package successfully
    */
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		
		
			return c.loadContainer(dPackage);
		}
	

    /**
     *@return true if add a volunteer successfully
     */
	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		return this.v.addNewVolunteer(v);
		
	}
    /**
     * @return true if add a recipient successfully
     */
	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		
			
			return this.r.addNewRecipient(r); 
		}
		
	
   /**
    * @return 0 if donate a package
    */
	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		
		v1 =v.volunteerTurn();
		r1= r.recipientTurn();
		d= c.removePackageFromContainer();
		return 0;
	}
    /**
     *@return an array of DonationPackage
     */
	@Override
	public DonationPackage[] managerArrayPackage() {
		
		
		return c.toArrayPackage();
	}
    /**
     * @return an array of Volunteer
     */
	@Override
	public Volunteer[] managerArrayVolunteer() {
	
		return v.toArrayVolunteer();
	}
    /**
     * @return an array of recipient
     */
	@Override
	public Recipient[] managerArrayRecipient() {
		return r.toArrayRecipient();
	}
	/**
	 * @return a string that prints out the information of delivery;
	 */
	@Override
	public String toString() {
		return "Package " + d + " has delievered to "+ r1 +" by "+ v1; 
	}

}
