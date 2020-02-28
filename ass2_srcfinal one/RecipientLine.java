/**
 * 
 * @author lpeng8
 *
 */
public class RecipientLine implements RecipientLineInterface {

	MyQueue <Recipient> RLine;
	/**
	 * default constructor
	 */
	public RecipientLine() {
		RLine = new MyQueue<>(5);
		}
	/**
	 * constructor
	 * @param size
	 */
	public RecipientLine (int size) {
		RLine = new MyQueue<>(size);
	}
	/**
	 * @return true is add a new recipient successfully
	 */
	@Override
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
	 if(RLine.isFull())
		 throw new RecipientException("Recipient queue is full");
	 else
	 {
	    RLine.enqueue(rc);
	    return true;
	 }
		
	}
    /**
     * @return the recipient been dequeued
     */
	@Override
	public Recipient recipientTurn() throws RecipientException {
		if(RLine.isEmpty())
			throw new RecipientException("Recipient queue is empty");
			else
			{
				return  RLine.dequeue();
			}
	}
    /**
     * @return true if  the recipient line is empty
     */
	@Override
	public boolean recipientLineEmpty() {
		if(RLine.isEmpty())
			return true;
		return false;
	}
    /**
     * @return an array of Recipient
     */
	@Override
	public Recipient[] toArrayRecipient() {
		Object[] temp = RLine.toArray();
		Recipient[] array = new Recipient[temp.length];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = (Recipient) temp[i];
		}
		return array;
	}

}
