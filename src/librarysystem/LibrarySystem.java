/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarysystem;
import Books.Books;
import BorrowingSystem.BooksSorting;
import Books.SearchBooks;
//import BorrowingSystem.BookWaitingList;
import BorrowingSystem.BorrowBook;
import BorrowingSystem.Borrowing;
import FileWriteAndRead.*;
import BorrowingSystem.SearchStudents;
import Books.Students;
import BorrowingSystem.StudentsSorting;
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
        SearchStudents searchStudents = new SearchStudents();
        ArrayList<Students> students = searchStudents.getStudents();
        
        InputUtils myInput = new InputUtils();
                
        boolean exit = false;
        boolean searchBookExit = false;
        boolean listBooksExit = false;
        boolean searchStudentExit = false;
        boolean listStudentExit = false;
        boolean borrowBookExit = false;
        
        while(!exit){
        
            System.out.println("Welcome to CCT library management system!");
            System.out.println("1.Menu");
            System.out.println("2.Search for a specific book by title and/or author name.");
            System.out.println("3.List all books by title and/or author name alphabetical order.");
            System.out.println("4.Search for a specific student by name and/or ID.");
            System.out.println("5.List all students by alphabetical name and/or ID order.");
            System.out.println("6.Register that a student has borrowed a book.");
            System.out.println("7.If a book is borrowed and another student wants to borrow it, allow the user to add that reader to a\n" +
"waiting list (queue).");
            System.out.println("8.Register that a student has returned a book.");
            System.out.println("9.If a book is returned and has a waiting queue, display to the user the next student waiting for that\n" +
"book.");
            System.out.println("10.For a specific student, list the books that they have borrowed.");
            System.out.println("11.exit\n***********************");
            //main menu
            switch(myInput.getUserInt(1, 11)){ //invoke InputUtils.getUserInt method to give user a range of options
                case 1:
                    break;
                case 2:
                    while(!searchBookExit){
                        System.out.println("Please enter a number to choose to search books by title or author name.");
                        System.out.println("1.Search books by title\n2.Search books by author name\n3.Menu");
                        switch(myInput.getUserInt(1,3)){
                            //-----1st function----
                            case 1:
                                String bookTitleInput = myInput.getUserText("Search books by title\nWhich book would you like to search?");
                                //Search by book title
                                System.out.println(searchBooks.linearSearch(books, bookTitleInput, 1));
                                //Search Book Title, and shows up information (if Book Title exist)
                                break;
                            case 2:
                                String authorFnameInput = myInput.getUserText("Search books by author name\nWhich author name would you like to search? Please only enter first name");
                                //Search by author name
                                System.out.println(searchBooks.linearSearch(books,authorFnameInput,2));
                                break;
                            case 3:
                                searchBookExit = true;//jump out this switch-case and go back to menu
                                break;
                            }
                        }
                    searchBookExit = false;
                    //set false again,otherwise we can't access this page again,if we had left and want to go back
                    break;
                    //case 2 break
                case 3:
                    BooksSorting bs = new BooksSorting();
                    //-----2nd function
                    while(!listBooksExit){
                        
                        System.out.println("Please enter a number to choose list all books by title or author name alphabetical order");
                        System.out.println("1.list all books by title alphabetical order\n2.list all books by author name alphabetical order\n3.Menu");
                        switch(myInput.getUserInt(1,3)){
                            
                            case 1:
                                System.out.println(bs.bookSorting(books,1)); //sorting by book title
                                break;
                            case 2:
                                System.out.println(bs.bookSorting(books, 2));//sorting by author
                                break;
                            case 3:
                                listBooksExit = true;
                                break;
                            }
                        }
                    listBooksExit = false;
                    //set false again,otherwise we can't access this page again,if we had left and want to go back
                    break;
                    //case 3 break
                case 4:
                    //3rd function-----------------student part
                    InputUtils myInput2 = new InputUtils();
                    while(!searchStudentExit){
                        System.out.println("Please enter a number to choose to search for a specific student by name or ID");
                        System.out.println("1.search student by name\n2.search student by ID\n3.Menu");
                        switch(myInput.getUserInt(1,3)){
                            case 1:
                                String searchByName = myInput.getUserText("Which student would you like to search? please enter student name.");
                                String nameLinear = searchStudents.linearSearchStudents(students, searchByName);
                                System.out.println(nameLinear); //search students by name
                                break;
                            case 2:
                                int searchById = myInput2.getUserInt("Which student would you like to search? please enter student ID.");
                                int idBinary = searchStudents.binarySearch(students, searchById);
                                if(idBinary == -1){
                                    System.out.println("Student not Found");
                                } else {
                                    System.out.println(students.get(idBinary));
                                }
                                break;
                            case 3:
                                searchStudentExit = true;
                                break;
                            }
                        }   
                    searchStudentExit = false;
                    break;
                case 5:
                    //-----4th function --
                    StudentsSorting sSorting = new StudentsSorting();
                    while(!listStudentExit){
                        System.out.println("Please enter a number to choose List all students by alphabetical name or ID order.");
                        System.out.println("1.list all students by name alphabetical order\n2.list all students by ID alphabetical order\n3.Menu");
                        switch(myInput.getUserInt(1,3)){
                            case 1:
                                System.out.println(sSorting.studentsSorting(students)); //list student by alphabetical name order
                                break;
                            case 2:
                                System.out.println(students);//list student by id
                                //don't forget to modified this part
                                break;
                            case 3:
                                listStudentExit = true;
                                break;
                        }
                    }
                    
                    listStudentExit = false;
                    break;
                case 6:
                    //---5th function: testing Borrow book function----
                    BorrowBook borrowBook = new BorrowBook();
                    FileWriteAndRead.clearFile("borrow_list"); //clear file data every time before execute
                    while(!borrowBookExit){
                        System.out.println("Would you like to borrow a book or print out borrowing list");
                        System.out.println("1.Borrow a book\n2.Print out borrowing list\n3.Menu");

                        switch(myInput.getUserInt(1,3)){
                            case 1:
                                System.out.println("which student wants to borrow a book? Please enter student ID");
                                int studentId = myInput.getUserInt(1,5000);
                                System.out.println("which book would you like to borrow? Please enter book ID");
                                int bookId = myInput.getUserInt(1,500);
                                borrowBook.borrowBooks(books, students, studentId, bookId);
                                break;
                            case 2:
                                System.out.println(borrowBook.getBorrowing());
                                break;
                            case 3:    
                                borrowBookExit = true;
                                break;
                        }
                    }
                    //store data to file after finished book register
                    FileWriteAndRead.writeToFile("borrow_list", borrowBook.getBorrowing().toString());//store into borrow_list.txt file
                    borrowBookExit = false;
                    break;
//                case 7:
//                    BorrowBook bsw = new BorrowBook();
//                    bsw.generateWaitingList(bsw.getBorrowing(), bookId);

//        BorrowBook test = new BorrowBook();
//        System.out.println("writing to book");
//        test.borrowBooks(books, students, 5, 3);
//        test.borrowBooks(books, students, 13, 5);
//        test.borrowBooks(books, students, 12, 5);
//        test.borrowBooks(books, students, 11, 6);
//        System.out.println(test.getBorrowing()); //list all borrowed book
////        System.out.println(test.getBorrowing().get(0));//get a specific borrowed book
//        FileWriteAndRead.writeToFile("borrow_list", test.getBorrowing().toString());//store into borrow_list.txt file
//        
                    
                case 11:
                    exit=true;
                    break;
            
            }
        }



        
        System.out.println("*********only for testing, in case feel confusing with the above and below outputs");
        
        
        System.out.println("*********only for testing, in case feel confusing with the above and below outputs");
        
        
        
        System.out.println("*********only for testing, in case feel confusing with the above and below outputs");
        

//        //---6th function: testing waitinglist
//        BookWaitingList waitingTest = new BookWaitingList(); 
//        System.out.println(waitingTest.generateWaitingList(test.getBorrowing(), 1));
//        System.out.println(waitingTest.getWaitingList());
        
    }
    
}
