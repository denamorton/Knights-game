import java.util.Scanner;
/**
 * Write a description of class Game here.
 *
 * @author Math goddess
 * @version D-level
 */
public class Game
{
    // instance variables scanner
    private Scanner scan;
    //C-level #1
    private int numGuesses; 
    //to count the number of guesses made in rounds that are won
    private int numRoundsWon; //to count the rounds that are won
    private boolean quitGame; //to track if the player quit the game

    /**
     * Constructor for objects of class Game
     */
    //D-level #10
    public Game()
    {
        scan = new Scanner(System.in);
        //C-level #2
        numGuesses =0;
        numRoundsWon =0;
        quitGame = false;
        
        
    }

    /**
     * Another Constructor for objects of class Game
     * 
     * @param Scanner s
     */
    //D-level #11
    public Game(Scanner s)
    {
        scan = s;   //C-level #2
        numGuesses =0;
        numRoundsWon =0;
        quitGame = false;
        
    }
    
    /**
     * Get method for scan
     * @return scan
     */
    //D-level #12
    public Scanner getScan()
    {
        return scan;
    }
    
    /** Get method for numGuesses
     * @return numGuesses
     */
    //C-level #3
    public int getNumGuesses()
    {
        return numGuesses;
    }
    
    /** Get method for numRoundsWon
     * @return numRoundsWon
     */
    //C-level #3
    public int getNumRoundsWon()
    {
        return numRoundsWon;
    }
    
    /** Get method for numGuesses
     * @return quitGame
     */
    //C-level #3
    public boolean getQuitGame()
    {
        return quitGame;
    }
    
    /**
     * Create a new Round object using new Round(scan).
     * Recall that Round is the first class created for this program.
     * 
     * Call the method play() on the Round object.
     */
    //D-level #12
    public void play()
    {  
       //C-level #6
        
       while(quitGame==false){
            Round round = new Round(scan);
            //I always forget how to declare a new object  - like here, I originally
            // had round = new Round(scan); Bah.
            
            round.play();
            //also, originally, I had play(round), which was just stupid.
            
            boolean wonLost = round.getWin();
            //to see if the round was won.
            if(wonLost == true){
                numGuesses = numGuesses + round.getNumGuesses();
                //add the round's guesses to the total number of guesses
                numRoundsWon++;
                //increment the number of rounds won.
            }
            playAgain();
        
            System.out.println("Number of rounds won: " + numRoundsWon + 
            " Average number of guesses "+ getAverage());
        } 

}
    
    /**
     * Add a method to see if the player wants to play again.
     */
    //C-level #4
    private void playAgain(){
        System.out.println("Do you want to play again? y/n");
        String yn = scan.nextLine();
        if(yn.equals("n")){
            quitGame = true;
        }
    }
    
    /** Add a method to get the average number of guesses made over rounds 
     * that were won.
     * 
     * @return avg - it returns the average of the number of guesses per round
     */
    //C-level #5
    private double getAverage(){
        double avg = 0.0;
        if(numRoundsWon!=0){
            avg = (double) numGuesses/numRoundsWon;
            //I forgot that if we have an int/int that we would not get a double
            //but rather a round-down
        }
        return avg;
    }   
    
    
}