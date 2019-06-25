// ********************************************************************************
/**
* Class for main. Reads a file of random numbers and writes two files using a 
      quick sort and a shell sort algorithm. 

* @authors Derek Holsapple, Conner Botte, Edwin Hernandez
* @version 5/09/2019

* rhubarb: noun, a quarrel or squabble.

* “Every strike brings me closer to the next home run.”  
*  Babe Ruth ( 03/06/1895 - 08/16/1948 )
*/
// ********************************************************************************

import java.io.*;
import java.util.*;

public class DerekHolsapple_ConnerBotte_EdwinHernandez_06 extends Sorting {

   // Scanner to read to the file
   private static Scanner scan;
   
// ********************************************************************************
/**
   * Method main
   
   * The main method reads a file, converts the file into a integer array, and 
         sorts the array with quick sort and shell sort.  After the sort the 
         results are written to individual sorting files
      
   * @param INPUT_FILE       String, path of file being read.
   
   * @param integers         Integer[], Store input data from the file

   */
// ********************************************************************************

   public static void main(String[] args) throws IOException {
   
      // Input file path
      String INPUT_FILE = "2050 Project 06_Input.txt";
   
      // Output file path
      String OUTPUT_FILE_SHELL = "DerekHolsapple_ConnerBotte_EdwinHernandez_06" +
                                    "_Output1.txt";
      String OUTPUT_FILE_QUICK = "DerekHolsapple_ConnerBotte_EdwinHernandez_06" +
                                    "_Output2.txt";
   
      int[] unsortedData;    // Array to store the unsorted data
      int[] shellSortArray;  // Array to store the shell sorted data
      int[] quickSortArray;  // Array to store the quick sort data

      // Deposit the unsorted data from file into the int array
      unsortedData = fileToIntArray( INPUT_FILE );
      
      // Process the unsorted array with shell sort and quick sort
      shellSortArray = shellSort( unsortedData ) ;
      quickSortArray = quickSort( unsortedData , 0 , ( unsortedData.length - 1 ) );
   
      // Output the processed sorted numbers into files
      writeFile( OUTPUT_FILE_SHELL , shellSortArray );
      writeFile( OUTPUT_FILE_QUICK , quickSortArray ); 
     
   } // End main 
      
// ********************************************************************************
   /**
   * fileToIntArray
   
   * Method to count the number of lines in the file and store the content
       into an int array.
       
   * @param filePath,   - String of the file path to be read
   
   * @return integers,  - IntegerArray containing each line of the 
                              file as an element
   */

   public static int[] fileToIntArray( String filePath ) {   
   
         // Open the file and read content
         openFile( filePath );
         
         // Count the number of lines in the file to determine array length
         int elementNumber = 0;
         
         while ( scan.hasNextLine() ) {
         
            elementNumber++;
            scan.nextLine();
         
            } // End while
         
         // Reset scanner to add elements to the array
         openFile( filePath );
         
         int [] array = new int[elementNumber];
         
         int i = 0;
         while( scan.hasNextInt() ) {      
         
            array[i] = scan.nextInt();
            i++;
         
          } // End for
          
         // Close the input file
         closeFile();
          
         return array;
   
        } // End fileToIntArray
    
// ********************************************************************************
   /**
   * writeFile
   
   * Method to write a integer array to a file.

   *@param fileName,   -String of the file name to be created
      
   *@param array,      -Integer[] array of integers to be written to the file
    
   */   
   
   public static void writeFile( String filename, int[] array ) throws IOException{
    
     // Create a buffer read to write files
     BufferedWriter outputWriter = null;
     outputWriter = new BufferedWriter( new FileWriter( filename ) );
     
     // Loop the file 
     for ( int i = 0; i < array.length; i++ ) {
   
       // Convert the integer to a string for readability of the file
       outputWriter.write( Integer.toString( array[ i ] ) );
       outputWriter.newLine();
       
     } // End for
     
     outputWriter.flush();  
     outputWriter.close(); 
      
   } // End writeFile
   
// ********************************************************************************
   /**
   * openFile
   
   * Method to open the file.
   
   *@param fileName,  -String of the file name with a .txt extentsion
   
   */
   
   public static void openFile( String fileName ) {

        try{
        scan = new Scanner( new File( fileName ) );
            } // End try
      
        catch ( Exception e ) {
          System.out.println( "Could not Find File" );
            } // End catch
        } // End openFile

// ********************************************************************************
   /**
   * closeFile
   
   * Method to close the file.
   
   */
   
     public static void closeFile() {
     
        scan.close();
        
      } // End closeFile
      
// ********************************************************************************
   
} // End DerekHolsapple_ConnerBotte_EdwinHernandez_06 class
