package challenge;

/**
 * @author Zhaolong Zhong Jul 6, 2016
 * 
 * Sparse Matrix Multiplication
 * 
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * 
 * Example:
 * A = [
 *  [ 1, 0, 0],
 *  [-1, 0, 3]
 *  ]
 * 
 * B = [
 *  [ 7, 0, 0 ],
 *  [ 0, 0, 0 ],
 *  [ 0, 0, 1 ]
 * ]
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 * Reference:
 * https://discuss.leetcode.com/topic/30625
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length, colA = A[0].length, colB = B[0].length;
        int[][] C = new int[rowA][colB];
        
        for (int i = 0; i < rowA; i++) {
        	for (int k = 0; k < colA; k++) {
        		if (A[i][k] != 0) {
        			for (int j = 0; j < colB; j++) {
        				if (B[k][j] != 0) {
        					C[i][j] += A[i][k] * B[k][j];
        				}
        			}
        		}
        	}
        }
        
        return C;
    }
}
