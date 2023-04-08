/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author mikeyang
 */
public class SearchStudents {
    
    ArrayList<Students> students;
    
    public SearchStudents(){
        this.students = loadStudents();
    }
    
    public ArrayList<Students> loadStudents(){
        
        ArrayList<Students> students = new ArrayList<>();
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String contentLine = br.readLine();
            
            String[] data;
            int id;
            String fName;
            String sName;
            String gender;
            String country;
            int age;
            String DOB;
            int eCode;
            
            while(contentLine != null){
                
                data = contentLine.split(",");
                id = Integer.parseInt(data[0]);
                fName = data[1];
                sName = data[2];
                gender = data[3];
                country = data[4];
                age = Integer.parseInt(data[5]);
                DOB = data[6];
                eCode = Integer.parseInt(data[7]);
                
                students.add(new Students( id, fName, sName, gender, country, age, DOB, eCode));
                contentLine = br.readLine();
            }
        

        }catch(Exception e){
            System.out.println("File not found");
        }
        return students;
    }
    
    public int binarySearch(ArrayList<Students> students, int targetId) {
        
//        Collections.sort(students);
        //data already seorted.
        int start = 1;
        int end = students.size() - 1;
        int mid;

        while(start <= end){
            
            mid = (start + end)/2;
            
            if(students.get(mid).getId() == targetId ){
                return mid;
            }
            else if(students.get(mid).getId() < targetId ){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }

        }

        return -1;

    }


    public ArrayList<Students> getStudents() {
        return students;
    }
    
}
