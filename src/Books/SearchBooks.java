/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mikeyang
 */
public class SearchBooks {
    
    public SearchBooks(String userQuery){
        //Search BookTitle byId
        ArrayList<Books> books = loadBooks();
        System.out.println(linearSearch(books, userQuery));
    }
    
    public ArrayList<Books> loadBooks(){
        
        ArrayList<Books> books = new ArrayList<>();
        
        try{
        BufferedReader br = new BufferedReader(new FileReader("MOCK_DATA.CSV"));
        String contentLine = br.readLine();
        
        String[] data;
        String id;
        String firstName;
        String lastName;
        String bookTitle;
        String genre;
        
        while (contentLine != null) {
                
                data = contentLine.split(","); // split each by each and place to array by order
                id = data[0];
                firstName = data[1];
                lastName = data[2];
                bookTitle = data[3];
                genre = data[4];

                books.add(new Books(id, firstName, lastName, bookTitle, genre));
                contentLine = br.readLine();
            }

        
        }catch(Exception e){
            Logger.getLogger(SearchBooks.class.getName()).log(Level.SEVERE, null, e);
        }
        return books;
    }
    public String linearSearch(ArrayList<Books> array, String targetName){
        
        // Going one by one the elements in the array
        for(int i = 0; i < array.size(); i++){
            System.out.println("Testing: " + array.get(i).getBookTitle());
            // When the element is found, stop the loop and return the index
            if(array.get(i).getBookTitle().equals(targetName)){
                return array.get(i).toString();
            }            
        }
        return "**********************\nNot found";
    }
}
