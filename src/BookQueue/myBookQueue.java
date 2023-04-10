package BookQueue;

import Books.Books;
import Books.SearchBooks;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mikeyang
 */
public class myBookQueue implements BookQueue{
    
    private int size;
    private ArrayList<Books> data;
    private int front;
    private int back;
    
    public myBookQueue(){

        this.data = new ArrayList<>();
        this.size = 0;
        this.front = -1;
        this.back = -1;
    
    
    }

    @Override
    public boolean Enqueue(Books newElement) {
        
        
        if(front == -1){
            front++;
        }

        
        back++;
        data.add(newElement);
        size++;
        

        return true;
        
    }
    @Override
    public Books Dequeue() {
        
        if(data.isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        
        
        Books element = data.get(front);
        
        data.remove(element);
        front++;
        size--;

        
        return element;
    }
    
    @Override
    public Books peek() {
        
        return data.get(front);
    }

    @Override
    public String First() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String Last() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString(){
        String toReturn = "[ ";
        for(int i=0;i<size;i++){
            
            toReturn += data.get(i) + ", ";
        }
        
        toReturn += " ]";
        
        return toReturn;
    }





}
