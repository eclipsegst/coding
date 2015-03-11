/**
 * Author: Zhaolong Zhong
 * Date  : Mar 11, 2015 10:58:10 AM
 *
 */
package Inheritance;

public class Main {
  public static void main(String[] artgs) {
    MountainBike myBike = new MountainBike(0, 0, 0, 0); 
    myBike.setGear(2);
    myBike.setHeight(3);
    
    System.out.println(myBike.speed);       // 0
    System.out.println(myBike.gear);        // 2
    System.out.println(myBike.seatHeight);  // 3
    
    Object obj = new MountainBike(0, 0, 0, 0);
    
    //only if obj refers to MountainBike, then make the cast,
    if (obj instanceof MountainBike) {
      myBike  = (MountainBike)obj;
    }
    
    System.out.println(myBike.speed);       // 0
    System.out.println(myBike.gear);        // 0
    System.out.println(myBike.seatHeight);  // 0
    
    //obj = "2";
    //myBike  = (MountainBike)obj;// error, cause obj does not refer to MountainBike
  }
}
