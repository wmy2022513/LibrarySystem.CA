/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entities.Books;
import entities.Students;
import factories.BorrowBook;
import factories.Searching;
import factories.Sorting;
import fileWriteAndClear.FileWriteAndClear;
import inpututils.InputUtils;
import java.util.ArrayList;

/**
 *
 * @author mikeyang
 */
public class Menu {
    
    public void showMenu(){
        
        Searching search = new Searching();
        ArrayList<Books> books = search.getBooks();
        ArrayList<Books> booksSorted = new ArrayList<>(books);//for sorting demonstration
        ArrayList<Students> students = search.getStudents();
        ArrayList<Students> studentsSorted = new ArrayList<>(students);//for sorting demonstration
        BorrowBook borrowBook = new BorrowBook();
        InputUtils myInput = new InputUtils(); //for user input and validation
                
        boolean exit = false;
        boolean searchBookExit = false;
        boolean listBooksExit = false;
        boolean searchStudentExit = false;
        boolean listStudentExit = false;
        boolean borrowBookExit = false;
        boolean returnBookExit = false;
        boolean specificStExit = false;
        
        while(!exit){
        
            System.out.println("Welcome to CCT library management system!");
            System.out.println("1.Menu");
            System.out.println("2.Search for a specific book by title and/or author name.");
            System.out.println("3.List all books by title and/or author name alphabetical order.");
            System.out.println("4.Search for a specific student by name and/or ID.");
            System.out.println("5.List all students by alphabetical name and/or ID order.");
            System.out.println("6.Register that a student has borrowed a book,if the book is borrowed and another student wants to borrow it, \nallow the user to add that reader to a\n" +
"waiting list (queue).");

            System.out.println("7.Register that a student has returned a book.If a book is returned and has a waiting queue,\ndisplay to the user the next student waiting for that\n" +
"book.");

            System.out.println("8.For a specific student, list the books that they have borrowed.");
            System.out.println("9.exit\n***********************");
            //main menu
            switch(myInput.getUserInt(1, 9)){ //invoke InputUtils.getUserInt method to give user a range of options
                case 1:                       //only number 1 to 9 are allowed, beacause the menu only have 9 options
                    break;
                case 2:
                    while(!searchBookExit){
                        System.out.println("Please enter a number to choose to search books by title or author name.");
                        System.out.println("1.Search books by title\n2.Search books by author name\n3.Menu");
                        switch(myInput.getUserInt(1,3)){
                            //-----1st function----
                            case 1:
                                String bookTitleInput = myInput.getUserText("Search books by title\nWhich book would you like to search?");
                                //Search by book title and user can only enter String,validate by invoke getUserText
                                System.out.println(search.linearSearchBooks(books, bookTitleInput, 1));
                                //Search Book Title, and shows up information (if Book Title exist)
                                break;
                            case 2:
                                String authorFnameInput = myInput.getUserText("Search books by author name\nWhich author name would you like to search? Please only enter first name");
                                //Search by author name
                                System.out.println(search.linearSearchBooks(books,authorFnameInput,2));
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
                    Sorting bs = new Sorting();
                    //-----2nd function
                    while(!listBooksExit){
                        
                        System.out.println("Please enter a number to choose list all books by title or author name alphabetical order");
                        System.out.println("1.list all books by title alphabetical order\n2.list all books by author name alphabetical order\n3.Menu");
                        switch(myInput.getUserInt(1,3)){
                            
                            case 1:
                                System.out.println(bs.bookSorting(booksSorted,1)); //sorting by book title
                                break;
                            case 2:
                                System.out.println(bs.bookSorting(booksSorted, 2));//sorting by author
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
                                String nameLinear = search.linearSearchStudents(students, searchByName);
                                System.out.println(nameLinear); //search students by name
                                break;
                            case 2:
                                int searchById = myInput2.getUserInt("Which student would you like to search? please enter student ID.");
                                int idBinary = search.binarySearch(students, searchById);
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
                    Sorting sSorting = new Sorting();
                    while(!listStudentExit){
                        System.out.println("Please enter a number to choose List all students by alphabetical name or ID order.");
                        System.out.println("1.list all students by name alphabetical order\n2.list all students by ID alphabetical order\n3.Menu");
                        switch(myInput.getUserInt(1,3)){
                            case 1:
                                System.out.println(sSorting.studentsSorting(studentsSorted,1)); //list student by alphabetical name order
                                break;
                            case 2:
                                System.out.println(sSorting.studentsSorting(studentsSorted, 2));//list student by id
                                
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
                    //BorrowBook borrowBook = new BorrowBook(); placed on the top
                    
                    FileWriteAndClear.clearFile("borrow_list"); //clear file data every time before execute
                    FileWriteAndClear.clearFile("waiting_list");
                    while(!borrowBookExit){
                        System.out.println("Would you like to borrow a book or print out borrowing list");
                        System.out.println("1.Borrow a book\n2.Print out borrowing list\n3.Display waiting list\n4.Menu");

                        switch(myInput.getUserInt(1,4)){
                            case 1:
                                System.out.println("which student wants to borrow a book? Please enter student ID");
                                int studentId = myInput.getUserInt(1,5000);//totally have 5000 students so that is the input range
                                System.out.println("which book would you like to borrow? Please enter book ID");
                                int bookId = myInput.getUserInt(1,500);
                                borrowBook.borrowBooks(books, students, studentId, bookId); //invoke borrowBooks function for user type in 
                                break;
                            case 2:
                                System.out.println(borrowBook.getBorrowing());//print out the borrowing list
                                break;
                            case 3:
                                System.out.println(borrowBook.getAllWaitingList()); //print out all waiting list
                                break;
                            case 4:    
                                borrowBookExit = true;
                                break;
                        }
                    }
                    //store data to file after finished book register
                    FileWriteAndClear.writeToFile("borrow_list", borrowBook.getBorrowing().toString());//store into borrow_list.txt file
                    FileWriteAndClear.writeToFile("waiting_list",borrowBook.getAllWaitingList().toString());//store into waiting_list.txt file
                    borrowBookExit = false;
                    break;
                case 7:
                    while(!returnBookExit){
                        System.out.println("Which book would you like to return?");
                        int bookId = myInput.getUserInt(1, 500);
                        borrowBook.removeBook(books, students, bookId);//invoke rmoveBook function when students want to remove book
                        returnBookExit = true;
                    }
                    returnBookExit = false;
                    break;
                case 8:
                    while(!specificStExit){
                        System.out.println("Which students borrowed record whould you like to search?");
                        int studentId = myInput.getUserInt(1, 5000);
                        borrowBook.listAstudentBRbook(books, students, studentId);//fetch borrowing data of a specific student
                        specificStExit = true;
                    }
                    specificStExit = false;
                    break;
                case 9:
                    exit=true;
                    break;
            }
        }
        
        
    }
    
}
