/*
 * Set Matrix Zeroes 
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
 * Do it in place.
 * 
 * Follow up:
 * 
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        if(rowCount <= 0) return;
        int columnCount = matrix[0].length;
        if(columnCount <= 0) return;
        
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        for(int i=0; i<columnCount ; i++) {
        	if(matrix[0][i] == 0) {
        		firstRowZero = true;
        		break;
        	}
        }
        for(int i=0; i<rowCount ; i++) {
        	if(matrix[i][0] == 0) {
        		firstColumnZero = true;
        		break;
        	}
        }
        // project all the 0s to the first row and first column
        for(int i=1; i<rowCount ; i++) {
        	for(int j=1; j<columnCount ; j++) {
        		if(matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        // now we do the real work, reversely
        for(int i=columnCount-1; i>=1 ; i--) {
        	if(matrix[0][i] == 0) {
        		for(int j=1; j<rowCount ; j++)
        			matrix[j][i] = 0;
        	}
        }
        for(int i=rowCount-1; i>=1 ; i--) {
        	if(matrix[i][0] == 0) {
        		for(int j=1; j<columnCount ; j++)
        			matrix[i][j] = 0;
        	}
        }
        // finally, we check the set first row and first column if necessary
        if(firstRowZero) {
        	for(int i=0; i<columnCount ; i++)
        		matrix[0][i] = 0;
        }
        if(firstColumnZero) {
        	for(int i=0; i<rowCount ; i++)
        		matrix[i][0] = 0;
        }
    }
    
    public static void main(String[] args) {
    	SetMatrixZeroes s = new SetMatrixZeroes();
    	int matrix[][] = {
    			{0,2,3,4,5,6,7},
    			{1,0,3,4,0,6,7},
    			{1,2,3,4,5,6,7},
    			{1,2,3,4,0,6,7},
    			{1,2,3,4,5,6,7},
    			{1,0,3,4,5,6,7}
    	};
    	s.setZeroes(matrix);
    	for(int i=0; i<matrix.length ; i++) {
    		for(int j=0; j<matrix[i].length ; j++)
    			System.out.print(matrix[i][j] + " ");
    		System.out.println();
    	}
    }
}
