/*
 * Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * 
 */
public class RotateImage {
	
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
        int[][] result = new int[n][n];
        for(int i=0; i<n ; i++) {
        	for(int j=0; j<n ; j++) {
        		result[j][n-1-i] = matrix[i][j];
        	}
        }
        for(int i=0; i<n ; i++) {
        	for(int j=0; j<n ; j++) {
        		matrix[i][j] = result[i][j];
        	}
        }
    }
    
    private void oneRotate(int[][] matrix, int i, int j, int n) {
		/*
		 * rotation is: (i, j) -> (j, n-1-i) -> (n-1-i, n-1-j) -> (n-1-j, i) ->
		 * (i, j)
		 */
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[n - 1 - j][i];
		matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
		matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
		matrix[j][n - 1 - i] = tmp;
    }

    public void rotateInPlace(int[][] matrix) {
    	int n = matrix.length;
    	for(int i=0; i<n/2 ; i++) {
    		for(int j=0; j<n/2 ; j++) {
    			oneRotate(matrix, i, j, n);
    		}
    	}
    	if(n%2 == 1) {
    		int i = n/2;
    		for(int j=0; j<n/2 ; j++) {
    			oneRotate(matrix, i, j, n);
    		}
    	}
    }

    public static void main(String[] args) {
    	int[][] matrix = {
    			{1,3,4},
    			{5,6,8},
    			{7,2,9}
    	};
    	RotateImage r = new RotateImage();
    	//r.rotate(matrix);
    	r.rotateInPlace(matrix);
    	int n = matrix.length;
    	for(int i=0; i<n ; i++) {
    		for(int j=0; j<n ; j++) {
    			System.out.print(matrix[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}
