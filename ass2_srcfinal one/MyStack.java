import java.util.ArrayList;
/**
 * 
 * @author lpeng8
 *
 * @param <T>
 */
public class MyStack <T> implements StackInterface<T> {

	ArrayList<T> data;
   private int top;
   private int size;
   
  /**
   * default constructor 
   */
   public MyStack() {
	   top = -1;
	   size = 5;
	   data=new ArrayList<>(5);
	   
   }
   /**
    * constructor
    * @param size
    */
   public MyStack(int size) {
	   top = -1;
	   this.size = size;
	   data=new ArrayList<>(size);
	 
   }
   /**
    * @return true if the stack is empty
    */
	@Override
	public boolean isEmpty() {
		if (top == -1)
			return true;
		else return false;
		
	}
    /**
     *@return true is the stack is full
     */
	@Override
	public boolean isFull() {
		if(top == size -1)
			return true;
		return false;
	}
    /**
     * @return the element that be poped
     */
	@Override
	public T pop() {
		 int topLocation;
		 if(top == -1) {
			 return null;
		 }
		 else {
			 topLocation = top;
			 top--;
			 return data.get(topLocation);
		 }
	
	}
    /**
     *@return the size of a stack
     */
	@Override
	public int size() {
		
		return size;
	}
    /**
     * @return true if push a node successfully
     */
	@Override
	public boolean push(T e) {
		if(top == size -1)
			return false;
		else {
			top++;
			data.add(e);
			return true;
		}
	
	}
    /**
     * @return a type of T array;
     */
	@Override
	public T[] toArray() {
        T[] array =(T[])new Object[top+1];
        for(int i = 0; i<array.length; i++)
        {
        	array[i] = (T)data.toArray()[i];
        }
		return array;
	}

}
