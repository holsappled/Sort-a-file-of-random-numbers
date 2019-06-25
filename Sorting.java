/**
* Class to sort a Integer Array with various different sorting algorithms
*  
* @authors Derek Holsapple, Conner Botte, Edwin Hernandez
* @version 5/09/2019
*/

import java.util.*;

// ********************************************************************************

public class Sorting {

// ********************************************************************************
   /**
   * shellSort
   
   * Method to sort an Integer array with a shell sort algorithm
   
   * @return X,         -Integer[] that has been sorted with shell sort
   
   * @param X,          -Integer[] of unsorted integers                           
   */ 
      public static int[] shellSort( int[] X ) {
      
    	  int n = X.length; 
    	  
          // Start with a big gap, then reduce the gap 
          for (int gap = n / 2; gap > 0; gap /= 2) 
          { 
              for (int i = gap; i < n; i += 1) 
              { 
            	  // Elements that have been sorted will be placed in
            	  //  X[ i ], and saved under temp with their given position 
            	  //  in [ i ]
                  int temp = X[ i ]; 
  
                  // Shift earlier gap-sorted elements up until 
                  // the correct location for a[i] is found 
                  int j; 
                  for ( j = i; j >= gap && X[j - gap] > temp; j -= gap ) 
                      X[ j ] = X[ j - gap ]; 
    
                  // Put temp ( the original a[ i ] ) in its correct 
                  // location  
                  X[ j ] = temp; 
              } 
          }  
      
      return X;
      
      } // End shellSort
      
          
      
      
// ********************************************************************************
   /**
   * quickSort
   
   * Method to sort an Integer array with a quick sort algorithm
   
   * Recursively sorts array, updating after each sort
   
   * @return arr,        -Integer[] that has been sorted with quick sort
   
   * @param arr,         -Integer[] of unsorted integers        

   * @param first,       -Integer, first entry in array

   * @param last,        -Integer, last entry in array       
   */       
      
      public static int[] quickSort(int arr[], int first, int last) {
    	    if ( first < last ) {
          
    	    	//Stores position of pivot
    	      int partitionIndex = partition(arr , first , last);
    	 
            //Stores left side of pivot
    	      quickSort( arr , first, partitionIndex - 1 ); 
            //Stores right side of pivot
    	      quickSort( arr , partitionIndex + 1 , last ); 
            
    	    }//end if
          
			return arr;
         
    	}//end quickSort

// ********************************************************************************
      
   /**
   * Partition method takes last element in array and uses it as pivot

   * then checks elements and swaps them if smaller than pivot.

   * @param  arr,      -Integer[] of unsorted integers 

   * @param first		  -Integer, first entry in arr

   * @param last		  -Integer, last entry in arr

   * @return i			  -Integer, pivot point 
   */
      private static int partition( int arr[] , int first , int last ) {
    	  
    	    int pivot = arr[ last ]; // Set pivot to last element
    	    int i = ( first - 1 ); 
              
    	   /**
    	    * Sorts array, putting elements less than pivot to the left
    	    *    and elements greater than pivot to the right
    	    */
    	    for ( int j = first; j < last; j++ ) { 
    	    	
    	        if ( arr[ j ] <= pivot ) {
    	            i++;
    	           
    	            int swapTemp = arr[ i ]; // Swap values less than pivot with 
    	            arr[ i ] = arr[ j ];	   // Those greater than pivot
    	            arr[ j ] = swapTemp;
    	            
    	        } // End if
    	    
    	    } // End for
    	 
    	    int swapTemp = arr[ i + 1 ]; // Sort pivot value
    	    arr[ i + 1 ] = arr[ last ];
    	    arr[ last ] = swapTemp;
    	 
    	    return i + 1;  // Return position of pivot
          
      } // End partition
      
// ********************************************************************************

} // End class Sorting