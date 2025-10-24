import java.util.Scanner;
import java.util.Random;
/**
 * Write a description of class Round here.
 *
 * @math goddess
 * @version D level
 * 
 * 
 * //I had a bunch of @param here, but not needed for instance variables.
 * //also only use @param if it has a variable in the parentheses of the method
 * 
 * This class plays one round of the game. It initializes all of the important instance 
 * variables needed here, such as the secret number (secret), the number of Guesses (numGuesses)
 * whether a player has won (win), or quit (quit), and starts the process for a scanner.
 * 
 * It also has getters for each of these five instance variables
 * 
 * Asks for player's guess, checks if guess wins or quits and prints out stats if so.
 * 
 * Prints apples and oranges to confirm digit guesses
 * 
 * Generates the secret number.
 * 
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
    //
    /**
     * Constructor for objects of class Round
     * It initializes everything for Round
     * 
     * @param Scanner s
     */
    //D-level #3
    public Round(Scanner s)
    {
        // initialise instance variables
        secret = generateSecret();
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
    
    /** method to enter a guess or -1 to quit. If the guess is not valid via checkGuess method, then it keeps asking until it is 
     * valid. If it is not -1,then numGuesses is incremented and guess is returned.
     * 
     *@return guess - it returns the player's guess as long as the guess isn't -1 and is 5 digits
     *
     */
    //D-level #5
    //B-level #4
    private int askForGuess()
    {   
        int guess=0;//need to declare guess outside of while statement so that the second part of the code for this
        //class can read it
        
        boolean validGuess=false;//to check that the guess is valid. the default is false.
        while(validGuess==false&&guess!=-1){
            System.out.println("Please enter your guess or enter -1 to quit.");
            guess=scan.nextInt();
            scan.nextLine();//to get the dang scanner to accept the next scan
            //we use this after scanning nextInt but not after scanning a nextLine
            
            //originally I didn't update validGuess, so it was stuck in an infinite loop.
            //BAHHHHHHHHHHHHHHHHHH!
            //stupid. 
            if(Guess.checkGuess(guess)==true){
                validGuess=true;
            }; 
            
            //I was only counting valid guesses! was supposed to count all guesses.
            //in the Guess class - determines if guess is valid
           
        }   
        
        //dummy comment. do. or do not. there is no try.
        
        if(guess==-1){
            quit = true;
        }
        //the guess ==-1 part gave me quite an issue. I believe is fixed now. 
        else{
            numGuesses++;
        }
            //note that -1 is a valid guess, but doesn't get counted in the number of guesses.

        return guess;
        }
    
    
    /**
     * method to check the guess g against the correct secret number
     * 
     * Prints out the correct number of apples and oranges to return
     * 
     * @param int g - this is the guess that will be checked 
     */
    //D-level #6
    //B-level #6
    private void checkWin(int g){
        if(g==secret){
                win = true;
            }
        
        else if(g!=-1)
        {
            int app = Guess.countApples(g, secret);
            //bah humbug. Originally I had g.countApples(g, secret), forgetting that I needed to call the "Guess"
            //class first. BAH. rookie mistake
            int ora = Guess.countOranges(g, secret);
            //and if I had actually looked at the directions, I would have seen this.
            
            printResults(app, ora);//prints results
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
     */
    public void play(){
        while(!win && !quit){
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
    
    /** method to print the number of apples and oranges from the guess. If nothing correct, prints nada
     * 
     * @param apples is the number of correct digits in correct places
     * @param oranges is the number of correct digits in the wrong places
     */
    //B-level #5
     private void printResults(int apples, int oranges){
        if(apples==0 && oranges ==0){
            System.out.println("Nada. Nothing. Zilch. Zero. Ephes.");
        }
        
        if(apples>0){
            for(int i=0; i<apples; i++){
                System.out.print("apple ");
            }
        }
        
        if(oranges>0){
            for(int i=0; i<oranges; i++){
                System.out.print("orange ");
            }
        }
        System.out.println("");
    }
    
    /** method to randomly generate the secret number
     * 
     * @return it returns the secret number.
     */
    //A-level #3/4
     private int generateSecret(){
         Random rng = new Random();   
         boolean check = false;
         int secretNum = 0;
         while(check==false){
                secretNum = rng.nextInt(100000)+1;
                check = Guess.hasUniqueDigits(secretNum);
            }
         return secretNum;
        }
    
}
