

public class SplayTree {
	
	private BinaryNode root;

    public SplayTree() {
        root = null;
    }
    
    public void insert(Comparable key){
	BinaryNode n;
	int c;
	if (root == null) {
	    root = new BinaryNode(key);
	    return;
	}
	splay(key);
	if ((c = key.compareTo(root.key)) == 0) {
	    //	    throw new DuplicateItemException(x.toString());	    
	    return;
	}
	n = new BinaryNode(key);
	if (c < 0) {
	    n.left = root.left;
	    n.right = root;
	    root.left = null;
		} else {
		    n.right = root.right;
		    n.left = root;
		    root.right = null;
		}
		root = n;
    }
    
 
   public void remove(Comparable key, int counter){
	BinaryNode x;
	splay(key);
	find(key,counter);
	// Now delete the root
	if (root.left == null) {
	    root = root.right;
	} else {
	    x = root.right;
	    root = root.left;
	    splay(key);
	    root.right = x;
	}
   }
   
   
   public Comparable find(Comparable key, int counter) {
	if (root == null) return null;
	splay(key);
       if(root.key.compareTo(key) != 0)
    	   {
    	   		throw new RuntimeException("delete object " + key +" in Line " +  counter + " not found in the tree.");
    	   	//return null;
    	   }
       return root.key;
   }

   
   public boolean isEmpty() {
       return root == null;
   }
   
   
   
   private static BinaryNode header = new BinaryNode(null); // For splay
   
   private void splay(Comparable key) {

	   BinaryNode k, l, m, n;
		k = l = header;
		m = root;
		header.left = header.right = null;
		for (;;) {
		    if (key.compareTo(m.key) < 0) {
			if (m.left == null) break;
			if (key.compareTo(m.left.key) < 0) {
			    n = m.left;                            
			    m.left = n.right;
			    n.right = m;
			    m = n;
			    if (m.left == null) break;
			}
			l.left = m;                                 
			l = m;
			m = m.left;
		    } else if (key.compareTo(m.key) > 0) {
			if (m.right == null) break;
			if (key.compareTo(m.right.key) > 0) {
			    n = m.right;                           
			    m.right = n.left;
			    n.left = m;
			    m = n;
			    if (m.right == null) break;
			}
			k.right = m;                                
			k = m;
			m = m.right;
		    } else {
			break;
		    }
		}
		k.right = m.left;                                   
		l.left = m.right;
		m.left = header.right;
		m.right = header.left;
		root = m;
		
		
	}
   
   public void inOrderTraversal()
   {
	//System.out.println("root : "+ root);
      inOrderHelper(root);
   }
   private void inOrderHelper(BinaryNode r)
   {
      if (r != null)
      {
         inOrderHelper(r.left);
         System.out.print(r.key+" ");
         inOrderHelper(r.right);
        // System.out.print("r.r : "+ r+" ");
      }
   }
   public int height()
	{
	   return height(root);
	}
	private int height(BinaryNode p)
	{
	     if(p == null) return -1;
	     else
	     return 1 + Math.max( height(p.left), height(p.right));
	}
   
}
