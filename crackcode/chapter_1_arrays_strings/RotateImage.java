/**
 * Author: Zhaolong Zhong
 * Date  : Mar 8, 2015 10:22:32 PM
 *
 */
package chapter_1_arrays_strings;

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
