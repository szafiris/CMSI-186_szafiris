/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Serena Zafiris
 *  Date          :  2017-02-20
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson    Initial writing and release
 *  @version 1.0.0  2017-02-20  Serena Zafiris  Added DiceSet
 *  @version 1.0.1  2017-02-21  Serena Zafiris  Added roll, toString, sum, rollIndividual & getIndividual
 *  @version 1.0.2  2017-02-21  Serena Zafiris  Fixed methods and added toString
 *  @version 1.0.2  2017-02-23  Serena Zafiris  Fixed isIdentical and added tester
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
  public DiceSet( int count, int sides ) {
    this.count = count;
    if( count < 1 ) {
      throw new IllegalArgumentException();
    }
    ds = new Die[ count ];
    for( int i = 0; i < count; i++ ) {
      ds [i] = new Die(sides);
    }
   }

  /**
   * @return the sum of all the dice values in the set
   */
  public int sum() {
    int sum = 0;
    for(int i = 0; i < this.count; i++){
      sum = sum + ds[i].getValue();
    }
    return sum;
 }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
     for( int i = 0; i < this.count; i++ ) {
       ds[i].roll();
     }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
     if( dieIndex > this.count ) {
       throw new IllegalArgumentException("That die does not exist in your set");
     }
     dieIndex = dieIndex - 1;
     return ds[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
     if( dieIndex > this.count ) {
       throw new IllegalArgumentException("That die does not exist in your set");
     }
     dieIndex = dieIndex - 1;
     return ds[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
  public String toString() {
    String result = "";
    for(int i = 0; i < this.count; i++) {
      result = result + ds[i].toString();
    }
    return result;
  }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
     String result = "";
     result = ds.toString();
     return result;
   }

   public String toNumberString() {
     String result = "";
     for(int i = 0; i < this.count; i++) {
       result = result + ds[i].toNumberString();
     }
     return result;
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
  public boolean isIdentical( DiceSet ds2 ) {
    int max = this.count;
    StringBuffer ds1String = new StringBuffer( this.toNumberString() );
    StringBuffer ds2String = new StringBuffer( ds2.toNumberString() );
    if( this.sides == ds2.sides && this.count == ds2.count ) {
      for(int i = 0; i < max; i++) {
        for(int j = 0; j < this.count; j++) {
          System.out.println("i = " + i + " j = " + j);
          if( ds1String.charAt(i) == ds2String.charAt(j) ) {
            ds2String.deleteCharAt(j);
            this.count--;
            break;
          }
        }
      }
    }
    if( ds2String.length() == 0 ) {
      return true;
    } else {
    return false;
  }
  }
  /**
   * A little test main to check things out
   */
  public static void main( String[] args ) {
    System.out.println( "Hello. Welcome to the DiceSet class..." );
    System.out.println( "Creating the DiceSet" );
    DiceSet ds = new DiceSet(5, 6);
    System.out.println( ds.toString() );
    System.out.println( "Test for roll" );
    ds.roll();
    System.out.println( ds.toString() );
    System.out.println( "Test for sum" );
    System.out.println( ds.sum() );
    System.out.println( "Test for getIndividual: Getting the third die value" );
    try {
      System.out.println( ds.getIndividual(3) );
    }
    catch( IllegalArgumentException IAE) {
      System.out.println( "Die out of range" );
    }
    System.out.println( "Test for getIndividual with an out of range parameter" );
    try {
      ds.getIndividual(7);
    }
    catch( IllegalArgumentException IAE) {
      System.out.println( "Die out of range" );
    }
    System.out.println( "Test for toString (instance)" );
    System.out.println( ds.toString() );
    System.out.println( "Test for String (class)" );
    System.out.println( DiceSet.toString(ds) );
    System.out.println( ds.sum() );
    ds.rollIndividual(3);
    System.out.println( DiceSet.toString(ds) );
    System.out.println( ds.getIndividual(4) );
    System.out.println( "Test for isIdentical" );
    DiceSet ds1 = new DiceSet( 4, 6 );
    DiceSet ds2 = new DiceSet( 4, 6 );
    System.out.println( "Using setValue to create DiceSets" );
    ds1.ds[0].setValue(2);
    ds1.ds[1].setValue(3);
    ds1.ds[2].setValue(7);
    ds1.ds[2].setValue(2);
    ds2.ds[0].setValue(3);
    ds2.ds[1].setValue(2);
    ds2.ds[2].setValue(7);
    ds2.ds[2].setValue(2);
    System.out.println( ds1.isIdentical(ds2) + " Correct" );
    System.out.println( "Second Test for isIdentical" );
    DiceSet ds3 = new DiceSet( 3, 6 );
    DiceSet ds4 = new DiceSet( 3, 6 );
    ds3.ds[0].setValue(2);
    ds3.ds[1].setValue(4);
    ds3.ds[2].setValue(7);
    ds4.ds[0].setValue(3);
    ds4.ds[1].setValue(2);
    ds4.ds[2].setValue(7);
    System.out.println( ds3.isIdentical(ds4) + " Correct" );
  }

}
