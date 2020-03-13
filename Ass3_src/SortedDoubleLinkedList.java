

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
/**
 * 
 * @author pengl
 *Assignment3
 * @param <T>
 */

public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T> implements Iterable<T>{
	
	Comparator<T> comparator;
	/**
	 * implement iterator class 
	 */
	@Override
	public ListIterator<T> iterator() {
		
		return super.iterator();
	}
	/**
	 * constrcutor for creating a empty sortedlinked  list asscioated with comparator.
	 * @param comparator2
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		this.comparator = comparator2;
		
	}
	/**
	 * add element into sorted position
	 * @param data
	 * @return
	 */
	public SortedDoubleLinkedList<T> add(T data){
		Node q =h;
	    Node  p= h.next;
		Node n = new Node(data, null,null);
		
		
		while(p  != null && comparator.compare(data, p.data)>0 )
		{   q = p;
		    p=p.next;
		}
		if(p != null)
		{
			
			n.back = p.back;
			p.back.next = n;
			n.next = p;
			p.back = n;
			size++;
			return this;
		}
		else if(q==null)
		{
			t.back = n;
			n.next = null;
			q.next = n;
			n.back = null;
			size++;
			return this;
		}
		else
		{
			t.back = n;
			n.next = null;
			q.next = n;
			n.back = q;
			size++;
			return this;
		}
	}
	/**
	 * no needed to implement, throws unsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * no needed to implement, throws unsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * call remove method from super class.
	 */
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator){
	return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
	}

}
