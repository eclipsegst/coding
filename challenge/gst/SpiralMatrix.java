package gst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * Spiral Matrix
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 * 	[ 4, 5, 6 ],
 * 	[ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0) {
        	return result;
        }
        
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length -1;
        int direction = 0;
        
        while (left <= right && top <= bottom) {
        	if (direction == 0) {
        		for (int k = left; k <= right; k++) {
        			result.add(matrix[top][k]);
        		}
        		top++;
        	} else if (direction == 1) {
        		for (int k = top; k <= bottom; k++) {
        			result.add(matrix[k][right]);
        		}
        		right--;
        	} else if (direction == 2) {
        		for (int k = right; k >= left; k--) {
        			result.add(matrix[bottom][k]);
        		}
        		
        		bottom--;
        	} else if (direction == 3) {
        		for (int k = bottom; k >= top; k--) {
        			result.add(matrix[k][left]);
        		}
        		left++;
        	}
        	
        	direction = (direction + 1) % 4;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		SpiralMatrix solution = new SpiralMatrix();
		
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		List<Integer> result = solution.spiralOrder(matrix);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}

}
