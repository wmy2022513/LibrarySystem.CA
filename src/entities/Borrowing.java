/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import bookQueue.myBookQueue;


/**
 * In this class, below attributes are the details for each book borrowing
 * @author mikeyang
 */
public class Borrowing {
    
    private String borrow_ID;
    private int student_ID;
    private String bookTitle;
    private int bCode;
    private String book_ID;
    private String borrowDate;
    private String dueDate;
    private String returnDate;
    private myBookQueue waitingList;
    
    private static int currentBorrowNumber = 2023000;
    
    public Borrowing(int student_ID, String bookTitle,int bCode, String book_ID, String borrowDate, String dueDate, String returnDate){
    
        this.borrow_ID = generateBorrowID();
        this.student_ID = student_ID;
        this.bookTitle = bookTitle;
        this.book_ID = book_ID;
        this.bCode = bCode;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.waitingList = waitingList;
    
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
        return "**********************\nborrow_ID: " + borrow_ID + "\nstudent_ID: " + student_ID + "\nbook ID: "+bCode+"\nbookTitle: " + bookTitle + "\nbCode: " + book_ID + "\nborrowDate: " + borrowDate + "\ndueDate: " + dueDate + "\nreturnDate: " + returnDate +"\n";
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

    public int getbCode() {
        return bCode;
    }

    public myBookQueue getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(myBookQueue waitingList) {
        this.waitingList = waitingList;
    }


}
