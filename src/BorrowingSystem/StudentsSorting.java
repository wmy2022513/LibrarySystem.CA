/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import Books.Students;
import java.util.ArrayList;

/**
 *
 * @author mikeyang
 */
public class StudentsSorting {
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
        public void bubbleSortId(ArrayList<Students> students) {
        System.out.println("-----------");
        System.out.println("--Bubble Sort starting--");

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1; j++) {
                int n = students.get(j).getId();
                int m = students.get((j + 1)).getId();
                if (n > m) {
                    Students tmp = students.get(j);//save the value of array[j] in the temp
                    students.set(j, students.get(j + 1));//change the value of array[j] for 
//                    students.set(j + 1, Students.class.cast(tmp));//save the value of temp into array[j+1]
                    students.set(j + 1, tmp);//fix data type casting error
                }
            }
        }

        System.out.println("--Array Sorted--");
        System.out.println("-----------");

    }
        public void bubbleSortName(ArrayList<Students> students) {
        System.out.println("-----------");
        System.out.println("--Bubble Sort starting--");
        String a;
        String b;
        Students c;
        Students d;

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size() - 1; j++) {
                a = students.get(j).getStudentName();
                b = students.get(j + 1).getStudentName();

                if (a.compareTo(b) > 0) {
                    Students tmp = students.get(j);//save the value of array[j] in the temp
                    students.set(j, students.get(j + 1));//change the value of array[j] for 
                    students.set(j + 1, tmp);//save the value of temp into array[j+1]
                }
            }
        }

        System.out.println("--Array Sorted--");
        System.out.println("-----------");
    }

}
