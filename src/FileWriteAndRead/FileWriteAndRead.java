/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileWriteAndRead;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mikeyang
 */
public class FileWriteAndRead {
    
    /**
     * 
     * @param myFileName
     * @return read content from file ,
     * 
     */
    public static List<String> readFromFile(String myFileName, int capacity){

        List<String> myFile = new ArrayList<>();
        
        try{
        //must have a tr-catch because the file might not exist      
        Scanner myFileTmp = new Scanner(new FileReader(myFileName));
            //use .hasNext() to check to see if there is anything in the file. True/False.
            if (myFileTmp.hasNext()){
                //there is something in the file. Let's see what it is!
                String input = myFileTmp.nextLine(); 
                // It's a dummy, hold the contents which we don't want to put them inside the List(id,author_first_name...so on)
                for(int i=0;i<capacity;i++){
                    
                    myFile.add(myFileTmp.nextLine()); //adding datas to myFile
                }

            }
            else{
//                //file must be empty
                System.out.println("The file " + myFileName + " has no contents!");
            }
          
        }catch (Exception e){
            //error opening file
            System.out.println("Error - unable to find file " + myFileName);
        }
    return myFile;
}
    
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
}
