/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import Books.Books;
import Students.Students;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mikeyang
 */
public class BorrowBook {

    ArrayList<Borrowing> borrowing = new ArrayList<>();
    
    public BorrowBook() {
        
    }
     
    
    public void borrowBooks(ArrayList<Books> books, ArrayList<Students> students,int studentId,int bookID){
    
//        ArrayList<Borrowing> borrowing = new ArrayList<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //get current date time with Date()
        String currentDate = sdf.format(new Date());
//        System.out.println("Current date: "+currentDate);
        
         Calendar cal = Calendar.getInstance();  
        try{  
           cal.setTime(sdf.parse(currentDate));  
        }catch(ParseException e){  
            e.printStackTrace();  
         }  
             
        // use add() method to add the days to the given date  
        cal.add(Calendar.DAY_OF_MONTH, 7);  
        String dueForeturn = sdf.format(cal.getTime());  
//        System.out.println("Due date: " + dueDate);
        

        int student_ID = students.get(studentId-1).getId();
        String bookTitle =  books.get(bookID-1).getBookTitle();
        String book_ID = books.get(bookID-1).getId();
        String borrowDate = currentDate;
        String dueDate = dueForeturn;
        String returnDate = "N/A";
        
        borrowing.add(new Borrowing(student_ID,bookTitle, book_ID, borrowDate, dueDate, returnDate ));


    }

    public ArrayList<Borrowing> getBorrowing() {
        return borrowing;
    }
    

}
