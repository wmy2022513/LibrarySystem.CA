/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inpututils;

import java.util.Scanner;

/**
 *
 * @author mikeyang
 */
public class InputUtils {

    /**
     * Prompts user to enter some text -- if input includes numbers then
     * display error and ask again
     * @param prompt -- the prompt or question to ask the user
     * @return - valid user input (text) 
     * 
     */
    public String getUserText(String prompt){
        
        Scanner myKB = new Scanner(System.in);
        boolean valid = false; //assume not valid
        String userInput;
        
        do{
           
            System.out.println(prompt);
        
            userInput = myKB.nextLine().trim(); // get input
        
            if (!userInput.matches("[0-9]+")){ //if input is not integer can be accepted
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
     * similar to above method, only take out string parameter and user prompt part
     * the rest is the same
     * @return 
     */
    public String getUserText(){
        
        Scanner myKB = new Scanner(System.in);
        boolean valid = false; //assume not valid
        String userInput;
        
        do{
           
            userInput = myKB.nextLine().trim(); // get input
        
            if (!userInput.matches("[0-9]+")){
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
     * Prompt user to enter an integer within a given range - if invalid keep asking
     * @param prompt the prompt or question to ask user
     * @param minValue the lowest value allowed
     * @param maxValue the largest value allowed
     * @return valid user input as an int
     * 
     */
    public int getUserInt( int minValue, int maxValue){ 
        // modified ,remove prompt,do-loop changed to while-loop, add if-codition        
        Scanner myKB = new Scanner(System.in);
        int userInput=0;    //initialized variable
        boolean valid = false;

        while((!valid) || (userInput <minValue) || (userInput >maxValue)){        

            try{
                
                userInput = myKB.nextInt(); //get a int
                //add below condition,mainly for menu
                if((userInput <minValue) || (userInput >maxValue)){
                    //prompt user , must enter a number in the range
                    System.out.println("The number must be between " + minValue + " and " + maxValue);
                    
                }else{
                     valid = true;
                }
            }catch (Exception e){
                //error -- must not have entered numbers
                System.out.println("Invalid -- you must enter an integer only!");
                myKB.nextLine(); //reads enter from keyboard to prevent infinite loop
                
            }
        }
        
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
