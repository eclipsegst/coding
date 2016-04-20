package challenge;

import java.util.Arrays;
import java.util.Stack;
/*
 * Date: 01/22/2015 20:30
 * Problem:
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s
 */
public class MaxSquare {
  public static void main(String[] args) {
    int[][] matrix = {
        {0,1,1,0,1},
        {1,1,0,1,0},
        {0,1,1,1,0},
        {1,1,1,1,1},
        {0,1,1,0,0},
        {0,1,1,0,0}
    };
    
    System.out.println(maxRectangle(matrix));
  }
  
  public static int maxRectangle(int[][] matrix) {
    int max = 0;
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] height = new int[row][col];
    for (int j = 0; j<col; j++) {
      height[0][j] = matrix[0][j] - 0; // '0' - '0' = 0, '1' - '0' = 1
    }
    for (int i=1; i<row; i++) {
      for (int j=0; j<col; j++) {
        if (matrix[i][j] == 1) {
          height[i][j] = height[i-1][j] + 1;
        }
      }
    }
    
    for (int i=0; i<row; i++) {
      int area = largestRectangleArea(height[i]);
      if (area > max) max = area;
    }
    return max;
  }
  
  public static int largestRectangleArea(int[] height) {
    Stack<Integer> stack = new Stack<Integer>();
    int i = 0;
    int maxArea = 0;
    
    int[] h = new int[height.length + 1];
    h = Arrays.copyOf(height, height.length + 1);
    while(i < h.length) {
      if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
        stack.push(i++);
      } else {
        int t = stack.pop();
        maxArea = Math.max(maxArea,  h[t] * (stack.isEmpty() ? i : i -stack.peek() -1));
      }
    }  
    return maxArea;
  }
}
