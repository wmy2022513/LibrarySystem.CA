/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BorrowingSystem;

import Books.Books;
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

    ArrayList<Books> books;

    public SearchBooks() {

        this.books = loadBooks();
        //Search BookTitle byId
//        ArrayList<Books> books = loadBooks();
//        System.out.println(linearSearch(books, userQuery));
    }

    public ArrayList<Books> loadBooks() {

        ArrayList<Books> books = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\esitb\\Downloads\\LibrarySystem.CA-Wei-Ming\\LibrarySystem.CA-Wei-Ming\\MOCK_DATA .csv"));
            String dummy = br.readLine();
            // it's only a dummy, for hold the first line attributes(id,author_first_name,author_last_name,author_last_name),
            //because we only want to deal with datas.
            String contentLine = br.readLine();

            String[] data;
            String id;
            String bCode;
            String firstName;
            String lastName;
            String bookTitle;
            String genre;

            while (contentLine != null) {

                data = contentLine.split(",(?=([^\"]|\"[^\"]*\")*$)"); //Use RegEx split each by each and place to array by order
                //if only split by "," some book title contains "," will be omitted and cause error
                id = data[0];
                bCode = data[1];
                firstName = data[2];
                lastName = data[3];
                bookTitle = data[4];
                //because we've been using RegEx to avoid some books title which contains "," 
                //those books title were added quotes in the front and behind,in order to remove quotes by using below if-statement.
                if (bookTitle.startsWith("\"") && bookTitle.endsWith("\"")) { //check if some books title contain quotes("") 
                    bookTitle = data[4].substring(1, data[4].length() - 1); //remove the quotes prevent from searching errors
                }
                genre = data[5];

                books.add(new Books(id, bCode, firstName, lastName, bookTitle, genre));
                contentLine = br.readLine();
            }

        } catch (Exception e) {
            Logger.getLogger(SearchBooks.class.getName()).log(Level.SEVERE, null, e);
        }
        return books;
    }

    public String linearSearch(ArrayList<Books> array, String targetName, int option) {

        switch (option) {
            case 1:
                // Search by BookTitle 
                // Going one by one the elements in the array
                for (int i = 0; i < array.size(); i++) {
                    System.out.println("Testing: " + array.get(i).getBookTitle());
                    // When the element is found, stop the loop and return the index
                    if (array.get(i).getBookTitle().equals(targetName)) {
                        return array.get(i).toString();
                    }
                }
                break;
            case 2:
                //Search by Author's first name
                for (int i = 0; i < array.size(); i++) {
                    System.out.println("Testing: " + array.get(i).getFirstName());
                    // When the element is found, stop the loop and return the index
                    if (array.get(i).getFirstName().equals(targetName)) {
                        return array.get(i).toString();
                    }
                }
                break;
            default:
                return "Wrong option, only 1 or 2 will be matched";
        }

        return "**********************\nNot found";
    }

    public ArrayList<Books> getBooks() {
        return books;
    }

}
