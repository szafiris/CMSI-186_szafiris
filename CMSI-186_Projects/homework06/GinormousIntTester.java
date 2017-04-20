/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  GinormousIntTester.java
 * Purpose    :  Test Harness for the GinormousInt java class
 * @author    :  B.J. Johnson
 * Date       :  2017-04-05
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:    Reason for change or modification
 *  -----  ----------  ------------    ---------------------------------------------------------------------
 *  1.0.0  2017-04-05  B.J. Johnson    Initial writing and release
 *  1.0.1  2017-04-10  Serena Zafiris  Added try catch loops
 *  1.0.2  2017-04-19  Serena Zafiris  Added tests for subtract, multiply, divide and remainder
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class GinormousIntTester {

   public GinormousIntTester() {
      super();
   }

   public static void main( String[] args ) {
      GinormousIntTester git = new GinormousIntTester();

      System.out.println( "\n  Hello, world, from the GinormousInt program!!\n" );

      System.out.println( "    TESTING CONSTRUCTOR AND CONSTANTS:\n" +
                          "    ==================================" );
      GinormousInt g1 = null;
      GinormousInt g2 = null;
      GinormousInt g3 = null;
      GinormousInt g4 = null;
      GinormousInt g5 = null;
      GinormousInt g6 = null;
      GinormousInt g7 = null;
      GinormousInt g8 = null;
      GinormousInt g9 = null;
      GinormousInt g10 = null;
      GinormousInt g11 = null;
      GinormousInt g12 = null;
      GinormousInt g13 = null;
      GinormousInt g14 = null;
      System.out.println( "    Making a new GinormousInt: " );
      try {
        g1 = new GinormousInt( "144127909719710664015092431502440849849506284148982076191826176553" );

        System.out.println( "      expecting: 144127909719710664015092431502440849849506284148982076191826176553\n" +
                            "        and got: " + g1.toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }

      System.out.println( "\n    Making a second new GinormousInt [same as first]: " );
      try {
        g2 = new GinormousInt( "144127909719710664015092431502440849849506284148982076191826176553" );
        System.out.println( "      expecting: 144127909719710664015092431502440849849506284148982076191826176553\n" +
                            "        and got: " + g2.toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Comparing equality of g1 and g2 with 'equals()': " );
      try {
        System.out.println( "      expecting: true\n" + "        and got: " + g1.equals( g2 ) );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Comparing g1 to g2 using compareTo: "  );
      try {
        System.out.println( "      expecting: 0\n" + "        and got: " + g1.compareTo( g2 ) );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Making a third new GinormousInt [differs at position 47    |]: " +
                          "\n                                                               v   " );
      try {
        g3 = new GinormousInt( "144127909719710664015092431502440849849506284108982076191826176553" );
        System.out.println( "      expecting: 144127909719710664015092431502440849849506284108982076191826176553\n" +
                            "        and got: " + g3.toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Comparing equality of g1 and g3 [detect different digit]: " );
      try {
        System.out.println( "      expecting: false\n" + "        and got: " + g1.equals( g3 ) );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Comparing g2 to g3 using compareTo: "  );
      try {
        System.out.println( "      expecting: a number greater than 0\n" + "        and got: " + g2.compareTo( g3 ) );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Making a fourth new GinormousInt [same as g3 but truncated]: "  );
      try {
        g4 = new GinormousInt( "14412790971971066401509243150244084984950628410898207" );
        System.out.println( "      expecting: 14412790971971066401509243150244084984950628410898207\n" +
                            "        and got: " + g4.toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Comparing equality of g3 and g4 [detect different length prior to detecting different digit]: " );
      try {
        System.out.println( "      expecting: false\n" + "        and got: " + g3.equals( g4 ) );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Comparing g3 to g4 using compareTo: "  );
      try {
        System.out.println( "      expecting: 13\n" + "        and got: " + g3.compareTo( g4 ) );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Making a fifth new GinormousInt, checking GinormousInt.ZERO: "  );
      try {
        g5 = new GinormousInt( "0" );
        System.out.println( "      expecting: " + GinormousInt.ZERO + "\n" +
                            "        and got: " + g5.toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Making a sixth new GinormousInt, checking GinormousInt.ONE: "  );
      try {
        g6 = new GinormousInt( "1" );
        System.out.println( "      expecting: " + GinormousInt.ONE + "\n" +
                            "        and got: " + g6.toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Making a seventh new GinormousInt, checking GinormousInt.TEN: "  );
      try {
        g7 = new GinormousInt( "10" );
        System.out.println( "      expecting: " + GinormousInt.TEN + "\n" +
                            "        and got: " + g7.toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Making a eighth new GinormousInt, calling add method: "  );
      try {
        g8 = new GinormousInt( "10" );
        System.out.println( "      expecting: 144127909719710664015092431502440849849506284148982076191826176563 and got " + g8.add( g1 ) );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Calling add method: "  );
      System.out.println( "\n    Adding 43 + 29: "  );
      try {
        g9 = new GinormousInt("43");
        g10 = new GinormousInt("29");
        System.out.println( "      expecting: 72" + "\n" +
                            "        and got: " + g9.add(g10).toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Adding 43 + - 29: "  );
      try {
        g9 = new GinormousInt("43");
        g10 = new GinormousInt("-29");
        System.out.println( "      expecting: 14" + "\n" +
                            "        and got: " + g9.add(g10).toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Adding -43 + -23: "  );
      try {
        g9 = new GinormousInt("-43");
        g10 = new GinormousInt("-29");
        System.out.println( "      expecting: -72" + "\n" +
                            "        and got: " + g9.add(g10).toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      // try {
      //   g9 = new GinormousInt("-43");
      //   g10 = new GinormousInt("29");
      //   System.out.println( "      expecting: -14" + "\n" +
      //                       "        and got: " + g9.add(g10).toString() );
      // }
      // catch( UnsupportedOperationException uoe ) {
      //   System.out.println( "Unsupported Operation " );
      // }
      System.out.println( "\n    Adding 99345 + 798: "  );
      try {
        g11 = new GinormousInt("999345");
        g12 = new GinormousInt("798");
        System.out.println( "      expecting: 1000143" + "\n" +
                            "        and got: " + g11.add(g12).toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Adding 999345 to 798: "  );
      try {
        g11 = new GinormousInt("999345");
        g12 = new GinormousInt("798");
        System.out.println( "      expecting: 1000143" + "\n" +
                            "        and got: " + g12.add(g11).toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    Calling subtract method: "  );
      System.out.println( "\n    999345 - 798: "  );
      try {
        g11 = new GinormousInt("999345");
        g12 = new GinormousInt("798");
        System.out.println( "      expecting: 998547" + "\n" +
                            "        and got: " + g11.subtract(g12).toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    798 - 999345: "  );
      try {
        g11 = new GinormousInt("999345");
        g12 = new GinormousInt("798");
        System.out.println( "      expecting: -998547" + "\n" +
                            "        and got: " + g12.subtract(g11).toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    -999345 - -798: "  );
      try {
        g11 = new GinormousInt("-999345");
        g12 = new GinormousInt("-798");
        System.out.println( "      we are expecting: -998547" + "\n" +
                            "        and got: " + g12.subtract(g11).toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n    10 - 14: "  );
      try {
        g11 = new GinormousInt("10");
        g12 = new GinormousInt("14");
        System.out.println( "      we are expecting: -4" + "\n" +
                            "        and got: " + g11.subtract(g12).toString() );
      }
      catch( UnsupportedOperationException uoe ) {
        System.out.println( "Unsupported Operation " );
      }
      System.out.println( "\n\n    TESTING MULTIPLY() METHOD:\n" +
                         "    ==========================" );
     System.out.println( "\n       Multiplying g13 by g14 [10 * 20]: " );
     try {
       g13 = new GinormousInt("10");
       g14 = new GinormousInt("20");
        System.out.println( "      expecting: 200\n" +
                            "        and got: " + g13.multiply( g14 ) );
     }
     catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
    //  System.out.println( "\n      Test 046: Multiplying g13 by g14 [-10 * 20]: " );
    //  try {
    //    g13 = new GinormousInt("-10");
    //    g14 = new GinormousInt("20");
    //     System.out.println( "      expecting: -200\n" +
    //                         "        and got: " + g13.multiply( g14 ) );
    //  }
    //  catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
    //  System.out.println( "\n      Test 047: Multiplying g13 by g14 [10 * -20]: " );
    //  try {
    //    g13 = new GinormousInt("10");
    //    g14 = new GinormousInt("-20");
    //     System.out.println( "      expecting: -200\n" +
    //                         "        and got: " + g13.multiply( g14 ) );
    //  }
    //  catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
    //  System.out.println( "\n      Test 048: Multiplying g13 by g14 [-10 * -20]: " );
    //  try {
    //    g13 = new GinormousInt("-10");
    //    g14 = new GinormousInt("-20");
    //     System.out.println( "      expecting: 200\n" +
    //                         "        and got: " + g13.multiply( g14 ) );
  //   }
    // catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
     System.out.println( "\n\n    TESTING DIVIDE() METHOD:\n" +
                        "    ==========================" );
     try {
       g13 = new GinormousInt("10");
       g14 = new GinormousInt("20");
        System.out.println( "      expecting: 2\n" +
                            "        and got: " + g14.divide( g13 ) );
     }
     catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
     System.out.println( "\n\n    TESTING REMAINDER() METHOD:\n" +
                        "    ==========================" );
     try {
       g13 = new GinormousInt("10");
       g14 = new GinormousInt("20");
        System.out.println( "      expecting: 0\n" +
                            "        and got: " + g14.remainder( g13 ) );
     }
     catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      System.exit( 0 );
   }
}
