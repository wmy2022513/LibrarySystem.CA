/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystem;
import Books.Books;
import Books.BooksSorting;
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
        
        SearchBooks searchBooks = new SearchBooks();
        ArrayList<Books> books = searchBooks.getBooks();
        
        InputUtils myInput = new InputUtils();
        String userInput = myInput.getUserText("Which book would you like to search?");

        System.out.println(searchBooks.linearSearch(books, userInput)); 
        //Search Book Title, and shows up information (if Book Title exist) 
        //-----1st function----
        BooksSorting bs = new BooksSorting();
        System.out.println(bs.bookSorting(books));
        //-----2nd function --display by alphabetical order (sorting and implement Comparator
        
    }
    
}
