/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Books;

/**
 *
 * @author mikeyang
 */
public class Books {
    
    private String id;
    private String firstName;
    private String lastName;
    private String bookTitle;
    private String genre;
    
    public Books(String id, String firstName, String lastName, String bookTitle, String genre){
    
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookTitle = bookTitle;
        this.genre = genre;
    
    }

    @Override
    public String toString(){
        return "**********************\nBook ID:\n"+ this.id + "\nAuthor name: " + getAuthorName() + "\nBook Title: " + this.bookTitle + "\nGenre: " + this.genre + "\n**********************";
    }
    public String getId() {
        return id;
    }

    public String getAuthorName() {
        return firstName + " " + lastName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getGenre() {
        return genre;
    }
    
}
