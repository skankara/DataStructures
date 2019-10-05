import java.util.List;

 

 

public class RedBlackTreeHeight{

    

     private final int RED = 0;

     private final int BLACK = 1;

 

    

      private class RBTNode{

          

            int height=-1;

           String data = "";

           int color = BLACK;

           RBTNode left = empty, right = empty, parent = empty;;

          

            RBTNode(String val)

           {

                this.data=val;

           }

           public RBTNode getLeft()

           {

               

                return left;

           }

           public String getData()

           {

               

                return data;

           }

           public RBTNode getRight() {

               

                return right;

           }

     }

    

      private int compareStrings(String x, String y) {

           int compare=-1;

           if(x.compareTo(y)==0) {compare=2;}

           else if(x.compareTo(y)<0) {compare=0;}

           else {compare=1;}

          

            return compare;

     }

    

      private int compareIntegers(String x, String y) {

           int compare=-1;
           
           int i=Integer.parseInt(x);

           int j=Integer.parseInt(y);

           if(i==j) {compare=2;}

           else if(i<j) {compare=0;}

           else {compare=1;}

           return compare;

     }

    

      private int compareDoubles(String x, String y) {

           int compare=-1;

           double a=Double.parseDouble(x);

           double b=Double.parseDouble(y);

           if(a==b) {compare=2;}

           else if(a<b) {compare=0;}

           else {compare=1;}

           return compare;

     }

    

      private int compareNodes(String x, String y)

     {

           // System.out.println("Yes");

           int compare=-1;

          

//            compare=compareStrings(x, y);   //For Strings uncomment this line and comment the rest two

         compare=compareIntegers(x, y);  //For Integers uncomment this line and comment the rest two

//         compare=compareDoubles(x, y);  /For Doubles uncomment this line and comment the rest two

          

            return compare;

     }

    

      private final RBTNode empty = new RBTNode("empty");

         private RBTNode root = empty;

         private int maxHeight=0;

        

         private void insert(String s)

         {
        	
        	 RBTNode z = new RBTNode(s);
 	    	insertNode(z);
 	    	
 	    		z.height=z.parent.height+1;
 	    		
 	    	if(z.height>maxHeight && maxHeight<maxNode(root).height || maxHeight<minNode(root).height) 
 	    	{
 	    		maxHeight=z.height;
 	    	}
           

         }

        

         private void insertNode(RBTNode z)

         {

             RBTNode x = root;

             if (root == empty)

             {

                 root = z;

                 z.color = BLACK;

                 z.parent = empty;

             }

             else

             {

                 z.color = RED;

                 while (true)

                 {

                     if (compareNodes(z.data,x.data)==0)

                     {

                         if (x.left == empty)

                         {

                             x.left = z;

                             z.parent = x;

                             break;

                         }

                         else

                         {

                             x = x.left;

                         }

                     }

                     else if (compareNodes(z.data,x.data)==1||compareNodes(z.data,x.data)==2)

                     {

                         if (x.right == empty)

                         {

                             x.right = z;

                             z.parent = x;

                             break;

                         }

                         else

                         {

                             x = x.right;

                         }

                     }

                 }

                 insertFix(z);

             }

         }

        

         

         private void insertFix(RBTNode z)

         {

             while (z.parent.color == RED)

             {

                 RBTNode y = empty;

                 if (z.parent == z.parent.parent.left)

                 {

                     y = z.parent.parent.right;

                     if (y != empty && y.color == RED)

                     {

                         z.parent.color = BLACK;

                         z.color = BLACK;

                         z.parent.parent.color = RED;

                         z = z.parent.parent;

                         continue;

                     }

                     if (z == z.parent.right)

                     {

                         z = z.parent;

                         leftRotate(z);

                     }

                     z.parent.color = BLACK;

                     z.parent.parent.color = RED;

                     rightRotate(z.parent.parent);

                 }

                 else {

                     y = z.parent.parent.left;

                      if (y != empty && y.color == RED)

                      {

                         z.parent.color = BLACK;

                         y.color = BLACK;

                         z.parent.parent.color = RED;

                         z = z.parent.parent;

                         continue;

                     }

                     if (z == z.parent.left)

                     {

                         z = z.parent;

                         rightRotate(z);

                     }

                     z.parent.color = BLACK;

                     z.parent.parent.color = RED;

                     leftRotate(z.parent.parent);

                 }

             }

             root.color = BLACK;

         }

        

         

