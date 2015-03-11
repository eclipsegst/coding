/**
 * Author: Zhaolong Zhong
 * Date  : Mar 11, 2015 10:39:32 AM
 *
 */
package Inheritance;

public class Bicycle {
  
  public int cadence;
  public int gear;
  public int speed;
  
  public Bicycle(int startCadence, int startSpeed, int startGear) {
    cadence = startCadence;
    gear = startGear;
    speed = startSpeed;
  }
  
  public void setCadence(int newValue) {
    cadence = newValue;
  }
  
  public void setGear(int newValue) {
    gear = newValue;
  }
  
  public void setSpeed(int newValue) {
    speed = newValue;
  }
  
  public void speedUp(int increment) {
    speed += increment + addExtra();
  }
  // cannot be inherited by a subclass
  private int addExtra() {
    return 2;
  }
}
