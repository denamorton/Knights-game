
/**
 * Write a description of class Guess here.
 *
 * @math goddess
 * @B-level 
 */
public class Guess
{

    /**
     * Method checkGuess
     *
     * @param int g check that g is either 5 digits or -1
     * @return boolean returns false if g is illegal and true otherwise
     */
    public static boolean checkGuess(int g){
        if((10000<=g && g<100000)||(g==-1)){
            return true;
        }
        else{
            System.out.println("Error - your guess must be five digits. Nothing greater. Nothing less. Five.");
            return false;
        }
        //This one gave me so much issues! I wanted to be in the else-if, but it was going there 
        //even if I typed in -1.
        //So decided if it was -1 I would just return true
    }

    /**
     * Method countApples
     *
     * @param int guess is what the player guessed
     * @param secret is what the actual secret number is
     * 
     * @return int countApples returns the number of apples form this guess.
     * An apple is given when you have the correct digit number in the correct spot.
     */
    public static int countApples(int guess, int secret){
        int apples=0;
        String guessString = Integer.toString(guess);
        //this changes guess from an integer to a string. otherwise, .substring 
        //below will not work.
        String secretString = Integer.toString(secret);
        // this changes secret from an integer to a string.
        for(int i=0; i<5; i++){
            if (guessString.substring(i, i+1).equals(secretString.substring(i, i+1))) {
                //originally I had "==" rather than .equals, forgetting that 
                //.substring was looking at these numbers as Strings not ints.
                apples++;
            }
        }
        return apples;
    }

    /**
     * Method countOranges
     *
     * @param int guess is what the player guessed
     * @param secret is what the actual secret number is
     * 
     * @return int countOranges returns the number of oranges form this guess.
     * An orange is given when you have the correct digit number, but in the wrong spot
     */
    public static int countOranges(int guess, int secret){
        int oranges=0;
        String guessString = Integer.toString(guess);
        //this changes guess from an integer to a string. otherwise, .substring 
        //below will not work.
        String secretString = Integer.toString(secret);
        // this changes secret from an integer to a string.
        
        //here, oranges only count if the digit is correct but not in the same spot, so if i=j, we don't count that.
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if (guessString.substring(i, i+1).equals(secretString.substring(j, j+1))) {
                //originally I had "==" rather than .equals, forgetting that 
                //.substring was looking at these numbers as Strings not ints.
                    if(i!=j){
                        oranges++;
                    }
                }   
            }
  
        }
        return oranges;
    }
    
}
