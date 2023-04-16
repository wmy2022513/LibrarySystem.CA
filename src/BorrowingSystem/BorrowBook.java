/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import Books.WaitingListFormat;
import BookQueue.myBookQueue;
import Books.Books;
import Books.Students;
import inpututils.InputUtils;
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
    myBookQueue waitingList = new myBookQueue();

    public BorrowBook() {

    }

    private String generateRequestID(ArrayList<Borrowing> borrow, int borrowIndex) {
        
        String requestId = borrow.get(borrowIndex).getBorrow_ID() + "-BR" ;
        //return format : LIBW2023001-BR


        return requestId;
    }

    public myBookQueue generateWaitingList(ArrayList<Borrowing> borrows, int borrowIndex,int studentId) {
        
        myBookQueue setData = new myBookQueue();

        String request_ID = generateRequestID(borrows, borrowIndex);
        int student_ID = studentId;
        String bookTitle = borrows.get(borrowIndex).getBookTitle();
        String book_ID = borrows.get(borrowIndex).getBook_ID();
        String requestDate = borrows.get(borrowIndex).getReturnDate();

        WaitingListFormat addToQueue = new WaitingListFormat(request_ID, student_ID, bookTitle, book_ID, requestDate);
        setData.Enqueue(addToQueue);

        borrows.get(borrowIndex).setWaitingList(setData);

        waitingList.Enqueue(addToQueue);//add all books waitnglist to waitinglist(mainly for store data to file)

        return setData;
    }

    public myBookQueue getAllWaitingList() {
        return waitingList;
    }

    public myBookQueue getWaitingList(ArrayList<Borrowing> borrows, int borrowIndex) {
        return borrows.get(borrowIndex).getWaitingList();
    }

    @Override
    public String toString() {
        return "BookWaitingList{" + "waitingList=" + waitingList + '}';
    }

    public ArrayList<Borrowing> borrowBooks(ArrayList<Books> books, ArrayList<Students> students, int studentId, int bookIndex) {


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //Define date format
        String currentDate = sdf.format(new Date());
        //get current date time with Date()


        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(currentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // use add() method to add the days to the given date  
        cal.add(Calendar.DAY_OF_MONTH, 7);
        String dueForeturn = sdf.format(cal.getTime());  //require to return book in 7 days
//        System.out.println("Due date: " + dueDate);

        int student_ID = students.get(studentId - 1).getId();
        String bookTitle = books.get(bookIndex - 1).getBookTitle();
        int bCode = books.get(bookIndex).getbCode();//bcode already defined start from 1 so don't need to minus one
        String book_ID = books.get(bookIndex-1).getId();
        String borrowDate = currentDate;
        String dueDate = dueForeturn;
        String returnDate = "N/A";

            for(int i=0;i<borrowing.size();i++){
                if(borrowing.get(i).getBook_ID().equals(book_ID)){
                    InputUtils userInput = new InputUtils();
                    System.out.println("This book has been borrowed\nWould you like me put you into the waiting list?(y/N)");
                    String myInput = userInput.getUserText();
                    if(myInput.equalsIgnoreCase("y")){
                        this.generateWaitingList(this.getBorrowing(), i,studentId);
//                        System.out.println(i);
                        return borrowing;
                        
                    } else {
                        return borrowing;
                    }
                } 
            }
            //check if the book has been borrowed, if yes ==> return directly don't add anything, if not add into borrowing(list)
            borrowing.add(new Borrowing(student_ID, bookTitle,bCode, book_ID, borrowDate, dueDate, returnDate));
            System.out.println("Successfully borrowed");
            return borrowing;
//        }
    }

    public ArrayList<Borrowing> getBorrowing() {
        return borrowing;
    }

    public int removeBook(ArrayList<Books> books, ArrayList<Students> students, int bookId) {

        for (int i = 0; i < borrowing.size(); i++) {
            System.out.println("Testing:" + borrowing.get(i).getBookTitle());
                
                System.out.println("The book has been returned");
                System.out.println("//////////////////////////////////////////////");
                System.out.println("Next student :" + this.borrowing.get(i).getWaitingList().peek());
                borrowing.remove(i);

                //We need to collect all the methods together.Because there is no access to each other.
//            }
        }

        return -1;
    }

    public void listAstudentBRbook(ArrayList<Books> books, ArrayList<Students> students, int studentId){
       
        for(int i=0;i<borrowing.size();i++){
            
            if(borrowing.get(i).getStudent_ID() == studentId){

                System.out.println(borrowing.get(i));
            
            } else {
                System.out.println("this student didn't borrow any books");
            }
        }   
    }
    
    public void borrowedBook(int studentId) {
        for (int i = 0; i < borrowing.size(); i++) {

            if (borrowing.get(i).getStudent_ID() == (studentId)) {

                System.out.println("Books is returned" + borrowing.get(i));

            }
        }
    }

    
}
