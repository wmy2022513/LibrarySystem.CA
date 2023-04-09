/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import java.util.Date;

/**
 *
 * @author mikeyang
 */
public class Borrowing {
    
    private String borrow_ID;
    private int student_ID;
    private String bookTitle;
    private String book_ID;
    private String borrowDate;
    private String dueDate;
    private String returnDate;
    
    private static int currentBorrowNumber = 2023000;
    
    public Borrowing(int student_ID, String bookTitle, String book_ID, String borrowDate, String dueDate, String returnDate){
    
        this.borrow_ID = generateBorrowID();
        this.student_ID = student_ID;
        this.bookTitle = bookTitle;
        this.book_ID = book_ID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    
    }
    private String generateBorrowID() {
		
		//Note -- A more complex ID creation method could be performed here.
                //give each borrowing a unique ID
		currentBorrowNumber++;
                String borrowID = "LIBW" + currentBorrowNumber;
		return borrowID;
		
    }

    @Override
    public String toString() {
        return "**********************\nborrow_ID: " + borrow_ID + "\nstudent_ID: " + student_ID + "\nbookTitle: " + bookTitle + "\nbook_ID: " + book_ID + "\nborrowDate: " + borrowDate + "\ndueDate: " + dueDate + "\nreturnDate: " + returnDate +"\n";
    }
    
    //belows are getters
    public String getBorrow_ID() {
        return borrow_ID;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBook_ID() {
        return book_ID;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public static int getCurrentBorrowNumber() {
        return currentBorrowNumber;
    }


}
