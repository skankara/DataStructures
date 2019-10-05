import java.util.*;

 

 

public class SkipList

{

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

          

            compare=compareStrings(x, y);   //For Strings uncomment this line and comment the rest two

//         compare=compareIntegers(x, y);  //For Integers uncomment this line and comment the rest two

//         compare=compareDoubles(x, y);  /For Doubles uncomment this line and comment the rest two

          

            return compare;

     }

    

     public static class SLNode

     {

       public String data;

       public Integer value;

       public int pos;     

       public SLNode topNode, bottomNode, leftNode, rightNode;

 

       public static String negative = new String("000");

       public static String positive = new String("999999999");

 

       public SLNode(String k, Integer v)

       {

          data = k;

          value = v;

          topNode = bottomNode = leftNode = rightNode  = null;

       }

 

       public Integer getValue()

       {

         return value;

       }

 

       public String getData()

       { return data;

       }

 

       public Integer setValue(Integer val)

       {

         Integer oldValue = value;

         value = val;

         return oldValue;

       }

 

       public boolean eNode(Object o)

       {

         SLNode ent;

 

         try

         {

           ent = (SLNode) o;  

         }

         catch (ClassCastException ex)

         {

           return false;

         }

 

         return (ent.getData() == data) && (ent.getValue() == value);

       }

 

       public String toString()

       {

         return "(" + data + "," + value + ")";

       }

     }

    

  public SLNode head;   

  public SLNode tail;   

 

  public int value;       

 

  public int height;      

  public Random r;  

 

  public SkipList()    

  {

     SLNode start, end;

     start = new SLNode(SLNode.negative, null);

     end = new SLNode(SLNode.positive, null);

     head = start;

     tail = end;

     start.rightNode = end;

     end.leftNode = start;

     value = 0;

     height = 0;

     r = new Random();

  }

 

  public int size()

  {

    return value;

  }

  public boolean isEmpty()

  {

    return (value == 0);

  }

  public SLNode searchNode(String k)

  {

     SLNode p;

     p = head;

     while ( true )

     {

        while ( p.rightNode.data != SLNode.positive &&

           compareNodes(p.rightNode.data,k)== 0 || compareNodes(p.rightNode.data,k)== 2 )

     {

           p = p.rightNode;

     }

     if ( p.bottomNode != null )

        { 

           p = p.bottomNode;

        }

        else

        break; 

     }

     return(p);       

  }

 

  public Integer getNode(String k)

  {

     SLNode p;

 

     p = searchNode(k);

 

     if ( compareNodes(k,p.getData())==2 )

        return(p.value);

     else

        return(null);

  }

 

  public SLNode insertAfterAbove(SLNode x, SLNode y, String data)

  {

     SLNode z;

 

     z = new SLNode(data, null);

 

   

     z.leftNode = x;

     z.rightNode = x.rightNode;

     z.bottomNode = y;

 

     y.rightNode.leftNode = z;

     y.rightNode = z;

     y.topNode = z;

 

     return(z);

  }

 

  public void InsertNode (String data, Integer v)

  {

     SLNode x, y;

     int       i;

 

     x = searchNode(data);

 

     if ( compareNodes(data, x.getData()) ==2 )

     {

        Integer old = x.value;

 

     x.value = v;

 

   

     }

 

     y = new SLNode(data, v);

     y.leftNode = x;

     y.rightNode = x.rightNode;

     x.rightNode.leftNode = y;

     x.rightNode = y;

 

     i = 0;                

 

     while ( r.nextDouble() < 0.5 )

     {

    

        if ( i >= height )

     {

           SLNode start, end;

 

        height = height + 1;

 

           start = new SLNode(SLNode.negative,null);

           end = new SLNode(SLNode.positive,null);

  

        start.rightNode = end;

        start.bottomNode  = head;

 

        end.leftNode = start;

        end.bottomNode = tail;

 

        head.topNode = start;

        tail.topNode = end;

 

        head = start;

        tail = end;

     }

     while ( x.topNode == null )

     {

        x = x.leftNode;

     }

     x = x.topNode;

     SLNode z;

            

     z = new SLNode(data, null); 

     z.leftNode = x;

     z.rightNode = x.rightNode;

     z.bottomNode = y;

            

     x.rightNode.leftNode =z;

     x.rightNode = z;

     y.topNode = z;

 

        y = z;       

 

        i = i + 1;   

 

     }

 

     value = value + 1;

 

    

  }

  public Boolean deleteNode(String data)

  {

       SLNode p=searchNode(data);

    

       if (compareNodes(p.data,data)!=2) {

            

             return(false);

             }

      

       SLNode temp1=p,temp2;

       for(int i=0;i<height;i++)

       {

             try {

                      temp2=p.topNode; 

                      temp1.leftNode.rightNode = temp1.rightNode;

                      temp1.rightNode.leftNode = temp1.leftNode;

                      temp1=temp2;

                } catch (Exception e) {

                     

                      //e.printStackTrace();

                }

            

          

         

       }

     return(true);

  }

 

  public void printList()

  {

     String s = "";

 

     SLNode z;

 

     z = head;

 

     while ( z.bottomNode != null )

        z = z.bottomNode;

 

     while ( z != null )

     {

        s = coloumnNodes( z );

     System.out.println(s);

 

        z = z.rightNode;

     }

  }

 

 

  public String coloumnNodes( SLNode z )

  {

     String s = "";

 

     while ( z != null )

     {

        s = s + " " + z.data;

 

        z = z.topNode;

     }

 

     return(s);

  }

 

  public void implementSkipList(List<String> data)

  {

     int counter=0;

     long time=System.currentTimeMillis();

     for(int i=0;i<data.size();i++)

      {

            //System.out.println("Data"+data.get(i));

           String s = data.get(i).substring(2, (data.get(i).length()));

           //System.out.println("S:"+s);

           switch(Character.getNumericValue(data.get(i).charAt(0)))

            {

           case 1://insert

                InsertNode(s,i);

                counter++;

                break;

           case 0://delete

                if(deleteNode(s)==true)

                 {

                      counter--;

                      //System.out.println("\n"+s+" Deleted from the Tree.");

                }

                else

                {

                      System.out.println("\nDelete object *"+s+"* in Line " + i +" not found in the List.");

                }

                break;

                 

            }

           

      }

     long time1=System.currentTimeMillis()-time;

          printList();

         System.out.println("Inserted:"+counter);

         System.out.println("Time Taken:"+time1+"ms");

        

  }

 

 

 

}