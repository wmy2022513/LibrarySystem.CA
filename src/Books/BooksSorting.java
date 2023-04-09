/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mikeyang
 */
public class BooksSorting {
    
    public ArrayList<Books> bookSorting(ArrayList<Books> books){
    
        Collections.sort(books, new BookTitleComparator());
        //In order to use Collections.sort, we have to implement Comparator firstly,as below method.
        
        for (Books b : books) {
            System.out.println(b);
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

}
