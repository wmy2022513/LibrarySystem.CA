/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileWriteAndClear;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author mikeyang
 */
public class FileWriteAndClear {
    
    
     public static void writeToFile(String filename,String valueToWrite){ //write method will be invoked in main code
        
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(filename, true)); ///use true to append
            
            myWriter.newLine();       // this creates a new line in the file
            
//            myWriter.write(Integer.toString(valueToWrite)); //modified:
            myWriter.write(valueToWrite);                    //modified for String acceptable
            myWriter.close(); //saves the changes
            
        }catch (Exception e) {
            
            System.out.println("Unable to write to file: " + filename);
        }
    }
     /**
      * This method is for clear all data of the pass in parameter
      * parameter is a string type, it is the file name of the text file
      * @param filename 
      */
    public static void clearFile(String filename){ 
        
        try{
            FileWriter fw = new FileWriter(filename, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        }catch(Exception e){
            System.out.println("Exception have been caught");
        }
    }
}
