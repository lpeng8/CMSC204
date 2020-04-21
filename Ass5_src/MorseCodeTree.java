import java.util.ArrayList;


/**
 * Assignment5
 * @author pengl
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root;

	/**
	 * default constructor
	 */
	public MorseCodeTree() {

		buildTree();

	}

	
/**
 * building a tree in four levels
 */
	public void buildTree() {

		root = new TreeNode<String>("");

		
		insert(".", "e");
		insert("-", "t");


		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

		
/**
 * get root
 * @return root
 */
	public TreeNode<String> getRoot(){

		return root;

	}

/**
 * insert a node into tree
 * @return this object
 */
	public MorseCodeTree insert(String code, String letter) {

		

		addNode(root,code,letter);

		

		return this;

	}

	/**
	 * fetch a node in a tree
	 * @return the data of node
	 */
	public String fetchNode(TreeNode<String> root, String code) {

		String letter;
		if(code.length()<=1) {

			if(code.equals("."))
				return root.leftc.data;

			else
				return root.rightc.data;

		}
		else {

			if(code.charAt(0) == '.')
				letter = fetchNode(root.leftc, code.substring(1));
			else 
				letter = fetchNode(root.rightc, code.substring(1));
		}
		
		return letter;
	}


/**
 * call recusive method fetchNode and fetch the data
 * @return the data of node
 */
	public String fetch(String code) {
		return fetchNode(root, code);
	}

/**
 * add a node
 */
	public void addNode(TreeNode<String> root, String code, String letter) {

		if(code.length() == 1) {

			if(code.charAt(0) == '.') {

				root.leftc = new TreeNode<String>(letter);

			}else if(code.charAt(0) == '-'){

				root.rightc = new TreeNode<String>(letter);

			}

		} else {

			if(code.charAt(0) == '.')
				addNode(root.leftc, code.substring(1),letter);

			else if(code.charAt(0) == '-')
				addNode(root.rightc, code.substring(1), letter);
		}
	}

	
/**
 * a recusive method that traverses a tree in LNR order
 * 
 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {

		if(root.leftc != null)
			LNRoutputTraversal(root.leftc,list);

		list.add(root.data);

		if(root.rightc != null)
		   LNRoutputTraversal(root.rightc,list);

	}

/**
 * set a new node
 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;			
	}
/**
 * test if a tree is built correctly
 * @return an arraylist of linked tree in LNR traversal order.
 */
	public ArrayList<String> toArrayList() {

		
		ArrayList<String> toArr = new ArrayList<String>();
		LNRoutputTraversal(root, toArr);	

		
		return toArr;

	}

	
/**
 * do not implement
 */
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
/**
 * do not implement
 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	

}