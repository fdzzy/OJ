/*
 * Unique Paths 
 * 
 * I.
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the 
 * diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is 
 * trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there? 
 * 
 * Note: m and n will be at most 100.
 * 
 * II.
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * 
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
    	if(m <= 0 || n <= 0) return 0;
    	if(m == 1 || n == 1) return 1;
    	
    	int[][] grid = new int[m][n];
    	grid[0][0] = 0;
    	for(int i=1; i<n ; i++) {
    		grid[0][i] = 1;
     	}
    	for(int i=1; i<m ; i++) {
    		grid[i][0] = 1;
    	}
    	for(int i=1; i<m ; i++) {
    		for(int j=1; j<n; j++) {
    			grid[i][j] = grid[i-1][j] + grid[i][j-1];
    		}
    	}
    	return grid[m-1][n-1];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int rows = obstacleGrid.length;
    	if(rows <= 0) return 0;
    	int columns = obstacleGrid[0].length;
    	if(columns <= 0) return 0;
    	
    	if(obstacleGrid[rows-1][columns-1] == 1) return 0;
    	for(int i=0; i<columns ; i++) {
    		if(obstacleGrid[0][i] == 1) break; // meet obstacle
    		obstacleGrid[0][i] = -1;	// let -n denote n ways
    	}
    	for(int i=0; i<rows ; i++) {
    		if(obstacleGrid[i][0] == 1) break;
    		obstacleGrid[i][0] = -1;
    	}
    	for(int i=1; i<rows ; i++) {
    		for(int j=1; j<columns ; j++) {
    			if(obstacleGrid[i][j] == 1) continue; // meet obstacle
    			int ways = 0;
    			if(obstacleGrid[i-1][j] != 1) 
    				ways += obstacleGrid[i-1][j];
    			if(obstacleGrid[i][j-1] != 1)
    				ways += obstacleGrid[i][j-1];
    			obstacleGrid[i][j] = ways;
    		}
    	}
    	return -1 * obstacleGrid[rows-1][columns-1];
    }
    
    public static void main(String[] args) {
    	UniquePath u = new UniquePath();
    	//System.out.println(u.uniquePaths(5, 7));
    	
    	int[][] grid = {
    			{0,0,1},
    			//{0,1,0},
    			//{0,1,0}
    	};
    	System.out.println(u.uniquePathsWithObstacles(grid));
    }
}
