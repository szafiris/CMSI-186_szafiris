/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Serena Zafiris
 *  Date          :  2017-02-14
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getSides()                      // get the number of sides on this die
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-02-06  B.J. Johnson    Initial writing and release
 *  @version 1.0.1  2017-02-14  Serena Zafiris  Worked on Die and roll
 *  @version 1.1.0  2017-02-17  B.J. Johnson    Filled in method code
 *  @version 1.1.2  2017-02-20  Serena Zafiris  Added Die, roll, getValue and tooString
 *  @version 1.1.3  2017-02-23  Serena Zafiris  Finished tester
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int dieRoll;
   private final int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws       IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
  public Die( int nSides ) {
    if( nSides < MINIMUM_SIDES ) {
      throw new IllegalArgumentException();
    }
    sides = nSides;
    dieRoll = 1;
  }

  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   public int roll() {
      this.dieRoll = (int)Math.floor( Math.random() * sides + 1 );
      return this.dieRoll;
   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   *  the count is determined is left as a design decision to the programmer
   *  For example, what about a four-sided die - which face is considered its
   *  "value"?
   * @return the pip count of THIS die instance
   */
  public int getValue() {
      return this.dieRoll;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
  public void setSides( int sides ) {
    if( sides < MINIMUM_SIDES ) {
      throw new IllegalArgumentException();
    }
    this.sides = sides;
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
  public String toString() {
      return "[" + this.dieRoll + "]";
   }

   /**
    * @return Public instance method that returns a String representation of just the number of the Die
    */
  public String toNumberString() {
    return Integer.toString( this.dieRoll );
  }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
  public static String toString( Die d ) {
      return "[" + d.getValue() + "]";
   }

  public void setValue( int value ) {
    dieRoll = value;
  }

  /**
   * A little test main to check things out
   */
  public static void main( String[] args ) {
      System.out.println( "Hello world from the Die class..." );
      System.out.println();
      System.out.println( "Creating a two sided die" );
      try{
        Die d1 = new Die(2);
      }
      catch( IllegalArgumentException IAE ) {
        System.out.println( "Cannot make a die with two sides" );
      }
      System.out.println();
      System.out.println( "Making an 8 sided die" );
      Die d = new Die(8);
      System.out.println();
      System.out.println( "Rolling the 8 sided die 12 times" );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println();
      System.out.println( "Testing getValue" );
      System.out.println( d.getValue() );
      System.out.println();
      System.out.println( "Testing toString (instance)" );
      System.out.println( d.toString() );
      System.out.println();
      System.out.println( "Testing toString (class)" );
      System.out.println( Die.toString(d) );
      System.out.println();
      System.out.println( "Testing toNumberString" );
      System.out.println( d.toNumberString() );
      System.out.println();
      System.out.println( "Testing setValue (setting to 4)" );
      d.setValue(4);
      System.out.println( d.toString() ) ;
      System.out.println();
      System.out.println( "Tests for switching to a 5 sided die" );
      d.setSides(5);
      System.out.println();
      System.out.println( "Rolling the 5 sided die 8 times" );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println( d.roll() );
      System.out.println();
      System.out.println( "Testing getValue" );
      System.out.println( d.getValue() );
      System.out.println();
      System.out.println( "Testing toString (instance)" );
      System.out.println( d.toString() );
      System.out.println();
      System.out.println( "Testing toString (class)" );
      System.out.println( Die.toString(d) );
      System.out.println();
      System.out.println( "Testing toNumberString" );
      System.out.println( d.toNumberString() );
      System.out.println();
      System.out.println( "Testing setValue (setting to 3)" );
      d.setValue(3);
      System.out.println( d.toString() ) ;
      System.out.println();
      System.out.println( "Switching to a die with 3 sides" );
      try {
        d.setSides(3);
      }
      catch( IllegalArgumentException IAE ) {
        System.out.println( "Cannot make a die with three sides" );
      }
   }
}
