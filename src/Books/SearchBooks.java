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
    
    public SearchBooks(){
        //Search BookTitle byId
        ArrayList<Books> books = loadBooks();
//        System.out.println(linearSearch(books, userQuery));
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
                
                data = contentLine.split(",(?=([^\"]|\"[^\"]*\")*$)"); //Use RegEx split each by each and place to array by order
                //if only split by "," some book title contains "," will be omitted and cause error
                id = data[0];
                firstName = data[1];
                lastName = data[2];
                bookTitle = data[3];
                //because we've been using RegEx to avoid some books title which contains "," 
                //those books title were added quotes in the front and behind,in order to remove quotes by using below if-statement.
                if(bookTitle.startsWith("\"") && bookTitle.endsWith("\"") ){ //check if some books title contain quotes("") 
                    bookTitle = data[3].substring(1, data[3].length()-1); //remove the quotes prevent from searching errors
                } 
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
