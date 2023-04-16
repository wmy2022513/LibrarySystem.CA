/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import Books.Borrowing;
import Books.WaitingListFormat;
import BookQueue.myBookQueue;
import Books.Books;
import Books.Students;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

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

        int i = 1;
        String requestId = borrow.get(borrowIndex).getBorrow_ID() + "-" + i;
        //return format : LIBW2023001-1
        i++;

        return requestId;
    }

    public myBookQueue generateWaitingList(ArrayList<Borrowing> borrows, int borrowIndex) {

        String request_ID = generateRequestID(borrows, borrowIndex - 1);
        int student_ID = borrows.get(borrowIndex - 1).getStudent_ID();
        String bookTitle = borrows.get(borrowIndex - 1).getBookTitle();
        String book_ID = borrows.get(borrowIndex - 1).getBook_ID();
        String requestDate = borrows.get(borrowIndex - 1).getReturnDate();

        WaitingListFormat addToQueue = new WaitingListFormat(request_ID, student_ID, bookTitle, book_ID, requestDate);

        waitingList.Enqueue(addToQueue);

        return waitingList;
    }

    public myBookQueue getWaitingList() {
        return waitingList;
    }

    @Override
    public String toString() {
        return "BookWaitingList{" + "waitingList=" + waitingList + '}';
    }

    public void borrowBooks(ArrayList<Books> books, ArrayList<Students> students, int studentId, int bookIndex) {

//        ArrayList<Borrowing> borrowing = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //Define date format
        String currentDate = sdf.format(new Date());
        //get current date time with Date()
//        System.out.println("Current date: "+currentDate);

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
        String book_ID = books.get(bookIndex - 1).getId();
        String borrowDate = currentDate;
        String dueDate = dueForeturn;
        String returnDate = "N/A";

        //check if the book has been borrowed, if yes ==> add into waiting list. if not add into borrowing(list)
        borrowing.add(new Borrowing(student_ID, bookTitle, book_ID, borrowDate, dueDate, returnDate));

    }

    public ArrayList<Borrowing> getBorrowing() {
        return borrowing;
    }

    /**
     * Remove a book from borrowing list and show who is next from waiting list
     *
     * @param books -- is an object from Books class
     * @param students -- is an obejct from Students class
     * @param bookId -- is a parameter which is attribute of books
     * @param bookIndex -- is a parameter which is attribute of books
     * @return -- as an integer to make sure the function is done succesfully
     */
    public int removeBook(ArrayList<Books> books, ArrayList<Students> students, String bookId, int bookIndex, int studentId) {
        //Questions Does bookındex is necessary or not ?
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM--yyyy");

        String currentDate = sdf.format(new Date());

        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(currentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String bookTitle = books.get(bookIndex - 1).getBookTitle();
        String book_ID = books.get(bookIndex - 1).getId();
        String returnDate = currentDate;

        for (int i = 0; i < borrowing.size(); i++) {
            System.out.println("Testing:" + borrowing.get(i).getBook_ID());
            if (borrowing.get(i).getBook_ID().equals(bookId) && borrowing.get(i).getStudent_ID() == (studentId)) {
                borrowing.remove(i);
                System.out.println("Books is returned");
                System.out.println("//////////////////////////////////////////////");
                System.out.println("Next student :" + this.getWaitingList().peek());
            }
        }

        return -1;
    }

    public void borrowedBook(int studentId) {
        for (int i = 0; i < borrowing.size(); i++) {

            if (borrowing.get(i).getStudent_ID() == (studentId)) {

                System.out.println("Books is returned" + borrowing.get(i));

            }
        }
    }

    /**
     * *
     * We are sendind to array to show the all elements in the array
     *
     * @param array
     */
    //Sorting Students by Id
    /**
     * Sort the students by Id.
     *
     * @param students is an object which is belongs to ArrayList<Students>
     */
    public void bubbleSortId(ArrayList<Students> students) {
        System.out.println("-----------");
        System.out.println("--Bubble Sort for Students--");

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1; j++) {
                int n = students.get(j).getId();
                int m = students.get((j + 1)).getId();
                if (n > m) {
                    Students tmp = students.get(j);//save the value of students.get(j) in the temp
                    students.set(j, students.get(j + 1));//change the value of students.get(j) for sorting
                    students.set(j + 1, tmp);//save the value of temp into students.get(j+1)
                }
            }
        }

        System.out.println("--Array Sorted--");
        System.out.println("-----------");

    }

    //Sorting Students by Student Name
    /**
     * Sort the students by Name
     *
     * @param students is an object which is belongs to ArrayList<Students>
     */
    public void bubbleSortName(ArrayList<Students> students) {
        System.out.println("-----------");
        System.out.println("--Bubble Sort for Students--");
        String a;
        String b;

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1; j++) {
                a = students.get(j).getStudentName();
                b = students.get(j + 1).getStudentName();

                if (a.compareTo(b) > 0) {
                    Students tmp = students.get(j);//save the value of students.get(j) in the temp
                    students.set(j, students.get(j + 1));//change the value of students.get(j) for sorting 
                    students.set(j + 1, tmp);//save the value of temp into students.get(j+1)
                }
            }
        }

        System.out.println("--Array Sorted--");
        System.out.println("-----------");
    }

    //Sorting Books by Autohor Name
    /**
     * Sort the books by Author Name.
     *
     * @param books is an object which is belongs to ArrayList<Books>
     */
    public void bubbleSortBookAuthorName(ArrayList<Books> books) {
        System.out.println("-----------");
        System.out.println("--Bubble Sort for Books--");

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1; j++) {
                String n = books.get(j).getAuthorName();
                String m = books.get((j + 1)).getAuthorName();
                if (n.compareTo(m) > 0) {
                    Books tmp = books.get(j);//save the value of students.get(j) in the temp
                    books.set(j, books.get(j + 1));//change the value of students.get(j) for sorting
                    books.set(j + 1, tmp);//save the value of temp into students.get(j+1)
                }
            }
        }

        System.out.println("--Array Sorted--");
        System.out.println("-----------");

    }

    //Sorting Books by Name
    /**
     * Sort the books by BookName
     *
     * @param books is an object which is belongs to ArrayList<Books>
     */
    public void bubbleSortBookName(ArrayList<Books> books) {
        System.out.println("-----------");
        System.out.println("--Bubble Sort for Books--");
        String a;
        String b;
        Students c;
        Students d;

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1; j++) {
                a = books.get(j).getBookTitle();
                b = books.get(j + 1).getBookTitle();

                if (a.compareTo(b) > 0) {
                    Books tmp = books.get(j);//save the value of students.get(j) in the temp
                    books.set(j, books.get(j + 1));//change the value of students.get(j) for sorting
                    books.set(j + 1, tmp);//save the value of temp into students.get(j+1)
                }
            }
        }

        System.out.println("--Array Sorted--");
        System.out.println("-----------");
    }

}
