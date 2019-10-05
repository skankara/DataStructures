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


public class MyMainV2 {
	
	public static void main(String[] args) throws IOException, ItemNotFoundException {
		// TODO Auto-generated method stub
		//System.out.println("IN Main");
		int dataStructure = 4;
		try {
            // Parse the string argument into an integer value.
			dataStructure = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException nfe) {
            
            System.out.println("The first argument must be an integer.");
            System.exit(1);
        }
		
		String fileName = args[1]+".txt"; 
		
		
			
		ArrayList<String> l_inputValue=new ArrayList<String>();
		ArrayList<Integer> l_input_operationValue = new ArrayList<Integer>();
		
		
		File file = new File(fileName);  
			      
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {
			
			 
			String[] splited = sc.nextLine().split("\\s+");
		   
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
				//Comment the below line when the Double is Double		
					//MyMainV2.Hash_Table_Double(l_input_operationValue, l_inputValue);
				//Comment the below line when the input is Integer
					//MyMainV2.Hash_Table_Integer(l_input_operationValue, l_inputValue);
				//Comment the below line when the inputs are String
					//MyMainV2.Hash_Table_String(l_input_operationValue, l_inputValue);
				break;
			case 1://binarysearchtree
				//Comment the below line when the input is Double		
					//MyMainV2.Binary_S_tree_Double(l_input_operationValue,l_inputValue) ;
				//Comment the below line when the input is Integer
					//MyMainV2.Binary_S_tree_Int(l_input_operationValue,l_inputValue) ;
				//Comment the below line when the input is String
					//MyMainV2.Binary_S_tree_String(l_input_operationValue, l_inputValue);
				break;
			case 2://splaytree
				//Comment the below line when the input is Double		
					//MyMainV2.Splay_Tree_Double(l_input_operationValue, l_inputValue);
				//Comment the below line when the input is Integer
					//MyMainV2.Splay_Tree_Integer(l_input_operationValue, l_inputValue);
				//Comment the below line when the inputs are String
					//MyMainV2.Splay_Tree_String(l_input_operationValue, l_inputValue);
				break;
			case 3:System.out.println("Not Valid for SkipList");
				break;
			case 4://skiplist
				
			
				RedBlackTreeHeight rbt = new RedBlackTreeHeight();
				rbt.implementRBT(l_input_operationValue,l_inputValue);
				break; 
		}
		
	}
	
	public static void Binary_S_tree_String(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		BinaryTree<String> bt = new BinaryTree<String>();
		//LocalTime time = LocalTime.now(); 
		
		//System.out.println("Start time : "+ time);  
	   for(int i = 0; i<l_input_operationValue.size() ; i++)
	   {
		   if( l_input_operationValue.get(i) == 1 )
		   {
			   bt.add(l_inputValue.get(i));
			   
		   }
		   else if(l_input_operationValue.get(i) == 0)
		   {
			   bt.delete(l_inputValue.get(i));
		   } 
		   System.out.println("\n Height at each step : "+ bt.height);
	   }
	   System.out.println("\n Total Height of tree : "+ bt.height());
	   
	}
	public static void Binary_S_tree_Int(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		/*
		 * LocalTime time = LocalTime.now();
		 * 
		 * System.out.println("Start time : "+ time);
		 */
	   for(int i = 0; i<l_input_operationValue.size() ; i++)
	   {
		   if( l_input_operationValue.get(i) == 1 )
		   {
			   //System.out.println("Integer.parseInt(l_inputValue.get(i)) : "+ Integer.parseInt(l_inputValue.get(i)));
			   bt.add(Integer.parseInt(l_inputValue.get(i)));
			   
		   }
		   else if(l_input_operationValue.get(i) == 0)
		   {
			   bt.delete(Integer.parseInt(l_inputValue.get(i)));
		   } 
		   System.out.println("\n Height at each step : "+ bt.height);
	   }
	   System.out.println("\n Total Height of tree : "+ bt.height());
	}
	public static void Binary_S_tree_Double(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		BinaryTree<Double> bt = new BinaryTree<Double>();
		/*
		 * LocalTime time = LocalTime.now();
		 * 
		 * System.out.println("Start time : "+ time);
		 */
	   for(int i = 0; i<l_input_operationValue.size() ; i++)
	   {
		   if( l_input_operationValue.get(i) == 1 )
		   {
			   bt.add(Double.parseDouble(l_inputValue.get(i)));
			   
		   }
		   else if(l_input_operationValue.get(i) == 0)
		   {
			   bt.delete(Double.parseDouble(l_inputValue.get(i)));
		   } 
		   System.out.println("\n Height at each step : "+ bt.height);
	   }
	   System.out.println("\n Total Height of tree : "+ bt.height());
	}
	public static void Hash_Table_Integer(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		Hashset_operations<Integer> l_Hashset_operations = new Hashset_operations<Integer>();
		   
		   for(int i =0 ;i<l_input_operationValue.size() ; i++)
		   {
			   
			   l_Hashset_operations.hash(l_input_operationValue.get(i),Integer.parseInt(l_inputValue.get(i) ));
		   }
		   
	}
	public static void Hash_Table_Double(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		Hashset_operations<Double> l_Hashset_operations = new Hashset_operations<Double>();
		   
		   for(int i =0 ;i<l_input_operationValue.size() ; i++)
		   {
			   l_Hashset_operations.hash(l_input_operationValue.get(i),Double.parseDouble(l_inputValue.get(i) ));
		   }
	}
	
