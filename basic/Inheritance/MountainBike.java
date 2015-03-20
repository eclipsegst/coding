/**
 * Author: Zhaolong Zhong
 * Date  : Mar 11, 2015 10:46:37 AM
 *
 */
package Inheritance;

public class MountainBike extends Bicycle{
  public int seatHeight;
  
  public MountainBike(int startHeight, int startCadence, int startSpeed, int startGear) {
    super(startCadence, startSpeed, startGear);
    seatHeight = startHeight;
  }
  
  public void setHeight(int newValue) {
    seatHeight = newValue;
  }
}
