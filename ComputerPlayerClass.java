public class ComputerPlayerClass 
{
    
    //create a private variable to hold the players name.
    private String name;
    
    //create a private variable to hold the players score.
    private int score = 0;
    
    
    /*create a setter method to set the users private name variable*/
    public void setName(String nameSet)
        {
            name = nameSet;
        }
    /*create a setter method to set the players score*/
    public void setScore(int scoreSet)
        {
            score = scoreSet;
        }
    /*create a getter method to allow the user to get the name*/
    public String getName(String nameGet)
        {
        nameGet = name;
        return nameGet;
        }
    /*create a getter method to allow the user to get the players score*/
    public int getScore(int scoreGet)
        {
            scoreGet = score;
            return scoreGet;
        }   
    /*create a method that makes the players score == 0*/
    public void clearScore()
    {
        int clear = 0;
        score = clear;
    }
    }
