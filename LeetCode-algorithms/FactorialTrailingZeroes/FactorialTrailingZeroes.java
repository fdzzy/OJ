/*
 * Factorial Trailing Zeroes 
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
    	if(n <= 0) return 0;
    	
    	int num = n / 5;
    	int result = 0;
    	while(num != 0) {
    		result += num;
    		num /= 5;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	FactorialTrailingZeroes f = new FactorialTrailingZeroes();
    	System.out.println(f.trailingZeroes(25));
    }
}
