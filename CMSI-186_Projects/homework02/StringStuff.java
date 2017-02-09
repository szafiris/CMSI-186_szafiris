/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-19
 *  Author        :  Serena Zafiris
 *  Date          :  2017-02-02
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson    Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson    Fill in methods to make the program actually work
 *  @version 1.1.2  2017-02-02  Serena Zafiris  Added containsVowel
 *  @version 1.2.0  2017-02-07  Serena Zafiris  Added rest of methods
 *  @version 1.2.1  2017-02-07  Serena Zafiris  Added catch for making an empty string a palindrome
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {

  /**
   * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
   * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
   * it gets included.
   *
   * @param s String containing the data to be checked for &quot;vowel-ness&quot;
   * @return  boolean which is true if there is a vowel, or false otherwise
   */
   public static boolean containsVowel( String s ) {
     for( int i = 0; i <  s.length(); i++ ) {
       switch( s.charAt(i) ) {
         case 'A': case 'a': case 'E': case 'e':
         case 'I': case 'i': case 'O': case 'o':
         case 'U': case 'u': case 'Y': case 'y':
         return true;
       }
     }
     return false;
   }

  /**
   * Method to determine if a string is a palindrome.  Does it the brute-force way, checking
   * the first and last, second and last-but-one, etc. against each other.  If something doesn't
   * match that way, returns false, otherwise returns true.
   *
   * @param s String containing the data to be checked for &quot;palindrome-ness&quot;
   * @return  boolean which is true if this a palindrome, or false otherwise
   */
   public static boolean isPalindrome( String s ) {
     s = s.toUpperCase();
     String palindrome = reverse(s);
     if(s == "") {
       return true;
     }
     for( int i = 0; i < s.length(); i++ ) {
       if ( s.charAt(i) == palindrome.charAt(i) ) {
         return true;
       } else {
         return false;
       }
     }
     return false;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
   * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input
   */
   public static String evensOnly( String s ) {
     s = s.toUpperCase();
     String evensString = "";
     for( int i = 0; i < s.length(); i++ ) {
       switch( s.charAt(i) ) {
         case 'B': case 'D': case 'F': case 'H':
         case 'J': case 'L': case 'N': case 'P':
         case 'R': case 'T': case 'V': case 'X':
         case 'Z':
         evensString += Character.toString( s.charAt(i) );
       }
     }
      return evensString;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
   * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input
   */
   public static String oddsOnly( String s ) {
     s = s.toUpperCase();
     String oddsString = "";
     for( int i = 0; i < s.length(); i++ ) {
       switch( s.charAt(i) ) {
         case 'A': case 'C': case 'E': case 'G':
         case 'I': case 'K': case 'M': case 'O':
         case 'Q': case 'S': case 'U': case 'W': case 'Y':
         oddsString += Character.toString( s.charAt(i) );
       }
     }
      return oddsString;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input without duplicates
   */
    public static String evensOnlyNoDupes( String s ) {
     s = s.toUpperCase();
     String evensString = evensOnly(s);
     String evensNoDupes = "";
     for( int i = 0; i < evensString.length(); i++ ) {
       if( !evensNoDupes.contains( Character.toString( evensString.charAt(i) ) ) ) {
         evensNoDupes += Character.toString( evensString.charAt(i) );
       }
     }
       return evensNoDupes;
    }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input without duplicates
   */
   public static String oddsOnlyNoDupes( String s ) {
     s = s.toUpperCase();
     String oddsString = oddsOnly(s);
     String oddsNoDupes = "";
     for( int i = 0; i < oddsString.length(); i++ ) {
       if( !oddsNoDupes.contains( Character.toString( oddsString.charAt(i) ) ) ) {
         oddsNoDupes += Character.toString( oddsString.charAt(i) );
       }
     }
       return oddsNoDupes;
   }

  /**
   * Method to return the reverse of a string passed as an argument
   *
   * @param s String containing the data to be reversed
   * @return  String containing the reverse of the input string
   */
   public static String reverse( String s ) {
     String reversedString =  "";
     for( int i = s.length() - 1; i >= 0; i--) {
       reversedString += Character.toString( s.charAt(i) );
     }
      return reversedString;
   }
}
