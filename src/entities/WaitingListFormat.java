/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author mikeyang
 */
public class WaitingListFormat {
    
    private String request_ID;
    private int student_ID;
    private String bookTitle;
    private String book_ID;
    private String requestDate;
    
    public WaitingListFormat(String request_ID,int student_ID, String bookTitle, String book_ID, String requestDate){
        
        this.request_ID = request_ID;
        this.student_ID = student_ID;
        this.bookTitle = bookTitle;
        this.book_ID = book_ID;
        this.requestDate = requestDate;
    }

    public String getRequest_ID() {
        return request_ID;
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

    public String getRequestDate() {
        return requestDate;
    }

    @Override
    public String toString() {
        return "WaitingListFormat:" + "request_ID=" + request_ID + "\n, student_ID=" + student_ID + "\n, bookTitle=" + bookTitle + "\n, book_ID=" + book_ID + "\n, requestDate=" + requestDate + "*********************\n}";
    }
    
}
