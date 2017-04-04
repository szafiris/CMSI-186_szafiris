/**
 *  File name     :  Ball.java
 *  Purpose       :  Provides the methods for the ball class
 *  Author        :  Serena Zafiris
 *  Date          :  2017-03-21
 *  Description   :
 *  Notes         :
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:    Reason for change/modification
 *           -----  ----------  ------------    -----------------------------------------------------------
 *  @version 1.0.0  2017-03-21  Serena Zafiris  Initial writing
 *  @version 1.0.1  2017-03-27  Serena Zafiris  Added checkCollision
 *  @version 1.0.2  2017-04-02  Serena Zafiris  Added rest of methods and tester
 *  @version 1.0.3  2017-04-02  Serena Zafiris  Deleted velocity methods
 */

public class Ball {
  /* Variables go here */
  private double x = 0.0;
  private double y = 0.0;
  private double dx = 0.0;
  private double dy = 0.0;

  /* Constructor */
  public Ball( double xPos, double yPos, double deltaX, double deltaY ) {
    x = xPos;
    y = yPos;
    dx = deltaX;
    dy = deltaY;
  }

  public double updateDx() {
    dx *= 0.99;
    return dx;
  }

  public double updateDy() {
    dy *= 0.99;
    return dy;
  }

  public double getDX() {
    return this.dx;
  }

  public double getDY() {
    return this.dy;
  }
  /* update location */
  public void updateLocation() {
    x += dx;
    y += dy;
  }

  /* Method that gets the x coordinate of the ball */
  public double getXPos() {
    return this.x;
  }

  /* Method that gets the y coordinate of the ball */
  public double getYPos() {
    return this.y;
  }

  public String toString() {
    String output = "";
    if( Math.abs( dx ) < ( 1 / 12 ) && Math.abs( dy ) < ( 1 / 12 ) ) {
      output = "position: " + x + ", " + y + " at rest";
    } else {
      output = "position: " + x + ", " + y + " velocity: " + dx + ", " + dy;
    }
    return output;
  }

  public static void main( String args[] ) {
    System.out.println( "Creating a new ball: " );
    Ball ball = new Ball( 30.0, 40.0, 3.0, 4.0 );
    System.out.println( "Testing getXPos (expecting 30.0) " );
    System.out.println( ball.getXPos() );
    System.out.println( "Testing getYPos (expecting 40.0) " );
    System.out.println( ball.getYPos() );
    System.out.println( "Testing getDX (expecting 3.0) " );
    System.out.println( ball.getDX() );
    System.out.println( "Testing getDY (expecting 4.0) " );
    System.out.println( ball.getDY() );
    System.out.println( "Testing updateDx (expecting 2.969999) " );
    System.out.println( ball.updateDx() );
    System.out.println( "Testing updateDy (expecting 3.96) " );
    System.out.println( ball.updateDy() );
    System.out.println( "Testing toString " );
    System.out.println( ball.toString() );
  }
}
