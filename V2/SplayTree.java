

public class SplayTree {
	
	private BinaryNode root;
	public int height = 0;

    public SplayTree() {
        root = null;
    }
    
    public void insert(Comparable key){
	BinaryNode l_newBinary;
	int constant;
	if (root == null) {
	    root = new BinaryNode(key);
	    return;
	}
	splay(key);
	if ((constant = key.compareTo(root.key)) == 0) {
	    return;
	}
	l_newBinary = new BinaryNode(key);
	if (constant < 0) {
		l_newBinary.left = root.left;
		l_newBinary.right = root;
	    root.left = null;
	    //height = height(l_newBinary) ;
		} else {
			l_newBinary.right = root.right;
			l_newBinary.left = root;
		    root.right = null;
		    
		}
		root = l_newBinary;
		height = height(root) ;
    }
    
 
   public void remove(Comparable key){
	BinaryNode x;
	splay(key);
	
	// Now delete the root
	if (root.left == null) {
	    root = root.right;
	} else {
	    x = root.right;
	    root = root.left;
	    splay(key);
	    root.right = x;
	}
	height = height(root) ;
   }
   
   public Comparable find(Comparable key) {
	if (root == null) return null;
	splay(key);
       if(root.key.compareTo(key) != 0) 
    	   {
    	   throw new RuntimeException("delete object in Line " + key + " not found in the tree.");
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
