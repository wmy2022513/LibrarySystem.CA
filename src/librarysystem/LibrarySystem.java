/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystem;
import Books.SearchBooks;
import FileWriteAndRead.*;
import inpututils.InputUtils;
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
        
//        String myFileName = "MOCK_DATA.CSV";
//        int capacity = 500;
//        
//        List<String> myFile = FileWriteAndRead.readFromFile(myFileName, capacity);
//        System.out.println(myFile);// check if read function is working
//        -----above are not using
        
        InputUtils myInput = new InputUtils();
        String userInput = myInput.getUserText("Which book would you like to search?");
        new Books.SearchBooks(userInput);//Search BookName By Bookname, 
        
//        SearchBooks findBooks = new SearchBooks();
//        SearchBooks findBooks = new Books.SearchBooks();
//        findBooks.loadBooks().get(3).getId();
    }
    
}
