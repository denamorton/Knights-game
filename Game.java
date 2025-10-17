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

    /**
     * Constructor for objects of class Game
     */
    //D-level #10
    public Game()
    {
        scan = new Scanner(System.in);
    }

    /**
     * Another Constructor for objects of class Game
     * 
     * @param Scanner s
     */
    //D-level #11
    public Game(Scanner s)
    {
        scan = s;
    }
    
    /**
     * Get method for scan
     */
    //D-level #12
    public Scanner getScan()
    {
        return scan;
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
        Round round = new Round(scan);
        //I always forget how to declare a new object  - like here, I originally
        //had round = new Round(scan); Bah.
        round.play();
        //also, originally, I had play(round), which was just stupid.
    }
}
