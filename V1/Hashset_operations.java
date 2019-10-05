

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Hashset_operations<T extends Comparable<T>> {
		
	HashSet<T> h = new HashSet<T>(); 
	
	public void hash(int operation_value, T Value, int counter )
	{
        if(operation_value == 1)
        {
        	 h.add(Value);
        }
        // Removing items from HashSet using remove() 
        if(operation_value == 0)
        {
        	if(h.contains(Value))
    		{
    		h.remove(Value); 
    		}
    	else
    	{
    		throw new RuntimeException("delete object "+Value+" in Line " + counter+ " not found in the tree.");
    	}
    	
    }

    } 
	
	public void printElements()
	{
		Iterator<T> i = h.iterator(); 
	    while (i.hasNext()) 
	        System.out.println(i.next());
	}
}
