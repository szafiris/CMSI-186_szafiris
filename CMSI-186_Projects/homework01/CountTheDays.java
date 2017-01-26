/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Finds the days between two dates using methods from CalendarStuff.java
 *  Author        :  Serena Zafiris
 *  Date          :  2017-01-25
 *  Description   :  This file runs the CountTheDays program which will
 *                   calculate the number of days between two dates.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-01-25  Serena Zafiris  Initial writing and release
 *  @version 1.0.1  2017-01-26  Serena Zafiris  Called class using different method. Fixed valid date checker
 */

public class CountTheDays {
  public static void main( String args[] ) {
    long month1 = Long.parseLong( args[0] );
    long day1 = Long.parseLong( args[1] );
    long year1 = Long.parseLong( args[2] );
    long month2 = Long.parseLong( args[3] );
    long day2 = Long.parseLong( args[4] );
    long year2 = Long.parseLong( args[5] );
    CalendarStuff cs = new CalendarStuff();
    cs.isValidDate( month1, day1, year1 );
    cs.isValidDate( month2, day2, year2 );
    if( !cs.isValidDate( month1, day1, year1 ) ) {
      System.out.println( "The first date is bogus" );
      System.exit(1);
    }
    if( !cs.isValidDate( month2, day2, year2 ) ) {
      System.out.println( "The second date is bogus" );
      System.exit(1);
    }
    long dayCount = cs.daysBetween( month1, day1, year1, month2, day2, year2 );
    System.out.println( "Days between " + dayCount );
  }
}
