/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inpututils;

import java.util.Scanner;

/**
 *
 * @author Ken Healy
 */
public class InputUtils {

    /**
     * Prompts user to enter some text -- if input includes numbers then
     * display error and ask again
     * @param prompt -- the prompt or question to ask the user
     * @return - valid user input (text) 
     * ***NOTE*** This will change in a few weeks!!
     */
    public String getUserText(String prompt){
        
        Scanner myKB = new Scanner(System.in);
        boolean valid = false; //assume not valid
        String userInput;
        
        do{
           
            System.out.println(prompt);
        
            userInput = myKB.nextLine().trim(); // get input
        
//            if (userInput.matches("[a-zA-Z ]+")){
//                //this is valid input
//                valid=true;
//            }
            if (!userInput.isEmpty()){ // if it has content
                //this is valid input
                valid=true;
            }
            else{
                //not valid text
                System.out.println("Invalid - enter text only please");
            }
            
         }while (!valid); //keep going until valid input received
        
       return userInput;
 
    }
    
    /**
     * Prompt user to enter an integer - if invalid keep asking
     * @param prompt the prompt or question to ask user
     * @return valid user input as an int
     * 
     */
    public int getUserInt(String prompt){
        
        Scanner myKB = new Scanner(System.in);
        int userInput=0;
        boolean valid = false;
        
      do{
            System.out.println(prompt);
        
            try{
            
                userInput = myKB.nextInt(); //get a int
                valid = true; // i can only get to this line if it was a number
                
            }catch (Exception e){
                //error -- must not have entered numbers
                System.out.println("Invalid -- you must enter an integer only!");
                myKB.nextLine(); //reads enter from keyboard to prevent infinite loop
                
        }
      }while(!valid);
        
     return userInput;
  }
    public int getUserIntRange(String prompt){ 
        // this is for the first part validation,just modified a little bit inside the if-condition
        Scanner myKB = new Scanner(System.in);
        int userInput=0;
        boolean valid = false;
        
      do{
            System.out.println(prompt);
        
            try{
            
                userInput = myKB.nextInt(); //get a int
                if(userInput > 0 && userInput < 30){ //the rule of first part, the integer should greater than zero AND less than 30
                valid = true; // i can only get to this line if it was a number
                }
                else{
                    System.out.println("Please enter a integer follow the requirement,try again");
                }
            }catch (Exception e){
                //error -- must not have entered numbers
                System.out.println("Invalid -- you must enter an integer only!");
                myKB.nextLine(); //reads enter from keyboard to prevent infinite loop
                
        }
      }while(!valid);
        
     return userInput;
  }        
    public int getUserOpt(String prompt){ 
    //this method is for option part, only changed if-condition, the rest is the same.
        
        Scanner myKB = new Scanner(System.in);
        int userInput=0;
        boolean valid = false;
        
      do{
            System.out.println(prompt);
        
            try{
            
                userInput = myKB.nextInt(); //get a int
                if(userInput > 0 && userInput <= 4){ // should be in the option range,only four options
                valid = true; 
                }
                
            }catch (Exception e){
                //error -- must not have entered numbers
                System.out.println("Invalid -- you must enter an integer only!");
                myKB.nextLine(); //reads enter from keyboard to prevent infinite loop
                
        }
      }while(!valid);
        
     return userInput;
  }
}
