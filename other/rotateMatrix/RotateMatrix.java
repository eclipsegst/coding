package rotateMatrix;

/**
 * @author Zhaolong Zhong Nov 18, 2015
 */
public class RotateMatrix {
	public int[][] rotateMatrix(int[][] matrix, int flag) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
		int[][] result = transpose(matrix);
		flip(result, flag);
		return result;
	}
	
	private int[][] transpose(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] transposed = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				transposed[i][j] = matrix[j][i];
			}
		}
		
		return transposed;
	}
	
	private void flip(int[][] matrix, int flag) {
		int m = matrix.length, n = matrix[0].length;
		if (flag == 1) {	// clockwise
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n / 2; j++) {
					matrix[i][j] ^= matrix[i][n-j-1];
					matrix[i][n-j-1] ^= matrix[i][j];
					matrix[i][j] ^= matrix[i][n-j-1];
				}
			}
		} else {
			for (int i = 0; i < m / 2; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] ^= matrix[m-i-1][j];
					matrix[m-i-1][j] = matrix[i][j];
					matrix[i][j] ^= matrix[m-i-1][j];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int a = 2, b = 3;
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println("a = " + a + ", b = " + b);
	}
}
