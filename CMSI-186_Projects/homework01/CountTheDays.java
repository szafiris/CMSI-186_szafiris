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
 */

public class CountTheDays {
  public static void main( String args[] ) {
    long month1 = Long.parseLong( args[0] );
    long day1 = Long.parseLong( args[1] );
    long year1 = Long.parseLong( args[2] );
    long month2 = Long.parseLong( args[3] );
    long day2 = Long.parseLong( args[4] );
    long year2 = Long.parseLong( args[5] );
    CalendarStuff.isValidDate( month1, day1, year1 );
    CalendarStuff.isValidDate( month2, day2, year2 );
    long dayCount = CalendarStuff.daysBetween( month1, day1, year1, month2, day2, year2 );
    System.out.println( "Days between " + dayCount );
  }
}
