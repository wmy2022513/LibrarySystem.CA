/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factories;

import entities.Books;
import entities.Students;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikeyang
 */
public class Searching {
    
    ArrayList<Students> students;
    ArrayList<Books> books;
    
    public Searching(){
        this.students = loadStudents();
        this.books = loadBooks();
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
            System.out.println("Searching student id:" + mid + "...");
        }

        return -1;

    }
public String linearSearchStudents(ArrayList<Students> array, String targetName){
        // Search by Students first name
        // Going one by one the elements in the array
        for(int i = 0; i < array.size(); i++){
            System.out.println("Testing: " + array.get(i).getfName());
            // When the element is found, stop the loop and return the index
            if(array.get(i).getfName().equalsIgnoreCase(targetName)){
                return array.get(i).toString();
            }
        }
        
        return "**********************\nStudent Not found";
    }

    public ArrayList<Students> getStudents() {
        return students;
    }
        public ArrayList<Books> loadBooks(){
        
        ArrayList<Books> books = new ArrayList<>();
        
        try{
        BufferedReader br = new BufferedReader(new FileReader("MOCK_DATA.CSV"));
        String dummy = br.readLine(); 
        // it's only a dummy, for hold the first line attributes(id,author_first_name,author_last_name,author_last_name),
        //because we only want to deal with datas.
        String contentLine = br.readLine();
        
        String[] data;
        String id;
        int bCode;
        String firstName;
        String lastName;
        String bookTitle;
        String genre;
        int i=1;
        
        while (contentLine != null) {
                
                data = contentLine.split(",(?=([^\"]|\"[^\"]*\")*$)"); //Use RegEx split each by each and place to array by order
                //if only split by "," some book title contains "," will be omitted and cause error
                id = data[0];
                bCode = i++;
                firstName = data[1];
                lastName = data[2];
                bookTitle = data[3];
                //because we've been using RegEx to avoid some books title which contains "," 
                //those books title were added quotes in the front and behind,in order to remove quotes by using below if-statement.
                if(bookTitle.startsWith("\"") && bookTitle.endsWith("\"") ){ //check if some books title contain quotes("") 
                    bookTitle = data[3].substring(1, data[3].length()-1); //remove the quotes prevent from searching errors
                } 
                genre = data[4];

                books.add(new Books(id ,bCode , firstName, lastName, bookTitle, genre));
                contentLine = br.readLine();
        }
        
        }catch(Exception e){
            Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, e);
        }
        return books;
    }
    public String linearSearch(ArrayList<Books> array, String targetName, int option){
        
        switch (option) {
            case 1:
                // Search by BookTitle 
                // Going one by one the elements in the array
                for(int i = 0; i < array.size(); i++){
                    System.out.println("Testing: " + array.get(i).getBookTitle());
                    // When the element is found, stop the loop and return the index
                    if(array.get(i).getBookTitle().equals(targetName)){
                        return array.get(i).toString();
                    }
                }   break;
            case 2:
                //Search by Author's first name
                for(int i = 0; i < array.size(); i++){
                    System.out.println("Testing: " + array.get(i).getFirstName());
                    // When the element is found, stop the loop and return the index
                    if(array.get(i).getFirstName().equals(targetName)){
                        return array.get(i).toString();
                    }
                }   break;
            default:
                return "Wrong option, only 1 or 2 will be matched";
        }
        
        return "**********************\nNot found";
    }

    public ArrayList<Books> getBooks() {
        return books;
    }
}
