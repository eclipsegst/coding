/**
 * Author: Zhaolong Zhong
 * Date  : Mar 8, 2015 10:22:32 PM
 * Problem: 1.6
 * Given an image represneted by an N*N matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
package crackcode;

public class RotateImage {
  public void rotate(int[][] matrix, int n) {
    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;
      for (int i = first; i < last; i++) {
        int offset = i - first;
        // top
        int top = matrix[first][i];
        // left -> top
        matrix[first][i] = matrix[last - offset][first];
        // bottom -> left
        matrix[last - offset][first] = matrix[last][last - offset];
        // right -> bottom
        matrix[last][last - offset] = matrix[i][last];
        // top -> right
        matrix[i][last] = top;
      }
    }
  }
}