         void leftRotate(RBTNode z)

         {

             if (z.parent != empty)

             {

                 if (z == z.parent.left)

                 {

                     z.parent.left = z.right;

                 }

                 else

                 {

                     z.parent.right = z.right;

                 }

                 z.right.parent = z.parent;

                 z.parent = z.right;

                 if (z.right.left != empty)

                 {

                     z.right.left.parent = z;

                 }

                 z.right = z.right.left;

                 z.parent.left = z;

             }

             else

             {

                 RBTNode y = root.right;

                 root.right = y.left;

                 y.left.parent = root;

                 root.parent = y;

                 y.left = root;

                 y.parent = empty;

                 root = y;

             }

         }

 

         void rightRotate(RBTNode z)

         {

             if (z.parent != empty)

             {

                 if (z == z.parent.left)

                 {

                     z.parent.left = z.left;

                 }

                 else

                 {

                     z.parent.right = z.left;

                 }

                 z.left.parent = z.parent;

                 z.parent = z.left;

                 if (z.left.right != empty)

                 {

                     z.left.right.parent = z;

                 }

                 z.left = z.left.right;

                 z.parent.right = z;

             }

             else

             {

                 RBTNode y = root.left;

                 root.left = root.left.right;

                 y.right.parent = root;

                 root.parent = y;

                 y.right = root;

                 y.parent = z;

                 root = y;

             }

         }

 

        

         private RBTNode searchNode(RBTNode x, RBTNode y)

         {

         //System.out.println("S:R"+x.data+" "+y.data );

             if (root == empty)

             {

                 return null;

             }

 

             if (compareNodes(x.data,y.data)==0)

             {

                 if (y.left != empty)

                 {

                     return searchNode(x, y.left);

                 }

             }

             else if (compareNodes(x.data,y.data)==1)

             {

                 if (y.right != empty)

                 {

                     return searchNode(x, y.right);

                 }

             }

             else if (compareNodes(x.data,y.data)==2)

             {

                //System.out.println("Found"+x.data+" "+y.data );

                 return y;

             }

             //System.out.println("S:R"+x.data+" "+y.data );

             return null;

         }

        

         private boolean delete(String d)

         {

         RBTNode z = new RBTNode(d);

         return deleteNode(z);

        

         }

        

         

         boolean deleteNode(RBTNode z)

         {

             if((z = searchNode(z, root))==null)

                 return false;

             RBTNode x;

             RBTNode y = z;

             int y_original_color = y.color;

             if(z.left == empty)

             {

                 x = z.right; 

                 transplantNode(z, z.right); 

             }

             else if(z.right == empty)

             {

                 x = z.left;

                 transplantNode(z, z.left);

             }

             else

             {

                 y = minNode(z.right);

                 y_original_color = y.color;

                 x = y.right;

                 if(y.parent == z)

                 {

                     x.parent = y;

                 }

                 else

                 {

                     transplantNode(y, y.right);

                     y.right = z.right;

                     y.right.parent = y;

                 }

                 transplantNode(z, y);

                 y.left = z.left;

                 y.left.parent = y;

                 y.color = z.color;

             }

             if(y_original_color==BLACK)

                 deleteFix(x); 

             return true;

         }

        

         private RBTNode maxNode(RBTNode subRoot) {

         while(subRoot.right!=empty){

                subRoot = subRoot.right;

             }

             return subRoot;

               

           }

        

