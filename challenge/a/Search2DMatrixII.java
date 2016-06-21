package a;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Search a 2D Matrix II
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 * 	[1,   4,  7, 11, 15],
 * 	[2,   5,  8, 12, 19],
 * 	[3,   6,  9, 16, 22],
 * 	[10, 13, 14, 17, 24],
 * 	[18, 21, 23, 26, 30]
 * ]
 * 
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || target < matrix[0][0] 
				|| target > matrix[matrix.length - 1][matrix[0].length - 1]) {
			return false;
		}
		
		int row = 0, col = matrix[0].length - 1;
		
		while (row <= matrix.length - 1 && col >= 0) {
			if (matrix[row][col] < target) {
				row++;
			} else if (matrix[row][col] > target) {
				col--;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Search2DMatrixII solution = new Search2DMatrixII();
		
		int[][] matrix = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		
		int target1 = 5;
		int target2 = 20;
		System.out.println(solution.searchMatrix(matrix, target1));
		System.out.println(solution.searchMatrix(matrix, target2));
	}
}
