

import java.util.Comparator;

public class BinaryTree<T extends Comparable<T>> {

	private Node_BST<T> root;
	private Comparator<T> comparator;

	public BinaryTree() {
		root = null;
		comparator = null;
	}

	public BinaryTree(Comparator<T> comp) {
		root = null;
		comparator = comp;
	}

	private int compare(T x, T y) {
		if (comparator == null)
			return x.compareTo(y);
		else
			return comparator.compare(x, y);
	}
	/* Adding elements into binary Search Tree */

	public void add(T l_data) {
		root = add(root, l_data);
	}
	// Add
	public Node_BST<T> add(Node_BST<T> l_node, T insert) {
		if (l_node == null) {
			return new Node_BST<T>(insert);
		}
		if (insert.compareTo(l_node.data) == 0) {
			return l_node;
		} else if (insert.compareTo(l_node.data) < 0) {
			//System.out.println("in left : "+insert);
			l_node.left = add(l_node.left, insert);
		} else {
			//System.out.println("in right : "+ insert);
			l_node.right = add(l_node.right, insert);
		}

		return l_node;
	}
	
	//Find/Search
	
	public boolean Find(T search)
	{
		return Find(root, search);
	}
	public boolean Find(Node_BST<T> l_node, T search)
	{
		if(l_node == null)
		{
			return false;
		}
		else if(search.compareTo(l_node.data) == 0)
		{
			return true;
		}
		else if (search.compareTo(l_node.data) < 0) {
			return Find(l_node.left,search) ;
		} else {
			return Find(l_node.right,search) ;
		}
	}
	
	// Delete
	
	public void delete(T delete_element, int line_num)
	{
		root = delete(root,delete_element,  line_num);
	}
	
	public Node_BST<T> delete(Node_BST<T> l_parent, T delete_element, int line_num)
	{
		if(l_parent == null)
		{
			throw new RuntimeException("delete object " + delete_element +" in Line " + line_num + " not found in the tree.");
		}
		else if(delete_element.compareTo(l_parent.data) < 0)
		{
			l_parent.left = delete(l_parent.left, delete_element, line_num);
		}
		else if(delete_element.compareTo(l_parent.data) > 0)
		{
			l_parent.right = delete(l_parent.right, delete_element,line_num);
		}
		else
	      {
	         if (l_parent.left == null) return l_parent.right;
	         else
	         if (l_parent.right == null) return l_parent.left;
	         else
	         {
	         // get data from the rightmost node in the left subtree
	            l_parent.data = getData(l_parent.left);
	         // delete the rightmost node in the left subtree
	            l_parent.left =  delete(l_parent.left, l_parent.data,line_num) ;
	         }
	      }
		return l_parent ;
	}
	
	private T getData(Node_BST<T> l_parent)
	   {
	      while (l_parent.right != null) l_parent = l_parent.right;

	      return l_parent.data;
	   }
	
	// Height
		
	public int height()
	{
      return height(root);
	}
	private int height(Node_BST<T> p)
	{
      if(p == null) return -1;
      else
      return 1 + Math.max( height(p.left), height(p.right));
	}

	
	// TEsting
	public void preOrderTraversal() {
		preOrderHelper(root);
	}

	private void preOrderHelper(Node_BST r) {
		if (r != null) {
			System.out.print(r + " ");
			preOrderHelper(r.left);
			preOrderHelper(r.right);
		}
	}
	
	public void inOrderTraversal()
	   {
		//System.out.println("root : "+ root);
	      inOrderHelper(root);
	   }
	   private void inOrderHelper(Node_BST r)
	   {
	      if (r != null)
	      {
	         inOrderHelper(r.left);
	         System.out.print(r+" ");
	         inOrderHelper(r.right);
	        // System.out.print("r.r : "+ r+" ");
	      }
	   }
	/*
	 * /* End of code to add Binary search Tree Start of code to Search for element
	 * in Binary Search Tree
	 * 
	 * public boolean containsNode(String key) { return containsNodeRecursive(root,
	 * key); }
	 * 
	 * private boolean containsNodeRecursive(Node_bst current, String key) { if
	 * (current == null) { return false; } if (key.compareTo(current.key) == 0) {
	 * return true; } return (key.compareTo(current.key) < 0) ?
	 * containsNodeRecursive(current.left, key) :
	 * containsNodeRecursive(current.right, key); }
	 * 
	 * End of code to search for element in Binary Search Tree
	 * 
	 * Start of code to delete an element form Binary Search Tree public void
	 * delete(String key) { root = deleteRecursive(root, key); }
	 * 
	 * private Node_bst deleteRecursive(Node_bst current, String key) { if (current
	 * == null) { return null; }
	 * 
	 * if (key.compareTo(current.key) == 0) {
	 * 
	 * Case 1 : When a node has no children if (current.left == null &&
	 * current.right == null) { return null; } Case 2 : a node has exactly one child
	 * if (current.right == null) { return current.left; }
	 * 
	 * if (current.left == null) { return current.right; }
	 * 
	 * String smallestValue = findSmallestValue(current.right); current.key =
	 * smallestValue; current.right = deleteRecursive(current.right, smallestValue);
	 * return current; // Node to delete found // ... code to delete the node will
	 * go here } if (key.compareTo(current.key) < 0 ) { current.left =
	 * deleteRecursive(current.left, key); return current; }
	 * 
	 * current.right = deleteRecursive(current.right, key); return current; }
	 * 
	 * private String findSmallestValue(Node_bst root) { if (root.left == null)
	 * return root.key; else return findSmallestValue(root.left); } End of code to
	 * delete an element from Binary Search Tree
	 * 
	 * Checking complete data in the tree
	 * 
	 * public void traversePreOrder(Node_bst node) { if (node != null) {
	 * System.out.print(" " + node.key); traversePreOrder(node.left);
	 * traversePreOrder(node.right); } }
	 */

	/* End of Checking complete data in the tree */
}
