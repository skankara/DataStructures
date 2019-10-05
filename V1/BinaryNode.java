

public class BinaryNode {
	
	BinaryNode(Comparable theKey) {
        key = theKey;
        left = right = null;
        height = 0;
    }

    Comparable key;          // The data in the node
    BinaryNode left;         // Left child
    BinaryNode right;        // Right child
    int height ;
}
