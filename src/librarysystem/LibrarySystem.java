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
        
        InputUtils myInput = new InputUtils();
        String userInput = myInput.getUserText("Which book would you like to search?");
//        new Books.SearchBooks(userInput);//Search Book Title, and shows up information (if Book Title exist) 

        SearchBooks searchBooksTest = new SearchBooks();
//        System.out.println(searchBooksTest.loadBooks()); //list all books details
        System.out.println(searchBooksTest.linearSearch(searchBooksTest.loadBooks(), userInput)); // search a specific book by query
//        searchBooksTest.linearSearch(searchBooksTest.loadBooks(), userInput);
//        searchBooksTest.printallsort(searchBooksTest.loadBooks());
    }
    
}
