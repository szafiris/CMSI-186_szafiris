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
 *  @version 1.0.1  2017-04-12  Serena Zafiris  Added Add
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
    byte[] answer = null;
    int count = b.length + 1;
    StringBuffer answerString = new StringBuffer( Math.max( b.length, x.b.length ) );
    if( b.length > x.b.length ) {
      count = x.b.length + 1;
    }
    /* Add loop */
    answer = new byte[count];
    for( int i = 0; i < b.length; i++ ) {
      if( carry == false ) {
        answer[i] = (byte)( (int) b[i] + (int)x.b[i] );
        if ( answer[i] >= 10 ) {
          answer[i] = (byte) ( (int) answer[i] - 10 );
          carry = true;
        }
      } else if( carry ) {
          answer[i] = (byte)( 1 + (int) b[i] + (int)x.b[i] );;
          if ( answer[i] >= 10 ) {
            answer[i] = (byte) ( (int) answer[i] - 10 );
            carry = true;
          } else {
            carry = false;
        }
      }
    }
    // Copy loop
    int j = 0;
    for( int i = 0; i < count; i++ ) {
      answerString = answerString.append( (int) answer[i] );
      j++;
    }
    j--;
    // Situation 1
    if( b.length > x.b.length ) {
      count = b.length;
      if( carry ) {
        b[j] = (byte) ( (int) b[j] + 1 );
        carry = false;
        if( b[j] > 9 ) {
          b[j] = 0;
          carry = true;
        }
      }
      answerString = answerString.replace( j, j + 1, new Byte( b[j] ).toString()  );
      for( int i = j + 1; i < count; i++ ) {
        if( carry ) {
          b[i] = (byte) ( (int) b[i] + 1 );
          carry = false;
          if( b[i] > 9 ) {
            b[i] = 0;
            carry = true;
          }
        }
        answerString = answerString.append( (int) b[i] );
      }
    }
    //Situation 2
    if( b.length < x.b.length ){
      count = Math.max(b.length, x.b.length);
      if( carry ) {
        x.b[j] = (byte) ( (int) x.b[j] + 1 );
        carry = false;
        if( x.b[j] > 9 ) {
          x.b[j] = 0;
          carry = true;
        }
      }
      answerString = answerString.replace( j, j + 1, new Byte( x.b[j] ).toString()  );
      for( int i = j + 1; i < count; i++ ) {
        if( carry ) {
          x.b[i] = (byte) ( (int) x.b[i] + 1 );
          carry = false;
          System.out.println(x.b[i]);
          if( x.b[i] > 9 ) {
              x.b[i] = 0;
            carry = true;
          }
        }
        answerString = answerString.append( (int) x.b[i] );
      }
    }
    if( carry ) {
      answerString = answerString.append( 1 );
    }
    System.out.println( answerString );
    answerString.reverse();
    // if( answerString.charAt(0) == '0' ) {
    //   answerString.deleteCharAt(0);
    // }
    // if( answerString.charAt(0) == '+' ) {
    //   answerString.deleteCharAt(0);
    // }
    // if( answerString.charAt(0) == '0' ) {
    //   answerString.deleteCharAt(0);
    // }

    return new GinormousInt( answerString.toString() );
  }

  /* Subtraction */
  public GinormousInt subtract( GinormousInt value ) {
    boolean borrow = false;
    StringBuffer answer = new StringBuffer( Math.max( x.b.length, b.length ) );
    int count = Math.max( x.b.length, b.length );
    // borrow boolean

    return new GinormousInt("0");
  }

  /* Multiplication */
  public GinormousInt multiply( GinormousInt value ) {
        // while statement
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