         private RBTNode minNode(RBTNode subRoot) {

         while(subRoot.left!=empty){

                subRoot = subRoot.left;

             }

             return subRoot;

               

           }

 

         void transplantNode(RBTNode x, RBTNode y)

         {

               if(x.parent == empty)

               {

                   root = y;

               }

               else if(x == x.parent.left)

               {

                   x.parent.left = y;

               }

               else

               {

                   x.parent.right = y;

               }

                y.parent = x.parent;

         }

 

 

           private void deleteFix(RBTNode x)

           {

                while(x!=root && x.color==BLACK)

                {

                      if(x==x.parent.left)

                      {

                           RBTNode y=x.parent.right;

                           if(y.color==RED)

                           {

                                 y.color=BLACK;

                                 x.parent.color=RED;

                                 leftRotate(x.parent);

                                 y=x.parent.right;

                           }

                           if(y.left.color==BLACK && y.right.color==BLACK)

                           {

                                 y.color=RED;

                                 x=x.parent;

                                 continue;

                           }

                           else if(y.right.color==BLACK)

                           {

                                 y.left.color=BLACK;  

                                 y.color=RED;

                                 rightRotate(y);

                                 y=x.parent.right;

                           }

                                 y.color=x.parent.color;

                                 x.parent.color=BLACK;

                                 y.right.color=BLACK;

                                 leftRotate(x.parent);

                                 x=root;

                          

                      }

                      else

                      {

                     RBTNode y = x.parent.left;

                     if(y.color == RED){

                         y.color = BLACK;

                         x.parent.color = RED;

                         rightRotate(x.parent);

                         y = x.parent.left;

                     }

                     if(y.right.color == BLACK && y.left.color == BLACK)

                     {

                         y.color = RED;

                         x = x.parent;

                         continue;

                     }

                     else if(y.left.color == BLACK)

                     {

                         y.right.color = BLACK;

                         y.color = RED;

                         leftRotate(y);

                         y = x.parent.left;

                     }

                         y.color = x.parent.color;

                         x.parent.color = BLACK;

                         y.left.color = BLACK;

                         rightRotate(x.parent);

                         x = root;

                      }

             }

             x.color = BLACK;

               

           }

 

           public void inorder()

          {

              inorder(root);

          }

           private void inorder(RBTNode r)

          {

              if (r != empty)

              {

                  inorder(r.getLeft());

                  System.out.print(r.getData() +" | ");

                  inorder(r.getRight());

              }

          }

          

           /*

           public void postorder()

          {

              postorder(root);

          }

          private void postorder(RBTNode r)

          {

              if (r != empty)

              {

                  postorder(r.getLeft());            

                  postorder(r.getLeft());

                  System.out.print(r.getData() +" | ");

              }

          }

           */

          public void implementRBT(List<Integer> ov,List<String> data)

          {
        	  
          int counter=0;

          long time=System.currentTimeMillis();

          for(int i=0;i<data.size();i++)

           {

                 //System.out.println("Data"+data.get(i));

                

                 switch(ov.get(i))

                 {

                 case 1://insert

                      insert(data.get(i));

                      counter++;

                      break;

                 case 0://delete

                      if(delete(data.get(i)))

                      {

                            counter--;
                           // maxHeight--;
                            //System.out.println("\n"+s+" Deleted from the Tree.");

                      }

                      else

                      {

                            //System.out.println("\nDelete object *"+data.get(i)+"* in Line " + i +" not found in the tree.");
                            
                      }

                      break;

                       

                 }

                 

                    System.out.println(i+" Tree Height = "+maxHeight);

          }

          long time1=System.currentTimeMillis()-time;

         // System.out.print("\nSorted Order : ");

                 //inorder();

                 //System.out.println("\nTree Height = "+maxHeight);

                 System.out.println("Nodes:"+counter);

                 System.out.println("Time Taken:"+time1+"ms");

          }

          

     }