
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static java.time.temporal.ChronoUnit.SECONDS;

public class MyMainV1 {
	
	public static void main(String[] args) throws IOException, ItemNotFoundException {
		// TODO Auto-generated method stub
		//System.out.println("IN Main");
		
		int dataStructure = 0;
		try {
            // Parse the string argument into an integer value.
			dataStructure = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException nfe) {
            // The first argument isn't a valid integer.  Print
            // an error message, then exit with an error code.
            System.out.println("The first argument must be an integer.");
            System.exit(1);
        }
		
		String fileName = args[1]+".txt"; 
		
		ArrayList<String> l_inputValue=new ArrayList<String>();
		ArrayList<Integer> l_input_operationValue = new ArrayList<Integer>();
		ArrayList<String> data=new ArrayList<String>();
		
		File file = new File(fileName); 
		
		
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {
			String s = sc.nextLine() ;
			data.add(s);
			String[] splited = s.split("\\s+");
		    
		    int operation_value =  Integer.parseInt(splited[0]);
		    String key_value = "" ;
		    for(int i = 1;i<splited.length;i++)
		    {
		    	key_value = key_value + " "+splited[i];
		    }
		    
		    l_input_operationValue.add(operation_value);
		    l_inputValue.add(key_value.trim());
		    //System.out.println("operation_value : "+operation_value + " key_value : "+ key_value); 
		  } 
		
		switch(dataStructure) 
		{
			case 0://hashtable
				//Comment the below line when the Double is String		
					//MyMainV1.Hash_Table_Double(l_input_operationValue, l_inputValue);
				//Comment the below line when the input is String
					//MyMainV1.Hash_Table_Integer(l_input_operationValue, l_inputValue);
				//Comment the below line when the inputs are Integers
					//MyMainV1.Hash_Table_String(l_input_operationValue, l_inputValue);
				break;
			case 1://binarysearchtree
				//Comment the below line when the input is Double		
					//MyMainV1.Binary_S_tree_Double(l_input_operationValue,l_inputValue) ;
				//Comment the below line when the input is Integer
					//MyMainV1.Binary_S_tree_Int(l_input_operationValue,l_inputValue) ;
				//Comment the below line when the input is String
					//MyMainV1.Binary_S_tree_String(l_input_operationValue, l_inputValue);
				break;
			case 2://splaytree
				//Comment the below line when the input is String		
					//MyMainV1.Splay_Tree_Double(l_input_operationValue, l_inputValue);
				//Comment the below line when the input is String
					//MyMainV1.Splay_Tree_Integer(l_input_operationValue, l_inputValue);
				//Comment the below line when the inputs are Integers
					//MyMainV1.Splay_Tree_String(l_input_operationValue, l_inputValue);
				break;
			case 3://skiplist
				SkipList sl = new SkipList();
				sl.implementSkipList(data);
				break; 
			case 4://redblacktree
				RedBlackTree rbt = new RedBlackTree();
				rbt.implementRBT(data);
				break; 
		}
		
	}
	
