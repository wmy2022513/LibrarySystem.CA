/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import Books.Books;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mikeyang
 */
public class BooksSorting {
    
    public ArrayList<Books> bookSorting(ArrayList<Books> books, int option){
        
        //In order to use Collections.sort, we have to implement Comparator firstly,as below method.
        Collections.sort(books, new BookTitleComparator());//for sort book title
        Collections.sort(books, new AuthorNameComparator());//for sort by author name
        
        ArrayList<Books> dummy = new ArrayList<>();// It's only a dummy, return an empty ArrayList, only for reminding user enter wrong number

        switch(option){
            case 1:
                for (Books bTitle : books) {
                    System.out.println(bTitle);
                }
                break;
            case 2:
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
    
    
    //Compare book titles by implement Comparator, because this data type is "BookTest"
    //It is not String nor Integer, so it's not able to use Collections.sort, that's why implement Comparator
    public class BookTitleComparator implements Comparator<Books> {
        
        @Override
        public int compare(Books b1, Books b2) {
            return b1.getBookTitle().compareTo(b2.getBookTitle());
        }
    }

    public class AuthorNameComparator implements Comparator<Books>{

        @Override
        public int compare(Books b1, Books b2) {
            return b1.getAuthorName().compareTo(b2.getAuthorName());
        }
    
    }
}
