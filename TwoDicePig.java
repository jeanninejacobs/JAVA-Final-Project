/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author shane
 */
public class TwoDicePig {
    
    //create a private variable to hold the users turn total
    private int turnTotal = 0;
    
    /*create a setter method to allow the user to set the turnTotal variable*/
    public void totalsetter(int setTotal)
    {
        turnTotal = setTotal;
    }
    
    /*create a method that allows the user to get the turnTotal*/
    public int totalGetter()
    {
        return turnTotal;
    }
    
    /*create a method that rolls the 2 dice*/
    public int rollDie()
    {
        
        //create a variable to be used to clear the turnTotal if needed.
        int clearer = 777;
        
        //create a variable to be used to trigger a total clear is two 1's are rolled
        int totalClear = 666;
        
        //create a variable to be used to show that the user rolled doubles
        int doubles = 333;
        
         //create a random object
        Random die = new Random();
            
        //create an int to hold the number you rolled
        int firstNumber = 0;
        
        //create a second int to hold the second number rolled
        int secondNumber = 0;
         
        //create a loop to roll both die
        for(int counter = 0; counter < 2; counter++)
            {
             if(counter == 0)
                {
                    firstNumber = die.nextInt(6)+1;
                    System.out.println("Die One: " + firstNumber);
                }
             else
                {
                    secondNumber = die.nextInt(6)+1;
                    System.out.println("Die Two: " + secondNumber);
                }
            }
        
        /*create an if else satement that checks the contents
          of the variables to see if one or both are 1's*/
        
        //declare a variable to hold the total until the end of the if else
        int turnHolder = turnTotal;
        
        if(firstNumber == 1 && secondNumber == 1)
            {   
                turnHolder = totalClear;
                
                turnTotal = 0;
                
                System.out.println("Sorry, you rolled two 1's. Your overall points have been cleared.");

            }
        //if both are not 1's see if one is
        else if(firstNumber == 1 || secondNumber == 1)
            {
                turnHolder = clearer;
                
                turnTotal = 0;
                
                System.out.println("Sorry, you rolled a 1. You cannot keep your points from this turn.");
                System.out.println("Next player, please...");
            }
        //if doubles are rolled, force player to roll again.
        else if(firstNumber == secondNumber)
            {
                int holder = turnHolder;
                
                holder = holder + firstNumber + secondNumber;
                
                turnHolder = holder;
                
                turnTotal = turnHolder;
                
                /*change the value that is returned to show that the user must
                  roll again*/
                turnHolder = doubles;               
            }
        //if there are no ones add the numbers together.
        else
            {
                int holder = turnHolder;
                
                holder = holder + firstNumber + secondNumber;
                
                turnHolder = holder;
                
                turnTotal = turnHolder;
                
                int thisTurn = firstNumber + secondNumber;    
                
                //print out the plays turn score
                System.out.println("You scored " + thisTurn + " points this roll.");
                
            }
        
        //return the value of turnHolder
        return turnHolder;
    }
}