	public static void Binary_S_tree_String(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		BinaryTree<String> bt = new BinaryTree<String>();
		LocalTime time = LocalTime.now(); 
		int counter = 0;
		System.out.println("Start time : "+ time);  
	   for(int i = 0; i<l_input_operationValue.size() ; i++)
	   {
		   counter ++ ;
		   if( l_input_operationValue.get(i) == 1 )
		   {
			   bt.add(l_inputValue.get(i));
			   
		   }
		   else if(l_input_operationValue.get(i) == 0)
		   {
			   bt.delete(l_inputValue.get(i),counter);
		   } 
	   }
	   LocalTime new_time = LocalTime.now(); 
	   
	   System.out.println("new_time : "+ new_time);
	   Duration.between(time, new_time).toMillis();
	   System.out.println("Total Time taken in milliseconds : "+  Duration.between(time, new_time).toMillis()  );
	  // bt.preOrderTraversal();
	   bt.inOrderTraversal();
	   System.out.println("\n Height : "+ bt.height());
	}
	public static void Binary_S_tree_Int(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		LocalTime time = LocalTime.now(); 
		int counter = 0;
		System.out.println("Start time : "+ time);  
		
	   for(int i = 0; i<l_input_operationValue.size() ; i++)
	   {
		   counter ++ ;
		   if( l_input_operationValue.get(i) == 1 )
		   {
			  
			   bt.add(Integer.parseInt(l_inputValue.get(i)));
			   
		   }
		   else if(l_input_operationValue.get(i) == 0)
		   {
				bt.delete(Integer.parseInt(l_inputValue.get(i)), counter);
		   } 
	   }
	   LocalTime new_time = LocalTime.now(); 
	   
	   System.out.println("new_time : "+ new_time);
	   Duration.between(time, new_time).toMillis();
	   System.out.println("Total Time taken in milliseconds : "+  Duration.between(time, new_time).toMillis()  );
	  // bt.preOrderTraversal();
	   bt.inOrderTraversal();
	   System.out.println("\n Height : "+ bt.height());
	}
	public static void Binary_S_tree_Double(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		BinaryTree<Double> bt = new BinaryTree<Double>();
		LocalTime time = LocalTime.now(); 
		int counter = 0;
		System.out.println("Start time : "+ time);  
	   for(int i = 0; i<l_input_operationValue.size() ; i++)
	   {
		   counter ++ ;
		   if( l_input_operationValue.get(i) == 1 )
		   {
			   bt.add(Double.parseDouble(l_inputValue.get(i)));
		   }
		   else if(l_input_operationValue.get(i) == 0)
		   {
			   bt.delete(Double.parseDouble(l_inputValue.get(i)),counter);
		   } 
	   }
	   LocalTime new_time = LocalTime.now(); 
	   
	   System.out.println("new_time : "+ new_time);
	   Duration.between(time, new_time).toMillis();
	   System.out.println("Total Time taken in milliseconds : "+  Duration.between(time, new_time).toMillis()  );
	  // bt.preOrderTraversal();
	   bt.inOrderTraversal();
	   System.out.println("\n Height : "+ bt.height());
	}
	public static void Hash_Table_Integer(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		Hashset_operations<Integer> l_Hashset_operations = new Hashset_operations<Integer>();
		int counter = 0;
		LocalTime time = LocalTime.now(); 
			
		   System.out.println("Start time for HashTable : "+ time); 
		   for(int i =0 ;i<l_input_operationValue.size() ; i++)
		   {
			   counter++ ;
			   l_Hashset_operations.hash(l_input_operationValue.get(i),Integer.parseInt(l_inputValue.get(i) ), counter);
				
		   }
		   LocalTime new_time = LocalTime.now(); 
		   System.out.println("End time for HashTable : "+ new_time); 
		   //System.out.println("Total Time taken For HashTable in milliseconds : "+  Duration.between(time, new_time).toMillis()  );
		   
		   //Testing 
		   l_Hashset_operations.printElements();
		   System.out.println("Total Time taken For HashTable in milliseconds : "+  Duration.between(time, new_time).toMillis()  );
	}
	public static void Hash_Table_Double(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		Hashset_operations<Double> l_Hashset_operations = new Hashset_operations<Double>();
		int counter = 0;
		LocalTime time = LocalTime.now(); 
			
		   System.out.println("Start time for HashTable : "+ time); 
		   for(int i =0 ;i<l_input_operationValue.size() ; i++)
		   {
			   counter++ ;
			   l_Hashset_operations.hash(l_input_operationValue.get(i),Double.parseDouble(l_inputValue.get(i) ),counter++);
				
		   }
		   LocalTime new_time = LocalTime.now(); 
		   System.out.println("End time for HashTable : "+ new_time); 
		   //System.out.println("Total Time taken For HashTable in milliseconds : "+  Duration.between(time, new_time).toMillis()  );
		   
		   //Testing 
		   l_Hashset_operations.printElements();
		   System.out.println("Total Time taken For HashTable in milliseconds : "+  Duration.between(time, new_time).toMillis()  );
	}
	
	public static void Hash_Table_String(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		Hashset_operations<String> l_Hashset_operations = new Hashset_operations<String>();
		   int counter =0 ;
		LocalTime time = LocalTime.now(); 
			
		   System.out.println("Start time for HashTable : "+ time); 
		   for(int i =0 ;i<l_input_operationValue.size() ; i++)
		   {
			   counter++ ;
			   l_Hashset_operations.hash(l_input_operationValue.get(i),l_inputValue.get(i),counter);
		   }
		   LocalTime new_time = LocalTime.now(); 
		   System.out.println("End time for HashTable : "+ new_time); 
		   //System.out.println("Total Time taken For HashTable in milliseconds : "+  Duration.between(time, new_time).toMillis()  );
		   
		   //Testing 
		   l_Hashset_operations.printElements();
		   System.out.println("Total Time taken For HashTable in milliseconds : "+  Duration.between(time, new_time).toMillis()  );
	}
	
	public static void Splay_Tree_String(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		SplayTree t = new SplayTree();
	    int counter = 0 ;
	    Comparable key ;
	    for(int i =0 ; i<l_input_operationValue.size() ; i++)
	    {
	    	counter++ ;
	    	 if( l_input_operationValue.get(i) == 1 )
			   {
				   t.insert(l_inputValue.get(i));
				   
			   }
			   else if(l_input_operationValue.get(i) == 0)
			   {
				   t.remove(l_inputValue.get(i),counter);
			   } 
	    }
	    t.inOrderTraversal();
	    System.out.println("\nheight of the tree : "+t.height());
	}
	public static void Splay_Tree_Double(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		SplayTree t = new SplayTree();
	    int counter  = 0;
	    Comparable key ;
	    for(int i =0 ; i<l_input_operationValue.size() ; i++)
	    {
	    	counter ++ ;
	    	 if( l_input_operationValue.get(i) == 1 )
			   {
				   t.insert(Double.parseDouble(l_inputValue.get(i)));
				   
			   }
			   else if(l_input_operationValue.get(i) == 0)
			   {
				   t.remove(Double.parseDouble(l_inputValue.get(i)),counter);
			   } 
	    }
	    t.inOrderTraversal();
	    System.out.println("\nheight of the tree : "+t.height());
	}
	public static void Splay_Tree_Integer(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		SplayTree t = new SplayTree();
		int counter  = 0;
	    Comparable key ;
	    for(int i =0 ; i<l_input_operationValue.size() ; i++)
	    {
	    	counter++;
	    	 if( l_input_operationValue.get(i) == 1 )
			   {
				   t.insert(Integer.parseInt(l_inputValue.get(i)));
				   
			   }
			   else if(l_input_operationValue.get(i) == 0)
			   {
				   t.remove(Integer.parseInt(l_inputValue.get(i)),counter);
			   } 
	    }
	    t.inOrderTraversal();
	    System.out.println("\n height of the tree : "+ t.height());
	}

}
