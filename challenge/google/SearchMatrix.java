package google;

/**
 * @author Zhaolong Zhong Dec 30, 2015
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) return false;
		
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
}
