package challenge;

/**
 * @author Zhaolong Zhong
 * Date: 2:43:25 PM Aug 2, 2015
 * 
 * Problem: Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * - Integers in each row are sorted in ascending from left to right.
 * - Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * [
 *	  [1,   4,  7, 11, 15],
 *	  [2,   5,  8, 12, 19],
 *	  [3,   6,  9, 16, 22],
 *	  [10, 13, 14, 17, 24],
 *	  [18, 21, 23, 26, 30]
 * ]
 * 
 * Given target = 5, return true.
 * Given target = 20, return false.
 * 
 * Solution:
 * Binary recursive search
 * 1. check if the center of matrix is the target or not
 * 2. if not, then divide matrix into four part and search each sub matrix
 */

public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		return searchMatrix(matrix, 0, 0, matrix.length, matrix[0].length, target);
	}

	boolean searchMatrix(int[][] matrix, int sX, int sY, int eX, int eY, int target) {
		if (sX >= eX || sY >= eY) return false;
		int min = matrix[sX][sY];
		int max = matrix[eX - 1][eY - 1];
		
		if (min <= target && target <= max) {
			int mX = (sX + eX) / 2;
			int mY = (sY + eY) / 2;
			if (matrix[mX][mY] == target) {
				return true;
			}
			return searchMatrix(matrix, sX, sY, mX, mY, target) ||
					searchMatrix(matrix, sX, mY, mX, eY, target) ||
					searchMatrix(matrix, mX, sY, eX, mY, target) ||
					searchMatrix(matrix, mX, mY, eX, eY, target);
		}
		
		return false;
		
	}
}
