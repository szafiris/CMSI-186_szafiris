/**
 *  File name     :  Clock.java
 *  Purpose       :  Provides the methods for the clock class
 *  Author        :  Serena Zafiris
 *  Date          :  2017-02-28
 *  Description   :
 *  Notes         :
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  Serena Zafiris  Initial writing
 *  @version 1.0.1  2017-03-02  Serena Zafiris  Starting the tick method
 *  @version 1.0.2  2017-03-13  Serena Zafiris  Starting getHourHand, getMinuteHand and getHandAngle
 *  @version 1.0.3  2017-03-14  Serena Zafiris  Finished methods and started tester
 */

public class Clock {
  /**
   *  Class field definintions go here
   */
  private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
  private static final double INVALID_ARGUMENT_VALUE = -1.0;
  private static final double MAXIMUM_DEGREE_VALUE = 360.0;
  private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
  private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;

  private double hours;
  private double mins;
  private double secs;
  private double totalSecs;
  private double interval;
  private double hourAngle;
  private double minAngle;
  private double angle;

   public Clock() {
    hours = 0;
    mins = 0;
    secs = 0;
    totalSecs = 0;
    interval = 0;
    hourAngle = 0;
    minAngle = 0;
    angle = 0;
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
  public double tick() {
    totalSecs = totalSecs + interval;
    secs = totalSecs;
    if( secs >= 60 ) {
      mins = secs / 60 ;
      secs = secs % 60;
    }
    if( mins >= 60 ) {
      hours =  mins / 60;
      mins = mins % 60;
    }
    return totalSecs;
  }

  public double getTotalSecs() {
    return totalSecs;
  }
  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
  public double validateAngleArg( String argValue ) throws NumberFormatException {
    return Double.parseDouble( argValue );
  }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
  public double validateTimeSliceArg( String argValue ) {
    interval = Double.parseDouble( argValue );
    if( interval > 1800 ) {
      interval = 1800;
      System.out.println( "Time slice out of range, set to 1800 secs");
      return interval;
    }
    if( argValue.length() == 0 ) {
      interval = DEFAULT_TIME_SLICE_IN_SECONDS;
      System.out.println( "No time slice specified, time slice set to default of 60 secs");
    }
    return interval;
  }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
  public double getHourHand() {
    hourAngle = ( HOUR_HAND_DEGREES_PER_SECOND * totalSecs );
    return hourAngle;
  }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
  public double getMinuteHand() {
    minAngle = (MINUTE_HAND_DEGREES_PER_SECOND * totalSecs ) % 360;
    return minAngle;
  }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
  public double getHandAngle() {
    if( minAngle > hourAngle && minAngle <= 180 ) {
      angle = minAngle - hourAngle;
    }
    if( minAngle > hourAngle && minAngle > 180 ) {
      angle = ( 360 - minAngle ) + hourAngle;
    }
    if( hourAngle > minAngle && hourAngle <= 180 ) {
      angle = hourAngle - minAngle;
    }
    if( hourAngle > minAngle && hourAngle > 180 ) {
      angle = ( 360 - hourAngle ) + minAngle;
    }
    return angle;
  }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
  public String toString() {
    return Math.floor( hours ) + ":" + Math.floor( mins ) + ":" + secs;
  }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
  public static void main( String args[] ) {

      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println();
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println();
      System.out.println( "Testing validateTimeSliceArg for 1900 secs" );
      clock.validateTimeSliceArg( "1900" );
      System.out.println();
      System.out.println( "Testing validateTimeSliceArg for 19 secs" );
      clock.validateTimeSliceArg( "19" );
      System.out.println();
      System.out.println( "New clock created: " + clock.toString() );
      System.out.println();
      System.out.println( "Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( ( 0.0 == clock.validateAngleArg( "0.0" ) ) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println();
      System.out.println( "Testing getHourHand expecting 5.004" );
      clock.interval = 600;
      clock.tick();
      System.out.println( clock.getHourHand() );
      System.out.println( clock.toString() );
      System.out.println();
      System.out.println( "Testing getMinuteHand expecting 60" );
      System.out.println( clock.getMinuteHand() );
      System.out.println( clock.toString() );
      System.out.println();
      System.out.println( "Test for getHandAngle expecting 55 degrees" );
      System.out.println( clock.getHandAngle() );
      System.out.println();
      System.out.println( "Creating a new clock: " );
      Clock clock1 = new Clock();
      clock1.interval = 60;
      System.out.println();
      System.out.println( "New clock created: " + clock1.toString() );
      System.out.println();
      System.out.println( "Testing validateAngleArg()....");
      System.out.print( "      sending '  a degrees', expecting double value   0.0" );
      try { System.out.println( ( 0.0 == clock1.validateAngleArg( "a" ) ) ? " - got 0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
      System.out.println();
      System.out.println( "Testing getHourHand expecting 0.5004 degrees " );
      clock1.tick();
      System.out.println( clock1.getHourHand() );
      System.out.println( clock1.toString() );
      System.out.println();
      System.out.println( "Testing getMinuteHand expecting 6 degrees" );
      System.out.println( clock1.getMinuteHand() );
      System.out.println( clock1.toString() );
      System.out.println();
      System.out.println( "Test for getHandAngle expecting 10.9992 degrees" );
      System.out.println( clock1.getHandAngle() );
   }
  }
