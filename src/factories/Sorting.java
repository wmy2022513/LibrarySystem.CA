/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

import entities.Books;
import entities.Students;
import java.util.ArrayList;

/**
 *
 * @author mikeyang
 */
public class Sorting {
    /**
     * 
     * @param books 
     * @param option option is for menu, make code more readable and more organised
     * @return sorted ArrayList<Books>, depending on sorted by option(bookTitle or authorName)
     */
    public ArrayList<Books> bookSorting(ArrayList<Books> books, int option){
        
        ArrayList<Books> dummy = new ArrayList<>();
        // It's only a dummy, return an empty ArrayList, only for reminding user enter wrong number

        switch(option){
            case 1:
                bubbleSortBookTitle(books);
                for (Books bTitle : books) {
                    System.out.println(bTitle);
                }
                break;
            case 2:
                bubbleSortBookAuthorName(books);
                for (Books bAuthor:books){
                    System.out.println(bAuthor);
                }
                break;
            default:
                System.out.println("Wrong option, only 1 or 2 will be matched");
                return dummy;

        }
    
        return books;
    }
    /**
     * similar to above method, just data type and requirements are different
     * @param students
     * @param option
     * @return sorted ArrayList<Students>
     */
    public ArrayList<Students> studentsSorting(ArrayList<Students> students, int option){

        switch(option){
            case 1:
                bubbleSortName(students);
                for (Students s : students) {
                    System.out.println(s);
                }
                break;
            case 2:
                bubbleSortId(students);
                for (Students s : students) {
                    System.out.println(s);
                }
                break;
            }

        return students;
    }
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
        System.out.println("--Bubble Sort for Book Author name--");

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
    public void bubbleSortBookTitle(ArrayList<Books> books) {
        System.out.println("-----------");
        System.out.println("--Bubble Sort for Book Title--");
        String a;
        String b;


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
