package bookQueue;

import entities.WaitingListFormat;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Implement by using ArrayList, slightly different to the ArrayQueue we've been implemented in the class
 * @author mikeyang
 */
public class myBookQueue implements BookQueue{
    
    private int size;
    private ArrayList<WaitingListFormat> data;
    private int front;
    private int back;
    
    public myBookQueue(){

        this.data = new ArrayList<>();
        this.size = 0;
        this.front = -1;
        this.back = -1;
    
    
    }

    @Override
    public boolean Enqueue(WaitingListFormat newElement) {
        
        
        if(front == -1){
            front++;
        }

        
        back++;
        data.add(newElement);
        size++;
        

        return true;
        
    }
    @Override
    public WaitingListFormat Dequeue() {
        
        if(data.isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        
        
        WaitingListFormat element = data.get(front);
        
        data.remove(element);
        front++;
        size--;

        
        return element;
    }
    
    @Override
    public WaitingListFormat peek() {
        
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        } else {
            return false;
        }
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
