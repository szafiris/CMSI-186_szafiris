/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuffTester.java
 *  Purpose       :  A test harness file for testing out the methods in the "StringStuff.java" class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-25
 *  Author        :  Serena Zafiris
 *  Date          :  2017-02-02
 *  Description   :  This file provides the "test harness" for checking out the methods which are part of
 *                   the homework02 assignment.  It also provides examples of proper documentation, and
 *                   uses the source file header template as specified in the "Greeter.java" template file
 *                   for use in CMSI 186, Spring 2017.
 *  Notes         :  TEMPLATE FILE ONLY: Your job is to fill in as many test cases as you think are needed
 *                   to thoroughly and completely test your StringStuff class.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-01-25  B.J. Johnson    Initial writing and release
 *  @version 1.1.0  2017-02-02  Serena Zafiris  Added tests for containsVowel
 *  @version 1.2.0  2017-02-07  Serena Zafiris  Added tests for rest of methods
 *  @version 1.2.1  2017-02-08  Serena Zafiris  Added tests to containsVowel, isPalindrome & reverse
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class StringStuffTester {

  /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
   public static void main ( String [] args ) {

      test_containsVowel();      // 10
      test_isPalindrome();       // 10
      test_evensOnly();          // 5
      test_oddsOnly();           // 5
      test_evensOnlyNoDupes();   // 5
      test_oddsOnlyNoDupes();    // 5
      test_reverse();            // 7
   }

  /**
   * test method to test out the operation of the containsVowel method
   */
   public static void test_containsVowel() {
     System.out.println("TEN TESTS FOR CONTAINSVOWEL");
     System.out.print( "   Test for string AAA " );
     try { System.out.println( StringStuff.containsVowel( "AAA" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string BBB " );
     try { System.out.println( StringStuff.containsVowel( "BBB" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string Grrrr " );
     try { System.out.println( StringStuff.containsVowel( "Grrrr" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string BAB " );
     try { System.out.println( StringStuff.containsVowel( "BAB" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string BBE " );
     try { System.out.println( StringStuff.containsVowel( "BBE" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string BYB " );
     try { System.out.println( StringStuff.containsVowel( "BYB" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 1io " );
     try { System.out.println( StringStuff.containsVowel( "1io" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 222 " );
     try { System.out.println( StringStuff.containsVowel( "222" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for empty string " );
     try { System.out.println( StringStuff.containsVowel( "" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string The kids are alright " );
     try { System.out.println( StringStuff.containsVowel( "The kids are alright" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the isPalindrome method
   */
   public static void test_isPalindrome() {
     System.out.println("TEN TESTS FOR ISPALINDROME");
     System.out.print("   Test for string Stars " );
     try { System.out.println( StringStuff.isPalindrome( "Stars" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string Beyonce " );
     try { System.out.println( StringStuff.isPalindrome( "Beyonce" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string Madam Im Adam " );
     try { System.out.println( StringStuff.isPalindrome( "Madam Im Adam" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string A " );
     try { System.out.println( StringStuff.isPalindrome( "A" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for empty string " );
     try { System.out.println( StringStuff.isPalindrome( "" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string Bathtub " );
     try { System.out.println( StringStuff.isPalindrome( "Bathtub" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string A dog a panic in the pagoda " );
     try { System.out.println( StringStuff.isPalindrome( "A dog a panic in the pagoda" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 11211 " );
     try { System.out.println( StringStuff.isPalindrome( "11211" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 1 " );
     try { System.out.println( StringStuff.isPalindrome( "1" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 12 " );
     try { System.out.println( StringStuff.isPalindrome( "12" ) ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the evensOnly method
   */
   public static void test_evensOnly() {
     System.out.println("FIVE TESTS FOR EVENSONLY");
     System.out.print( "   Test for string AaA " );
     try { System.out.println( StringStuff.evensOnly( "AaA" ).equals("") ? "true" : "false"); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string BYB " );
     try { System.out.println( StringStuff.evensOnly( "BYB" ).equals("BB") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string Hello World " );
     try { System.out.println( StringStuff.evensOnly( "Hello World" ).equals("HLLRLD") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for empty string  " );
     try { System.out.println( StringStuff.evensOnly( "" ).equals("") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 113 " );
     try { System.out.println( StringStuff.evensOnly( "113" ).equals("") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the oddsOnly method
   */
   public static void test_oddsOnly() {
     System.out.println("FIVE TESTS FOR ODDSONLY");
     System.out.print( "   Test for string AaA1 " );
     try { System.out.println( StringStuff.oddsOnly( "AaA1" ).equals("AAA") ? "true" : "false"); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string BYB " );
     try { System.out.println( StringStuff.oddsOnly( "BYB" ).equals("Y") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string Hello World " );
     try { System.out.println( StringStuff.oddsOnly( "Hello World" ).equals("EOWO") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for empty string  " );
     try { System.out.println( StringStuff.oddsOnly( "" ).equals("") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 113 " );
     try { System.out.println( StringStuff.oddsOnly( "113" ).equals("") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the evensOnlyNoDupes method
   */
   public static void test_evensOnlyNoDupes() {
     System.out.println("FIVE TESTS FOR EVENSONLYNODUPES");
     System.out.print( "   Test for string AaA1 " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "AaA1" ).equals("") ? "true" : "false"); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string BYB " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "BYB" ).equals("B") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string Hello World " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "Hello World" ).equals("HLRD") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for empty string  " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "" ).equals("") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 113 " );
     try { System.out.println( StringStuff.evensOnlyNoDupes( "113" ).equals("") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

  /**
   * test method to test out the operation of the oddsOnlyNoDupes method
   */
   public static void test_oddsOnlyNoDupes() {
     System.out.println("FIVE TESTS FOR ODDSONLYNODUPES");
     System.out.print( "   Test for string AaA " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "AaA" ).equals("A") ? "true" : "false"); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string BYB " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "BYB" ).equals("Y") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string Hello World " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "Hello World" ).equals("EOW") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for empty string  " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "" ).equals("") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 113 " );
     try { System.out.println( StringStuff.oddsOnlyNoDupes( "113" ).equals("") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }


  /**
   * test method to test out the operation of the reverse method
   */
   public static void test_reverse() {
     System.out.println("SEVEN TESTS FOR REVERSE");
     System.out.print( "   Test for string Please help " );
     try { System.out.println( StringStuff.reverse( "Please help" ).equals("pleh esaelP") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string Java is picky 113 " );
     try { System.out.println( StringStuff.reverse( "Java is picky 113" ).equals("311 ykcip si avaJ") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string a " );
     try { System.out.println( StringStuff.reverse( "a" ).equals("a") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for empty string  " );
     try { System.out.println( StringStuff.reverse( "" ).equals("") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string A really long sentence " );
     try { System.out.println( StringStuff.reverse( "A really long sentence" ).equals("ecnetnes gnol yllaer A") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 123 " );
     try { System.out.println( StringStuff.reverse( "123" ).equals("321") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
     System.out.print( "   Test for string 1 " );
     try { System.out.println( StringStuff.reverse( "1" ).equals("1") ? "true" : "false" ); }
     catch( Exception e ) { System.out.println ( false ); }
   }

}
