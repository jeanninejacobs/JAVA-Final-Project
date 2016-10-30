/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 * @author Jeannine
 */
public class PigDieGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int players;				//to hold user choice to play against person or computer
        boolean c = false;                      //to play with computer or not
	String [] playerNames = new String[2];	//to hold player names
        int [] scores = new int[2];             //Array to hold player scores
        int playAgain;                          //to hold answer after valid roll
	String answer;				//to hold user choice to view game rules

	//Create a Scanner object for keyboard input
	Scanner keyboard = new Scanner(System.in);

	//Create a Game Class object for game play
	TwoDicePig play = new TwoDicePig();
        
        //Create a Player Class object for the computer player
        PlayerClass computer = new PlayerClass();
        
//        new GUIClass();

	//Ask user to create players
	System.out.print("Would you like to play against a real person or the "
                + "computer? Enter 1 = player or 2 = computer: ");
	players = keyboard.nextInt();
        
        //Consume the remaining newline.
        keyboard.nextLine();

        //Create player objects and set names
        System.out.print("What is Player One's name? ");
        playerNames[0] = keyboard.nextLine();	

	if ( players == 1)
	{                
            System.out.print("What is Player Two's name? ");
            playerNames[1] = keyboard.nextLine();
                        
            System.out.println("Welcome " + playerNames[0] + " and " + playerNames[1] + "! ");   
	}
	else
	{			
            c = true;
            playerNames[1] = "Computer";
                        
            System.out.println("Welcome " + playerNames[0] + " get ready to "
                    + "play against the " + playerNames[1] + "!");
	}

        System.out.println("Would you like to read the rules of the game before you play? Y or N ");
	answer = keyboard.nextLine();

	if (answer.equalsIgnoreCase("y"))
	{
            //display rules
            System.out.println("Rules for Two Dice Pig Game");
            System.out.println(" ");
            System.out.println("Each turn, a player repeatedly rolls two dice " 
                    + "until either a 1 is rolled or the player decides to 'hold':");
            System.out.println(" ");
            System.out.println("--> If neither shows a 1, their sum is added "
                    + "to the turn total. Player can hold or roll again.");
            System.out.println("--> If a double is rolled, the point total is "
                    + "added to the turn total as with any roll but the player is"
                    + " obligated to roll again.");
            System.out.println("--> If a single 1 is rolled, the player scores "
                    + "nothing and the turn ends.");
            System.out.println("--> If two 1s are rolled, the player's entire "
                    + "score is lost, and the turn ends.");
            System.out.println(" ");
            System.out.println("The first player to score 100 or more points wins");
            System.out.println(" ");
            System.out.print("When you are ready to play, hit enter. ");
            answer = keyboard.nextLine();
	}

        System.out.println(" ");

//--------------------------------------Game play loop--------------------------
        int index = 0;
        int currentTurnScore = 0;
        
        //loop to change player turn
	while (index <= 1)			
	{
            play.totalsetter(0);
            System.out.println(" ");
            System.out.println(playerNames[index] + "'s turn...");
            
            //Window to show rolling dice
            DiceWindow diceWindow = new DiceWindow();
            diceWindow.pack();
            diceWindow.setVisible(true);
            diceWindow.toFront();
            diceWindow.requestFocus();
            diceWindow.requestFocusInWindow();
            diceWindow.repaint();
            
            //Pause between turns
            try{Thread.sleep(2000);}catch(Exception e){}
            
            //Close dice window
            diceWindow.setVisible(false);
                
            //Call method to roll the dice.
            int result = play.rollDie();

            //Check returned result against rules
            if (result < 100)				//Valid roll
            {
                currentTurnScore += result;	//Add score to turn total and 
                                                //ask if player wants to roll again.

                if(c == true && index == 1)
                {
                    playAgain = computer.decision();
                    if (playAgain == 1)
                        System.out.println("The computer will roll again...");
                    else
                        System.out.println("The computer will hold.");
                }
                else
                {
                    System.out.println("Your current score this turn is " + currentTurnScore);
                    System.out.print(playerNames[0] + "'s score is " + scores[0] + " and "
                        + playerNames[1] + "'s score is " + scores[1] 
                        + ". Would you like to roll again? 1 =roll,0 =hold: ");
                    playAgain = keyboard.nextInt();
                }
                
                if (playAgain == 0)             //if yes, loops again.  If hold,
                                                //changes players, loops again.
                {
                    scores[index] += currentTurnScore;
                    currentTurnScore = 0;
                    if (index == 1)
                        index = 0;
                    else
                        index ++;
                }
            }
            
            else if (result == 777)			//Rolled one 1.
            {
                currentTurnScore = 0;			//Clear turn score
                
                System.out.println("Hit enter to switch players: ");
                answer = keyboard.nextLine();
                
                if (index == 1)                         //Change players
                {
                    index = 0;
                }
                else
                {
                    index ++;
                }
            }
            else if (result == 666)			//Rolled two 1's.
            {
                currentTurnScore = 0;			//Clear turn score
                scores[index] = 0;			//Clear players overall score                
                
                System.out.println("Hit enter to switch players: ");
                answer = keyboard.nextLine();
                
                if (index == 1)
                {
                    index = 0;
                }
                else
                {
                    index ++;
                }
            }
            else					//Rolled double numbers (not ones)
            {
                currentTurnScore += play.totalGetter();
                System.out.println("You rolled doubles! You must roll again. ");
            }
        
            //Check for winner and display message to congratulate winner!
            if (scores[0] >= 100)
            {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Congratulations " + playerNames[0] + "! You WON!");
                System.out.println(" ");
                System.out.println("Thanks for playing!");
                System.out.println(" ");
                index = 2;
            }
            else if(scores[1] >= 100)
            {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Congratulations " + playerNames[1] + "! You WON!");
                System.out.println(" ");
                System.out.println("Thanks for playing!");
                System.out.println(" ");
                index = 2;
            }
        }      // end player turn loop        
    }		
}