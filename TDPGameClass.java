import java.util.Random;
/**
 *
 * @author shane
 */
public class TDPGameClass {

    //create a private variable to hold the users turn total
    private int turnTotal = 0;

   					 /*create a setter method to allow the user to set the turnTotal variable*/
    					public void totalsetter(int setTotal)
    					{
    					    turnTotal = setTotal;
    					}

    /*create a method that allows the user to get the turnTotal*/
    public int totalGetter(int getTotal)
    {
        getTotal = turnTotal;
        return getTotal;
    }

    /*create a method that rolls the 2 dice*/
    public int rollDie()
    {
        //create a variable to be used to clear the turnTotal if needed.
        int clearer = 777;

        //create a variable to be used to trigger a total clear if two 1's are rolled
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
                }
             else
                {
                    secondNumber = die.nextInt(6)+1;
                }
            }

        /*create an if else statement that checks the contents
          of the variables to see if one or both are 1's*/

        //declare a variable to hold the total until the end of the if else
        int turnHolder = turnTotal;

        if(firstNumber == 1 && secondNumber == 1)
            {
                turnHolder = totalClear;

            }
        //if both are not 1's see if one is
        else if(firstNumber == 1 || secondNumber == 1)
            {
                turnHolder = clearer;

                turnTotal = turnHolder;
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
            }
        //return the value of turnHolder

        return turnHolder;
    }
}
