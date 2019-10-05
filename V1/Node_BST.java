

public class Node_BST<T>
{
   public T data;
   public Node_BST<T> left, right;

   public Node_BST(T data, Node_BST<T> l, Node_BST<T> r)
   {
      left = l; right = r;
      this.data = data;
   }

   public Node_BST(T data)
   {
      this(data, null, null);
   }

   public String toString()
   {
      return data.toString();
   }
} //end of Node

