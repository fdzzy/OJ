/*
 * Gray Code 
 * 
 * The gray code is a binary numeral system where two successive values differ 
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * Note:
 * 
 * For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above 
 * definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code sequence. 
 * Sorry about that.
 */
import java.util.ArrayList;
import java.util.List;


public class GrayCode {
    public List<Integer> grayCode(int n) {
    	if(n < 0) return null;
    	List<Integer> results = new ArrayList<>();
    	if(n == 0) {
    		results.add(0);
    		return results;
    	}
    	if(n == 1) {
    		results.add(0);
    		results.add(1);
    		return results;
    	}
    	List<Integer> subResults = grayCode(n-1);
    	for(int i=0; i<subResults.size() ; i++) {
    		results.add(subResults.get(i));
    	}
    	int add = 1<<(n-1);
    	for(int i=subResults.size()-1; i>=0 ; i--) {
    		results.add(add + subResults.get(i));
    	}
    	return results;
    }
    
    public static void main(String[] args) {
    	GrayCode g = new GrayCode();
    	System.out.println(g.grayCode(3));
    }
}