	public static void Hash_Table_String(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		Hashset_operations<String> l_Hashset_operations = new Hashset_operations<String>();
	   for(int i =0 ;i<l_input_operationValue.size() ; i++)
	   {
		   l_Hashset_operations.hash(l_input_operationValue.get(i),l_inputValue.get(i));
	   }
	}
	
	public static void Splay_Tree_String(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		SplayTree t = new SplayTree();
	    
	    Comparable key ;
	    for(int i =0 ; i<l_input_operationValue.size() ; i++)
	    {
	    	 if( l_input_operationValue.get(i) == 1 )
			   {
				   t.insert(l_inputValue.get(i));
				   System.out.println("\n height of the tree in each step : "+ t.height);
			   }
			   else if(l_input_operationValue.get(i) == 0)
			   {
				  t.remove(l_inputValue.get(i));
				  System.out.println("\n height of the tree in each step : "+ t.height);
			   } 
	    }
	    //t.inOrderTraversal();
	    System.out.println("\n Total height of the tree in each step : "+ t.height());
	}
	public static void Splay_Tree_Double(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		SplayTree t = new SplayTree();
	    
	    Comparable key ;
	    for(int i =0 ; i<l_input_operationValue.size() ; i++)
	    {
	    	 if( l_input_operationValue.get(i) == 1 )
			   {
				   t.insert(Double.parseDouble(l_inputValue.get(i)));
				   System.out.println("\n height of the tree in each step : "+ t.height);
			   }
			   else if(l_input_operationValue.get(i) == 0)
			   {
				   t.remove(Double.parseDouble(l_inputValue.get(i)));
				   System.out.println("\n height of the tree in each step : "+ t.height);
			   } 
	    }
	   // t.inOrderTraversal();
	    System.out.println("\nheight of the tree : "+t.height());
	}
public static void Splay_Tree_Integer(ArrayList<Integer> l_input_operationValue , ArrayList<String> l_inputValue)
	{
		System.out.println("in Splay tree");
		SplayTree t = new SplayTree();
	    
	    Comparable key ;
	    for(int i =0 ; i<l_input_operationValue.size() ; i++)
	    {
	    	 if( l_input_operationValue.get(i) == 1 )
			   {
				   t.insert(Integer.parseInt(l_inputValue.get(i)));
				   System.out.println("\n height of the tree in each step : "+ t.height);
			   }
			   else if(l_input_operationValue.get(i) == 0)
			   {
				   t.remove(Integer.parseInt(l_inputValue.get(i)));
				   System.out.println("\n height of the tree in each step : "+ t.height);
			   } 
	    }
	   // t.inOrderTraversal();
	    System.out.println("\n height of the tree : "+ t.height());
	}

}
