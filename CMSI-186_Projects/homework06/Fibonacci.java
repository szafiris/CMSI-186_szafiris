/**
 *  File name     :  Fibonacci.java
 *  Purpose       :  Finds fibonacci numbers
 *  Author        :  Serena Zafiris
 *  Date          :  2017-04-15
 *  Description   :
 *  Notes         :
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-04-15  Serena Zafiris  Initial writing
 */

 public class Fibonacci {
  public Fibonacci ( String[] args ) {
    super();
  }

  public void handleInitialArguments( String[] args ) {
    System.out.println( "\nHello world, from the Fibonacci program!!\n\n" ) ;
    if( 0 == args.length ) {
      System.out.println( "   Sorry you must enter a number \n" +
                          "   Usage: java Fibonacci number\n" +
                          "   Please try again..........." );
      System.exit( 1 );
    }
    if( args.length > 1 ) {
      System.out.println( "   Sorry you must enter a single number \n" +
                          "   Usage: java Fibonacci number\n" +
                          "   Please try again..........." );
      System.exit( 1 );
    }
    for( int i = 0; i < args.length; i++ ) {
      int a = 0;
      try{
        a = Integer.parseInt( args[i] );
      } catch( NumberFormatException nfe) {
        System.out.println( "Please enter in numbers only " );
      }
    }
  }

  public static void main( String[] args ) {
    Fibonacci f = new Fibonacci( args );
    f.handleInitialArguments( args );
    int count = Integer.parseInt( args[0] );
    GinormousInt n1 = new GinormousInt( "0" );
    GinormousInt n2 = new GinormousInt( "1" );
    GinormousInt n3 = new GinormousInt( "1" );
    for( int i = 3; i <= count; i++ ) {
      n3 = n1.add(n2);
      n1 = n2;
      n2 = n3;

    }
    System.out.println( "The number is: " + n3 );
  }
}
