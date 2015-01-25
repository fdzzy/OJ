/*
 * Climbing Stairs 
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] results =  new int[n+1];
        results[0] = 0; results[1] = 1; results[2] = 2;
        for(int i=3 ; i<=n ; i++) {
        	results[i] = results[i-1] + results[i-2];
        }
        return results[n];
    }
    
    public static void main(String[] args) {
    	ClimbingStairs c = new ClimbingStairs();
    	for(int i=1; i< 10; i++) {
    		System.out.println(c.climbStairs(i));
    	}
    	
    }
}
