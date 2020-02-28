import java.util.ArrayList;
/**
 * 
 * @author lpeng8
 *
 * @param <T>
 */
public class MyQueue <T> implements QueueInterface<T> {

	private  ArrayList <T> data;
	private int size;
	private int numOfNodes;
	private int front;
	private int rear;
	/**
	 * constructor
	 */
	public MyQueue() {
		size = 5;
		numOfNodes = 0;
		front = 0;
		rear = 0;
		data =  new ArrayList<T>(5);
	}
	/**
	 * constructor
	 * @param size
	 */
	public MyQueue(int size) {
		this.size = size;
		numOfNodes = 0;
		front = 0;
		rear = 0;
		data = new ArrayList<T>(size);
		
	}
	/**
	 * @return true if the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		if(numOfNodes == 0)
			return true;
		return false;
	}
    /**
     * 
     * @return true if the queue is empty
     */
	@Override
	public boolean isFull() {
		if(numOfNodes == size)
			return true;
		return false;
	}
     /**
      * @return T
      * dequeue
      */
	@Override
	public T dequeue() {
		int frontLocation;
		if(numOfNodes == 0)
			return null;
		else
		{
			frontLocation = front;
			front=(front + 1)% size;
			numOfNodes--;
			return data.get(frontLocation);
				
		}
	}

	@Override
	/**
	 * @return size of a queue
	 */
	public int size() {
		
		return size;
	}
     /**
      * return true if enqueue successfully
      */
	@Override
	public boolean enqueue(T e) {
		if(numOfNodes == size)
			return false;
		else
		{
			numOfNodes++;
			data.add(e);
			rear = (rear + 1) % size;
			return true;
		}
	
	}

	/**
	 * @return a type of T array;
	 */
	@Override
	public T[] toArray() {
		T[] array = (T[])new Object[numOfNodes];
		for(int i = 0; i<numOfNodes; i ++)
		{
			array[i]=(T)data.toArray()[front+i];
		}
		
		return array;
	}
	

}
