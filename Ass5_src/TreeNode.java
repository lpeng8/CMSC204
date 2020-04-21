/**
 * Assgiment 5
 * @author pengl
 *
 * @param <T>
 */

public class TreeNode<T> {


	protected T data;	
	protected TreeNode<T> leftc;	
	protected TreeNode<T> rightc;

	
/**
 * create a new tree node
 * @param dataNode
 */
	public TreeNode (T dataNode) {	

		data = dataNode;
		leftc = rightc = null;
	}
/**
 * make a deep copy of tree
 * @param node
 */
public TreeNode (TreeNode<T> node) {

		this.data = node.data;
		this.leftc = node.leftc;
		this.rightc = node.rightc;
	}
/**
 * get the data of now
 * @return data	
 */
	public T getData() {

		return data;

	}


	

}