

public class Node_BST<T>
{
   public T data;
   public Node_BST<T> parent, left, right;
   int height = 0;

   public Node_BST(T data, Node_BST<T> l, Node_BST<T> r, Node_BST<T> p, int height)
   {
      left = l; right = r;
      parent = p ;
      this.data = data;
      this.height = height ;
   }

   public Node_BST(T data)
   {
      this(data, null, null, null,0);
   }

   public String toString()
   {
      return data.toString();
   }
} //end of Node

