/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import Books.Students;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mikeyang
 */
public class StudentsSorting {
        public ArrayList<Students> studentsSorting(ArrayList<Students> students){
    
        Collections.sort(students, new StudentNameComparator());
        //In order to use Collections.sort, we have to implement Comparator firstly,as below method.
        
        for (Students s : students) {
            System.out.println(s);
        }
    
    
        return students;
    }
    
    
    //Compare book titles by implement Comparator, because this data type is "BookTest"
    //It is not String nor Integer, so it's not able to use Collections.sort, that's why implement Comparator
    public class StudentNameComparator implements Comparator<Students> {
        
        @Override
        public int compare(Students s1, Students s2) {
            return s1.getStudentName().compareTo(s2.getStudentName());
        }
    }

}
