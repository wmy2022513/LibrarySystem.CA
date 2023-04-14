/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import java.util.ArrayList;
import BookQueue.*;

/**
 *
 * @author mikeyang
 */
public class BookWaitingList {
    
    myBookQueue waitingList = new myBookQueue();
    
    
    public BookWaitingList(){
    
    }
    
    private String generateRequestID(ArrayList<Borrowing> borrow, int borrowIndex){
    
        int i = 1;
        String requestId = borrow.get(borrowIndex).getBorrow_ID() +"-"+ i;
        //return format : LIBW2023001-1
        i++;
        //if there's a second person requesting this book as well
        return requestId;
    }
    
    public myBookQueue generateWaitingList(ArrayList<Borrowing> borrows,int borrowIndex){
        
        
        String request_ID = generateRequestID(borrows,borrowIndex-1);
        int student_ID = borrows.get(borrowIndex-1).getStudent_ID();
        String bookTitle = borrows.get(borrowIndex-1).getBookTitle();
        String book_ID = borrows.get(borrowIndex-1).getBook_ID();
        String requestDate = borrows.get(borrowIndex-1).getReturnDate();
        
        WaitingListFormat addToQueue = new WaitingListFormat(request_ID,student_ID,bookTitle,book_ID,requestDate);
        
        waitingList.Enqueue(addToQueue);
        
        borrowIndex++;
        
        return waitingList;
    }

    public myBookQueue getWaitingList() {
        return waitingList;
    }

    @Override
    public String toString() {
        return "BookWaitingList{" + "waitingList=" + waitingList + '}';
    }

    
}
