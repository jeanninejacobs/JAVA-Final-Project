import java.util.Scanner;

/**
*	This is a muli-player Two Dice Pig game.
*
*	@author Jeannine Jacobs
*/

public class TwoDicePigMain					//class name
{
	public static void main(String[] args)	//main class
	{

		int players;								//to hold user choice to play against person or computer
		String playerOne, playerTwo;				//to hold player names
		int [] scores = new int[2];					//to hold player scores
		int playerOneScore = scores[0];				//to reference player one's score from array
		int playerTwoScore = scores[1];				//to reference player two's score from array

		String answer;								//to hold user choice to view game rules


		//Create a Scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);

		//Create a Game Class object for game play
		TwoDicePig play = new TwoDicePig();

		//Ask user to create players
		System.out.print("Would you like to play against a real person or the computer? Enter 1 = player or 2 = computer");
		players = keyboard.nextInt();

		//Create player objects and set names
		System.out.print("What is Player One's name? ");
		playerOne = keyboard.nextLine();
		PlayerClass ONE = new PlayerClass(playerOne);

		if ( players == 1)
		{
			System.out.print("What is Player Two's name? ");
			playerTwo = keyboard.nextLine();

			System.out.print("Welcome " + playerOne + " and " + playerTwo + "!");
		}
		else
		{
			System.out.print("Please enter a name for the computer player: ");
			computerPlayer = keyboard.nextLine();
			PlayerClass computer = new PlayerClass();

			System.out.println("Welcome " + playerOne + " get ready to play against " + computerPlayer + "!");
		}

		System.out.println("Would you like to read the rules of the game before you play? Y or N ");
		answer = keyboard.nextLine();

		if (answer.equalsIgnoreCase("y"))
		{
			//display rules from file
			System.out.println("Rules for Two Dice Pig Game");
			System.out.println(" ");
			System.out.println("Each turn, a player repeatedly rolls two dice until either a 1 is rolled or the player decides to 'hold':");
			System.out.println(" ");
			System.out.println("--> If neither shows a 1, their sum is added to the turn total. Player can hold or roll again.");
			System.out.println("--> If a double is rolled, the point total is added to the turn total as with any roll but the player is"
										+ " obligated to roll again.");
			System.out.println("--> If a single 1 is rolled, the player scores nothing and the turn ends.");
			System.out.println("--> If two 1s are rolled, the player�s entire score is lost, and the turn ends.");
			System.out.println(" ");
			System.out.println("The first player to score 100 or more points wins");
			System.out.println(" ");

			System.out.print("When you are ready to play, hit any key, then enter. ");
			answer = keyboard.nextLine();
		}

		System.out.println(playerOne + "will roll first ");

		int currentPlayer = 1; 		//to hold the player whose currently playing their turn

		//--------------------------------------Game play loop---------------------------------------------------


		for (int index = 0; index <= 1;)			//loop to change player turn
		{

			while (playerOneScore < 100 || playerTwoScore < 100)
			{
				boolean playOK = true;		// to know if the current player can roll the die
				int currentTurnScore = 0;

				while (playOK)
				{
					play.totalsetter(0);
					int result = play.rolldie();

					if (result <= 12)					//Valid roll
					{
						currentTurnScore += result;		//Add score to turn total and ask if player wants to roll again.
						System.out.print("You rolled " + result + ". Would you like to play again? 1 = roll again, 2 = hold ");
						int playAgain = keyboard.nextInt();
						if (playAgain == 2)
						{
							currentPlayerScore += currentTurnScore;
							playOK = False;
							if (index == 1)
								index = 0;
							else
								index ++;
						}
					}
					else if (result == 777)				//Rolled one 1.
					{
						currentTurnScore = 0;			//Clear turn score
						playOK = false;					//Change players
						if (index == 1)
							index = 0;
						else
							index ++;
					}
					else if (result == 666)				//Rolled two 1's.
					{
						currentTurnScore = 0;			//Clear turn score
						currentPlayerScore = 0;			//Clear players overall score
						playOK = false;					//Change platers
						if (index == 1)
							index = 0;
						else
							index ++;
					}
					else								//Rolled double numbers (not ones)
					{
						System.out.print("You rolled doubles! You must roll again. ");
					}
				}		// end player turn loop
			}		// end overall score checking loop

			//Display message to congratulate winner!
			if (playerOneScore >= 100)
			{
				System.out.println("Congratulations " + playerOne + "! You WON!");
				index = 2;
			}
			else
			{
				System.out.println("Congratulations " + playerTwo + "! You WON!");
				index = 2;
			}

				System.out.println(" ");
				System.out.println("Thanks for playing!");
				System.out.println(" ");
				index = 2;
			}
		}		//end player turn
	}		// end main class
}		//end public class