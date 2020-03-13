import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * 
 * @author pengl
 *assignment3
 * @param <T>
 */
public class BasicDoubleLinkedList<T>implements Iterable<T> {
    protected int size;
    protected Node t;
	protected Node h;
	/**
	 * empty constructor
	 */
	public BasicDoubleLinkedList()
	{   
		t = new Node(null,null,null);
		h = new Node(null,null,null);
		
		
		t.back = h;
		
		size = 0;
	}
	/**
	 * innner node class
	 * @author pengl
	 *
	 */
	public class Node
	{
		protected T data;
		protected Node next;
		protected Node back;
		public Node(T data, Node next, Node back)
		{
			this.data = data;
			this.next = next;
			this.back = back;
		}
		
	}
	/**
	 * implments iterator class
	 */
	@Override
	public ListIterator<T> iterator() {
		return new myIterator();
	}
		/**
		 * definition of iterator
		 * @author pengl
		 *
		 */
	public class myIterator  implements ListIterator <T>
	{
		Node current = h;
		Node last = t;
		@Override
		public boolean hasNext() {
			if(current.next != null)
				return true;
			return false;
		}
		@Override
		public T next() throws NoSuchElementException  {
			
			current = current.next;
			if(current == null) {
				throw new NoSuchElementException("there is no such element");
			}
			
			return current.data;
		}
		@Override
		
		public void add(Object arg0) {
		}
		@Override
		public boolean hasPrevious() {
			if(last.back != null) 
				return true;
			else
				return false;
			
		}
		@Override
		public int nextIndex() {
			
			return 0;
		}
		@Override
		public T previous() throws NoSuchElementException {
			last = last.back;
			if(last == null) {
				throw new NoSuchElementException("there is no such element");
			}
			return last.data;
		}
		@Override
		public int previousIndex() {
			
			return 0;
		}
		@Override
		public void set(Object e) {
		
			
		}
		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
	
	}
	/**
	 * add element as last element in list.
	 * @param data
	 * @return referrence of the object.
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node n = new Node(data, null,null);
		n.data = data;
		n.next = null;
		n.back = t.back;
		t.back.next = n;
		t.back = n;
		size++;
	
		return this;
	}
	/**
	 * add element as first element in list.
	 * @param data
	 * @return referrence of the object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Node n = new Node(data, null, null);
		n.next = h.next;
		if(size>0)
		{
		h.next.back = n;
		}
		else
		{
		t.back = n;
		}
		h.next = n;
		size++;
		
		return this;
	}
	/**
	 * get first element.
	 * @return data element
	 */
	public T getFirst() {
		if(size == 0)
		return null;
		else return h.next.data;
	}
	/**
	 * get last element
	 * @return data element
	 */
	public T getLast() {
		if(size == 0)
		return null;
		else return t.back.data;
	}
	/**
	 * get the size of list
	 * @return size 
	 */
	public int getSize() {
		return size;
	}
	/**
	 * remove element in list
	 * @param targetData
	 * @param comparator
	 * @return referrence of the object.
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Node q = h;
		Node p = h.next;
		
		while(p != null && !(comparator.compare(targetData, p.data)==0))
		{
			q= p;
			p=p.next;
			
		}
		if(size == 1)
		{
			t.back = h;
			h.next = null;
			size--;
		}
		if(p.back == null)
		{
			q.next = p.next;
			p.next.back = null;
			size--;
			return this;
		}
		if(p.next == null)
			{q.next = null;
		    t.back = q;
		    size--;
		    return this;
			}
		if(p != null)
		{
			q.next = p.next;
			p.next.back =p.back;
			size--;
			return this;
		}
		
		else return null;
	}
	/**
	 * delete the frist element and take it out from list
	 * @return data of deleted element.
	 */
	public T retrieveFirstElement() {
		if(size ==0)
			return null;
		Node p = h.next;
		if(size == 1) {
			h.next = null;
			t.back = h;
		}
		else {
			h.next = p.next;
		p.next.back = null;
		}
		size--;
		return p.data;
	}
	
	/**
	 * delete the last element and take it out from list
	 * @return data of deleted element
	 */
	public T retrieveLastElement() {
		if (size ==0)
		    return null;
		Node p = t.back;
		if(size ==1)
		{
		t.back = h;
		h.next = null;
		}
		else
		{
			t.back = p.back;
		p.back.next = null;
		}
		size--;
		return p.data;
		
	}
	/**
	 * put all data of the list into arraylist.
	 * @return
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> array = new ArrayList<T>(size);
		Node p = h.next;
		while(p!= null)
		{
			array.add(p.data);
			p = p.next;
		}
		return array;
	}

}
