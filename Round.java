import java.util.Scanner;
/**
 * Write a description of class Round here.
 *
 * @math goddess
 * @version D level
 * 
 * @param int secret to hold the secret number
 * @param int numGuesses to hold the number of guesses made by the player
 * @param boolean win to track if the player wins
 * @param boolean quit to track if the player quits
 * @param Scanner scan to scan for the player's inputs
 */
public class Round
{
    // private instance variables for Round class.
    //D-level#2
    private int secret;
    private int numGuesses;
    private boolean win;
    private boolean quit;
    private Scanner scan;

    /**
     * Constructor for objects of class Round
     * It initializes everything for Round
     */
    //D-level #3
    public Round(Scanner s)
    {
        // initialise instance variables
        secret = 12345;
        numGuesses =0;
        win = false;
        quit=false;
        scan=s;
    }

    /**
     * Get method for secret
     * @return secret
     */
    //D-level #4
    public int getSecret()
    {
        return secret;
    }
    
    /**
     * Get method for numGuesses
     * @return numGuesses
     */
    //D-level #4
    public int getNumGuesses()
    {
        return numGuesses;
    }
    
    /**
     * Get method for win
     * @return getWin()
     */
    //D-level #4
    public boolean getWin()
    {
        return win;
    }
    
    /**
     * Get method for quit
     * @return quit
     */
    //D-level #4
    public boolean getQuit()
    {
        return quit;
    }
    
    /**scan
     * Get method for secret
     * @return scan
     */
       //D-level #4
    public Scanner getScan()
    {
        return scan;
    }
    
    /** method to enter a guess or -1 to quit. If the guess is not -1,
     * then numGuesses is incremented and guess is returned.
     * 
     *@param int guess - place where the person playing the game enters their guess
     *@return guess
     */
    //D-level #5
    private int askForGuess()
    {
        System.out.println("Please enter your guess or enter -1 to quit.");
        int guess=scan.nextInt();
        if(guess==-1){
            quit = true;
        }
        else{
           numGuesses++;
           //if you input -1, that doesn't actually count as a guess.
        }
        return guess;
    }
    
    /**
     * method to check the guess g against the correct secret number
     * 
     * @param int g - this is the guess that will be checked 
     */
    //D-level #6
    private void checkWin(int g){
        if(g==secret){
            win = true;
        }
    }
    
    /**
     * method to add a loop that will iterate until number is guessed (which 
     * occurs when win is true)or until the player decides to quit (which 
     * occurs when quit is true).
     * 
     * If the guess is correct, it prints out the win with the number of guesses
     * If the player quit, it prints this out with the number of guesses
     * 
     * 
     */public void play(){
        while(!win==true && !quit == true){
            int guess = askForGuess(); //ask for the guess using the method above
            System.out.println("Your guess is: " + guess);
            checkWin(guess);//checks if the guess is correct
        }
        if(win==true){
            System.out.println("You won! Well done! It took you " + numGuesses
            + " guesses to finish this game!");
        }
        if(quit==true){
            System.out.println("Boo you! You quit. You used " + numGuesses
            + " guesses, just to quit!");
        }
    }
}
