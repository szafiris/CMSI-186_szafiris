/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  A dice rolling game
 *  @author       :  Serena Zafiris
 *  Date          :  2017-02-14
 *  Description   :  This game allows the user to try and get the highest score possible from rolling multiple die.
 *                   The user cann roll all the die, roll just one, calculate their score, and see their dice.
 *                   They can also set the amount of die and the number of sides.
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:      Reason for change/modification
 *           -----  ----------  ------------      -----------------------------------------------------------
 *  @version 1.0.0  2017-02-21  Serena Zafiris    Initial writing
 *  @version 1.0.1  2017-02-22  Serena Zafiris    Fixed methods and character errors
 *  @version 1.0.2  2017-02-23  Serena Zafiris    Displayed score properly
 *  @version 1.0.3  2017-02-23  Serena Zafiris    Fixed input errors
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
/** must input sides and count when calling program
 *  example: java Highroll count sides
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class HighRoll {
  public static void main( String args[] ) {
    int count = Integer.parseInt( args[0] );
    int sides = Integer.parseInt( args[1] );
    int highScore = 0;
    DiceSet ds = new DiceSet(count, sides);
    BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
        System.out.println( "\n   Welcome to the HighRoll Game\n" + "1. Roll all the dice\n" +
        "2. Roll a single die (command position)\n" + "3. Calculate the score for this set\n" + "4. Save score to highscore\n" +
        "5. Display the highscore\n" );
        System.out.println( "     Press the 'q' key to quit the program." );
        System.out.print( ">>" );
        String inputLine = null;
        try {
          inputLine = input.readLine();
          while( 0 == inputLine.length() ) {
             System.out.println( "Please enter some text!" );;
             System.out.print( ">>" );
             inputLine = input.readLine();
          }
          System.out.println( "   You typed: " + inputLine );
          if( 'q' == inputLine.charAt(0) ) {
            System.out.println( "You quit the program. Game over! Final Score: " + highScore );
             break;
          }         }
        catch( IOException ioe ) {
          System.out.println( "Caught IOException" );
        }
        if( inputLine.charAt(0) == '1' ) {
          ds.roll();
          System.out.println( ds.toString() );
         }
        if( inputLine.charAt(0) == '2' ) {
          ds.rollIndividual( Character.getNumericValue( inputLine.charAt(2) ) );
          System.out.println( ds.toString() );
        }
        if( inputLine.charAt(0) == '3' ) {
          System.out.println( "Score for this set : " + ds.sum() );
        }
        if( inputLine.charAt(0) == '4' ) {
          highScore = ds.sum();
        }
        if( inputLine.charAt(0) == '5' ) {
          System.out.println("Your highscore is: " + highScore);
        }
      }
   }
}
