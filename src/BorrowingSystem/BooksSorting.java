/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import Books.Books;
import java.util.ArrayList;

/**
 *
 * @author mikeyang
 */
public class BooksSorting {
    
    public ArrayList<Books> bookSorting(ArrayList<Books> books, int option){
        
        //In order to use Collections.sort, we have to implement Comparator firstly,as below method.

        ArrayList<Books> dummy = new ArrayList<>();// It's only a dummy, return an empty ArrayList, only for reminding user enter wrong number

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
    public void bubbleSortBookTitle(ArrayList<Books> books) {
        System.out.println("-----------");
        System.out.println("--Bubble Sort starting--");
        String a;
        String b;


        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1; j++) {
                a = books.get(j).getBookTitle();
                b = books.get(j + 1).getBookTitle();

                if (a.compareTo(b) > 0) {
                    Books tmp = books.get(j);//save the value of array[j] in the temp
                    books.set(j, books.get(j + 1));//change the value of array[j] for 
                    books.set(j + 1, tmp);//save the value of temp into array[j+1]
                }
            }
        }

        System.out.println("--BookTitle Sorted--");
        System.out.println("-----------");
    }
    public void bubbleSortBookAuthorName(ArrayList<Books> books) {
        System.out.println("-----------");
        System.out.println("--Bubble Sort starting--");

        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1; j++) {
                String n = books.get(j).getAuthorName();
                String m = books.get((j + 1)).getAuthorName();
                if (n.compareTo(m)>0) {
                    Books tmp = books.get(j);//save the value of array[j] in the temp
                    books.set(j, books.get(j + 1));//change the value of array[j] for 
                    books.set(j + 1, tmp);//save the value of temp into array[j+1]
                }
            }
        }

        System.out.println("--AuthorName Sorted--");
        System.out.println("-----------");

    }
    
}
