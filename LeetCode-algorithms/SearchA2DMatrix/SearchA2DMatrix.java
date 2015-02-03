/*
 * Search a 2D Matrix 
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the 
 * previous row.
 * 
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * 
 * Given target = 3, return true.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null) return false;
    	int row = matrix.length;
    	int column = matrix[0].length;
    	if(row <= 0 || column <= 0) return false;
    	int iLow, jLow, iHigh, jHigh;
    	iLow = 0; jLow = 0;
    	iHigh = row-1; jHigh = column-1;
    	while(iLow >= 0 && jLow >= 0 && iHigh < row && jHigh < column &&
    			(iLow*column+jLow) <= (iHigh*column+jHigh)) {
    		// calculate the middle one
    		int distance = (iHigh-iLow) * column + (jHigh - jLow);
    		int jMiddle = (jLow + distance/2) % column;
    		int iMiddle = iLow + (jLow + distance/2) / column;
    		int value = matrix[iMiddle][jMiddle];
    		if(target == value) return true;
    		else if(target < value) {
    			iHigh = iMiddle - ((jMiddle == 0) ? 1 : 0);
    			jHigh = (jMiddle + column - 1) % column;
    		} else {
    			iLow = iMiddle + ((jMiddle == (column-1)) ? 1 : 0);
    			jLow = (jMiddle + 1) % column;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {
    			{1,   3,  5,  7},
    			{10, 11, 16, 20},
    			{23, 30, 34, 50}
    	};
    	SearchA2DMatrix s = new SearchA2DMatrix();
    	System.out.println(s.searchMatrix(matrix, 50));
    }
}
