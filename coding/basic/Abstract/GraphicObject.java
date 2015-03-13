/**
 * Author: Zhaolong Zhong
 * Date  : Mar 12, 2015 10:44:52 PM
 *
 */
package Abstract;

public abstract class GraphicObject {
  int x, y;
  void moveTo(int newX, int newY) {
    
  }
  abstract void draw();
  abstract void resize();
}
