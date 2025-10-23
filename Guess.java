
/**
 * Write a description of class Guess here.
 *
 * This checks that a Guess is legal. 
 * 
 * C-level: Does three things: 
 *  1. checks that a guess has 5 digits or is -1, 
 *  2. returns the number of digits in right place and right number (apple) and
 *  3. returns the number of digits in wrong place and right number (orange)
 * 
 * In B-level,we can't have duplicated digits. 
 *  4. checks that each guess has no duplicated digits, by using the hasUniqueDigits class
 *  
 *
 *
 * @math goddess
 * @B-level 
 */
public class Guess
{

    /**
     * Method checkGuess checks that a guess has 5 digits
     *
     * @param int g this is the guess that the player entered
     * @return returns false if g is illegal and true otherwise
     * 
     *      In A-level returns false if:
     *          1. g doesn't have 5 digits
     *          2. g doesn't have unique digits
     * 
     */
    public static boolean checkGuess(int g){
        if(( (10000<=g && g<100000)||(g==-1) )&& hasUniqueDigits(g)==true ){
            return true;
        }
        else if(g<10000 || g>=100000) {
            System.out.println("Error - your guess must be five digits. Nothing greater. Nothing less. Five.");
            return false;
        }
        
        else{
            System.out.println("Error - your guess must have unique digits. They cannot match. Not at all.");
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
     * @return int countApples returns the number of apples from this guess.
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
        //
        
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
    
    //A-level #1
    /**
     * Method hasUniqueDigits 
     * This is a method that checks that the guess by the player has no repetition
     * 
     * @param num - this is what is being guessed by the player, and checked by this
     * method 
     * @return true if all 5 digits in num are unique, false otherwise.
     */
    
    //this one took me forever.
    //first of all, I didn't realize that the second for loop could start at j=0; j<i:
    //I thought that since when it starts, both i and j=0, and i isn't less than j
    //so I would get an error.
    
    //but no! when i=0, j=0, since j is not less than i, j++ doesn't happen!
    //then i=1 and j=0, and then j=1, etc...
    //I was trying to do this with i!=j etc. 
    public static boolean hasUniqueDigits(int num){
        String numString = Integer.toString(num);
            for(int i=0; i<5; i++){
                for(int j=0; j<i; j++){
                    String iSubstring=numString.substring(i,i+1);
                    String jSubstring=numString.substring(j,j+1);
                                   
                    if(iSubstring.equals(jSubstring)) {
                        return false;
                    }
                }   
            }
            return true;
        }
}

