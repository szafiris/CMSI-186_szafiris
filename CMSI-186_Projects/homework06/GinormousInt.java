/**
 *  File name     :  GinormousInt.java
 *  Purpose       :  Provides the methods for the GinormousInt class
 *  Author        :  Serena Zafiris
 *  Date          :  2017-04-09
 *  Description   :
 *  Notes         :
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-04-09  Serena Zafiris  Initial writing
 *  @version 1.0.1  2017-04-10  Serena Zafiris  Added Constructor and toString
 */

import java.lang.StringBuffer;

public class GinormousInt {
  /* Variables go here */
  /* zero */
  public static final GinormousInt ZERO = new GinormousInt( "0" );
  /* one */
  public static final GinormousInt ONE = new GinormousInt( "1" );
  /* ten */
  public static final GinormousInt TEN = new GinormousInt( "10" );
  private byte[] b = null;
  private String s = null;


  /* Constructor */
  public GinormousInt( String value ) {
    s = value;
    b = new byte[value.length()];
    int j = 0;
    for( int i = value.length() - 1; i >= 0; i-- ) {
      b[j] = Byte.parseByte( new Character( value.charAt(i) ).toString() );
      j++;
    }

  }

  /* Addition */
  public GinormousInt add( GinormousInt x ) {
    boolean carry = false;
    byte[] d = 0;
    byte[] answer = null;
    int count = b.length;
    if( b.length > x.b.length ) {
      count = x.b.length;
    }
    answer = new byte[count];
    for( int i = 0; i < b.length - 1; i++ ) {
      if( carry == false ) {
        answer[i] = b[i] + x.b[i];
        if ( answer[i] >= 10 ) {
          answer[i] = answer[i] - 10;
          carry = true;
        }
        carry = false;
      }
      if( carry == true ) {
        answer[i] = 1 + b[i] + x.b[i];
        if ( answer[i] >= 10 ) {
          answer[i] = answer[i] - 10;
          carry = true;
        }
        carry = false;
      }
    }
    return new GinormousInt("0");
  }

  /* Subtraction */
  public GinormousInt subtract( GinormousInt value ) {
    return new GinormousInt("0");
  }

  /* Multiplication */
  public GinormousInt multiply( GinormousInt value ) {
    return new GinormousInt("0");
  }

  /* Division */
  public GinormousInt divide( GinormousInt value ) {
    return new GinormousInt("0");
  }

  /* Remainder */
  public GinormousInt remainder( GinormousInt value ) {
    return new GinormousInt("0");
  }

  /* toString */
  public String toString() {
    return s;
  }

  public static String toString( GinormousInt value ) {
    return value.s;
  }


  /* compareTo */
  public int compareTo( GinormousInt x ) {
    return s.compareTo( x.s );
  }

  /* equals */
  public boolean equals( GinormousInt x ) {
    if ( s.length() != x.s.length() ) {
      return false;
    }
    for( int i = 0; i < s.length(); i++ ) {
      if ( s.charAt(i) != x.s.charAt(i) ) {
        return false;
      }
    }
    return true;
  }

  /* valueOf */

  /**
   * Method to return the reverse of a string passed as an argument
   *
   * @param value String containing the data to be reversed
   * @return  String containing the reverse of the input string
   */
   public static String reverse( String value ) {
     String reversedString =  "";
     for( int i = value.length() - 1; i >= 0; i--) {
       reversedString += Character.toString( value.charAt(i) );
     }
      return reversedString;
   }

}
