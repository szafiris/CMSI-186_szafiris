/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Methods for the changeMaker class
 * @author    :  Serena Zafiris
 * @author    :  Initial Code taken from B.J. Johnson
 * Date       :  2017-04-25
 * Description:  makes most effective change for given numbers
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:    Reason for change or modification
 *  -----  ----------  ------------    ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson    Initial writing and release
 *  1.0.1  2017-04-26  Serena Zafiris  added makeChangeWithDynamicProgramming and JavaDocs
 *  1.1.0  2017-05-02  Serena Zafiris  redid and completed makeChangeWithDynamicProgramming
 *  1.1.1  2017-05-04  Serena Zafiris  fixed formatting errors
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
 public class DynamicChangeMaker {

   /**
    * Main program for DynamicChangeMaker
    *
    * @param args
    *            the denominations and the amount
    */
  public static void main( String[] args ) {
    if( args.length != 2 ) {
      printUsage();
      return;
    }
    try {
      String[] denominationStrings = args[0].split( "," );
      int[] denominations = new int[denominationStrings.length];
      for( int i = 0; i < denominations.length; i++ ) {
        denominations[i] = Integer.parseInt( denominationStrings[i] );
        if( denominations[i] <= 0 ) {
          System.out.println( "Denominations must all be greater than zero.\n" );
          printUsage();
          return;
        }

        for( int j = 0; j < i; j++ ) {
          if( denominations[j] == denominations[i] ) {
            System.out.println( "Duplicate denominations are not allowed.\n" );
            printUsage();
            return;
          }
        }
      }
      int amount = Integer.parseInt(args[1]);
      if( amount < 0 ) {
        System.out.println( "Change cannot be made for negative amounts.\n" );
        printUsage();
        return;
      }
      Tuple change = makeChangeWithDynamicProgramming( denominations, amount );
      if( change.isImpossible() ) {
        System.out.println( "It is impossible to make " + amount + " cents with those denominations." );
      } else {
        int coinTotal = change.total();
        System.out.println( amount + " cents can be made with " + coinTotal + " coin" +
                   getSimplePluralSuffix(coinTotal) + " as follows:" );

        for( int i = 0; i < denominations.length; i++ ) {
          int coinCount = change.getElement(i);
          System.out.println( "- "  + coinCount + " " + denominations[i] + "-cent coin" +
                       getSimplePluralSuffix(coinCount) );
        }
       }
    } catch( NumberFormatException nfe ) {
      System.out.println( "Denominations and amount must all be integers.\n" );
      printUsage();
    }
  }

  /**
   * Finds optimal change solution for given amount
   *
   * @param denominations
   *            the types of coins that can be used
   * @param amount
   *            the desired amount
   * @return the optimal change for the designated amount
   */
  public static Tuple makeChangeWithDynamicProgramming( int[] denominations, int amount ) {
    int rows = denominations.length;
    int columns = ( amount + 1 );
    Tuple[][] table = new Tuple[rows][columns];
    for( int i = 0; i < rows; i++ ) {
      for( int j = 0; j < columns; j ++) {
        // Special Case for 0
        if( j == 0 ) {
          table[i][j] = new Tuple( rows );
        }
        // Otherwise not zero
        else {
          // if we cant take the denomination out  of j
          if( j - denominations[i] < 0 ) {
            //temporarily impossible
            table[i][j] = Tuple.IMPOSSIBLE;
            //however we check to see if we could go back
            if( j - denominations[i] >= 0 ) {
              if( table[i][j - denominations[i]] != Tuple.IMPOSSIBLE ) {
                table[i][j] = table[i][j - denominations[i]];
              } else {
                table[i][j] = Tuple.IMPOSSIBLE;
              }
            }
            // Need to check above for a solution
            if( i != 0 ) {
              if( table[i - 1][j] != Tuple.IMPOSSIBLE ) {
                table[i][j] = table[i - 1][j];
              } else {
                table[i][j] = Tuple.IMPOSSIBLE;
              }
            }
          }
          // Now we can take one denomination out
          else {
            // Make new tuple with a one in it
            table[i][j] = new Tuple( rows );
            table[i][j].setElement( i, 1 );
            // look backward for viable solution
            if( j - denominations[i] >= 0 ) {
              if( table[i][j - denominations[i]] == Tuple.IMPOSSIBLE ) {
                table[i][j] = Tuple.IMPOSSIBLE;
                if( i > 0 ) {
                  if( table[i - 1][j] != Tuple.IMPOSSIBLE ) {
                    table[i][j] = table[i - 1][j];
                  }
                }
              } else {
                table[i][j] = table[i][j].add( table[i][j - denominations[i]] );
              }
            }
            // Look above for viable solution
            if( i != 0 ) {
              if( table[i - 1][j] != Tuple.IMPOSSIBLE ) {
                if( table[i - 1][j].total() < table[i][j].total() ) {
                  table[i][j] = table[i - 1][j];
                }
              }
            }
          }
        }
      }
    }
  return table[rows - 1][columns - 1];
  }

  /**
   * Prints error message to help user see how to input correct values
   * Shows when user puts in values wrong
   */
  private static void printUsage() {
    System.out.println( "Usage: java DynamicChangemaker <denominations> <amount>" );
    System.out.println( "  - <denominations> is a comma-separated list of denominations (no spaces)" );
    System.out.println( "  - <amount> is the amount for which to make change" );
  }

  /**
   * adds plurals to coins that are used more than once in the optimal change
   *
   * @param count
   *            number of a certain coin
   * @return nothing or an s depending on amount of coins
   */
  private static String getSimplePluralSuffix( int count ) {
    return count == 1 ? "" : "s";
  }
}
