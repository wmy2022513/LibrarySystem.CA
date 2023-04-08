/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystem;
import Books.Books;
import Books.BooksSorting;
import Books.SearchBooks;
import FileWriteAndRead.*;
import Students.SearchStudents;
import Students.Students;
import Students.StudentsSorting;
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
        
        System.out.println("*********only for testing, in case feel confusing with the above and below outputs");
        
        BooksSorting bs = new BooksSorting();
        System.out.println(bs.bookSorting(books));
        //-----2nd function --display by alphabetical order (sorting and implement Comparator
        
        System.out.println("*********only for testing, in case feel confusing with the above and below outputs");
        
        //-----------------student part
        SearchStudents searchStudents = new SearchStudents();
        ArrayList<Students> students = searchStudents.getStudents();
        
        InputUtils myInput2 = new InputUtils();
        int searchInput = myInput2.getUserInt("Which student would you like to search? please enter student ID.");
        int idBinary = searchStudents.binarySearch(students, searchInput);
        if(idBinary == -1){
            System.out.println("Student not Found");
        } else {
            System.out.println(students.get(idBinary));
        }
        //-----3rd function -- by using binary search----------
        System.out.println("*********only for testing, in case feel confusing with the above and below outputs");
        //--------------------------
        StudentsSorting sSorting = new StudentsSorting();
        System.out.println(sSorting.studentsSorting(students));
        //-----4th function --
        
        
    }
    
}
