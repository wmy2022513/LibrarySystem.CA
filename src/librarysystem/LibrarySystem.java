/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystem;
import FileWriteAndRead.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mikeyang
 */
public class LibrarySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String myFileName = "MOCK_DATA.CSV";
        int capacity = 500;
        
        List<String> myFile = FileWriteAndRead.readFromFile(myFileName, capacity);
        
//        System.out.println(myFile);// check if read function is working

        
    }
    
}
