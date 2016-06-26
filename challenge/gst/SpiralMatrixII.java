package gst;

import java.util.List;

/**
 * @author Zhaolong Zhong Jun 25, 2016
 * 
 * Spiral Matrix II
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 * 	[ 8, 9, 4 ],
 * 	[ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 1;
        
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int direction = 0;
        
        while (left <= right && top <= bottom) {
        	if (direction == 0) {
        		for (int k = left; k <= right; k++) {
        			matrix[top][k] = i++;
        		}
        		top++;
        	} else if (direction == 1) {
        		for (int k = top; k <= bottom; k++) {
        			matrix[k][right] = i++;
        		}
        		right--;
        	} else if (direction == 2) {
        		for (int k = right; k >= left; k--) {
        			matrix[bottom][k] = i++;
        		}
        		bottom--;
        	} else if (direction == 3) {
        		for (int k = bottom; k >= top; k--) {
        			matrix[k][left] = i++;
        		}
        		left++;
        	}
        	
        	direction = (direction + 1) % 4;
        }
        
        return matrix;
    }
	
	public static void main(String[] args) {
		SpiralMatrixII solution = new SpiralMatrixII();
		int[][] matrix = solution.generateMatrix(3);
		
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		List<Integer> result = spiralMatrix.spiralOrder(matrix);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
}
