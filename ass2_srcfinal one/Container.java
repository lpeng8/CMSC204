/**
 * 
 * @author lpeng8
 *
 */
public class Container  implements ContainerInterface {
    MyStack<DonationPackage> container;
    /**
     * constructor
     */
	public Container() {
		container = new MyStack<>(5);
	}
	/**
	 * constructor
	 * @param size
	 */
	public Container(int size) {
		container = new MyStack<>(size);
	}
	/**
	 * @return true if add a package successfully
	 */
	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		if(container.isFull())
			throw new ContainerException("The container is full");
		else
		{
			container.push(dPackage);
			return true;
		}
		
	}
    /**
     *@return the package that is been removed
     */
	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {
		if(container.isEmpty())
			throw new ContainerException("The container is Empty");
		else {
			return  container.pop();
		}
		
	}
   /**
    *@return an array of DonaionPackage
    */
	@Override
	public DonationPackage[] toArrayPackage() {
		
		
		Object[]temp = container.toArray();
		DonationPackage[] dArray = new DonationPackage[temp.length];
		for(int i = 0; i < dArray.length; i++) {
			dArray[i] =(DonationPackage) temp[i]; 
					
		}
		return dArray;
		
	}
	
	

}
