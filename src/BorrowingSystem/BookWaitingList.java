/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import java.util.ArrayList;

/**
 *
 * @author mikeyang
 */
public class BookWaitingList {
    
    
    
    private String request_ID;
    private int student_ID;
    private String bookTitle;
    private String book_ID;
    private String requestDate;
    
    private static int currentRequestNumber = 2023000;
    
    public BookWaitingList(int student_ID, String bookTitle, String book_ID, String requestDate){
        
        ArrayList<Borrowing> borrow = new ArrayList<>();
        int borrowID = 1;
        
        this.request_ID = generateRequestID(borrow, borrowID);
        this.student_ID = student_ID;
        this.bookTitle = bookTitle;
        this.book_ID = book_ID;
        this.requestDate = requestDate;
    
    }
    
    private String generateRequestID(ArrayList<Borrowing> borrow, int borrowID){
    
        int i = 1;
        String requestId = borrow.get(borrowID).getBorrow_ID() +"-"+ i;
        i++;
        
        return requestId;
    }
    
}
