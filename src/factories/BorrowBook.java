/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

import entities.Borrowing;
import entities.WaitingListFormat;
import bookQueue.myBookQueue;
import entities.Books;
import entities.Students;
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
    // if next reader willing to wait for the book, generate a request ID for them
    private String generateRequestID(ArrayList<Borrowing> borrow, int borrowIndex) {
        
        String requestId = borrow.get(borrowIndex).getBorrow_ID() + "-BR" ;
        //return format : LIBW2023001-BR


        return requestId;
    }
    /**
     * This method is for put the next readers to a waiting list as well as put all different books waiting list to the main waiting list
     * Then store main waiting list and write to a text file
     * @param borrows
     * @param borrowIndex
     * @param studentId
     * @return 
     */
    public myBookQueue generateWaitingList(ArrayList<Borrowing> borrows, int borrowIndex,int studentId) {
        
        myBookQueue setData = new myBookQueue();

        String request_ID = generateRequestID(borrows, borrowIndex);
        int student_ID = studentId;
        int bCode = borrows.get(borrowIndex).getbCode();
        String bookTitle = borrows.get(borrowIndex).getBookTitle();
        String book_ID = borrows.get(borrowIndex).getBook_ID();
        String requestDate = borrows.get(borrowIndex).getReturnDate();
        //above variables get from borrowing list they are about to store into addToQueue(WaitingListFormat)
        WaitingListFormat addToQueue = new WaitingListFormat(request_ID, student_ID, bCode, bookTitle, book_ID, requestDate);
        setData.Enqueue(addToQueue);//add the data from addToQueue(WaitingListFormat) by invoke Enqueue method

        borrows.get(borrowIndex).setWaitingList(setData);//add waiting list to the book reader requesting

        waitingList.Enqueue(addToQueue);//add all books' waitng list to this waitinglist(mainly for store data to file)

        return setData;
    }

    public myBookQueue getAllWaitingList() {
        return waitingList;
        //this waiting list store all books that have waiting list
    }

    public myBookQueue getWaitingList(ArrayList<Borrowing> borrows, int borrowIndex) {
        return borrows.get(borrowIndex).getWaitingList();
        //this waiting list is for a specific book that has waiting list
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

        int student_ID = students.get(studentId-1).getId();
        String bookTitle = books.get(bookIndex-1).getBookTitle();
        int bCode = books.get(bookIndex-1).getbCode();
        String book_ID = books.get(bookIndex-1).getId();
        String borrowDate = currentDate;
        String dueDate = dueForeturn;
        String returnDate = "N/A";

            for(int i=0;i<borrowing.size();i++){ //iterate borowing list
                if(borrowing.get(i).getBook_ID().equals(book_ID)){ 
                    InputUtils userInput = new InputUtils();
                    System.out.println("This book has been borrowed\nWould you like me put you into the waiting list?(y/N)");
                    String myInput = userInput.getUserText();
                    if(myInput.equalsIgnoreCase("y")){
                        this.generateWaitingList(this.getBorrowing(), i,studentId);
                        System.out.println("You've been put into the waiting list successfully");
                        return borrowing;
                    } else {
                        System.out.println("You still can apply for be put into waiting list next time");
                        return borrowing;
                    }
                } 
            }//check if the book has been borrowed, 
            //if yes ==> prompt user if wanted to be add into waiting list or not,
            //if not ==> go to the below code add into borrowing(list)
            
            borrowing.add(new Borrowing(student_ID, bookTitle,bCode, book_ID, borrowDate, dueDate, returnDate));
            System.out.println("Successfully borrowed");
            return borrowing;

    }

    public ArrayList<Borrowing> getBorrowing() {
        return borrowing;
    }

    public int removeBook(ArrayList<Books> books, ArrayList<Students> students,int bookIndex) {
        
        String book_ID = books.get(bookIndex - 1).getId();
        
        int foundAtIndex = -1;
        
        if(borrowing.isEmpty()){ //add this if-condition in case programme stuck or crashing when it is empty 
            System.out.println("This list is empty");
        }

        for (int i = 0; i < borrowing.size(); i++) {
            //iterate through the borrowing list 
            if(borrowing.get(i).getBook_ID().equals(book_ID)){
                foundAtIndex=i;
                System.out.println("Searching:" + borrowing.get(i).getBookTitle());//print out the book title 
                System.out.println("//////////////////////////////////////////////");

                if(borrowing.get(i).getWaitingList() != null){ //if this book has next reader
                    System.out.println("Next student :" + borrowing.get(i).getWaitingList().peek()); //show the user who is the next reader
                    System.out.println("Return successfully");
                    borrowing.remove(i); // remove book
                } else {
                    borrowing.remove(i); // remove book
                    System.out.println("Return successfully");
                }
            } 
        }
        if(foundAtIndex >=0){
        
        } else {
            System.out.println("Book not founded");
        }

        return -1;
    }

    public void listAstudentBRbook(ArrayList<Books> books, ArrayList<Students> students, int studentId){

    int foundAtIndex = -1;
        
        for(int i=0;i<borrowing.size();i++){
            //iterate through the borrowing list and check if there has data matches to the input studentId
            if(borrowing.get(i).getStudent_ID() == studentId){

                System.out.println(borrowing.get(i));
                foundAtIndex =i;

            }  
        }
        if(foundAtIndex >=0){

        } else { 
            System.out.println("This student doesn't borrow any books."); //if the data regards to the student id is empty then print out this line
        }
    }
}
