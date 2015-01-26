/*
 * Pascal's Triangle 
 * 
 * I.
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * II.
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if(numRows <= 0) return results;
        List<Integer> line = new ArrayList<>();
        line.add(1);
        results.add(line);
        if(numRows == 1) return results;
        line = new ArrayList<>();
        line.add(1); line.add(1);
        results.add(line);
        if(numRows == 2) return results;
        for(numRows -= 2; numRows > 0 ; numRows--) {
        	List<Integer> last = line;
        	line = new ArrayList<>();
        	line.add(1);
        	for(int i=1; i<last.size() ; i++) {
        		line.add(last.get(i-1) + last.get(i));
        	}
        	line.add(1);
        	results.add(line);
        }
        return results; 
    }
    
    /*private int combinations(int n, int m) {
    	if(n <= 0 || m == 0 || m ==n) return 1;
    	BigInteger result = BigInteger.valueOf(1);
    	for(int i=0; i<m ; i++) {
    		result = result.multiply(BigInteger.valueOf(n-i));
    	}
    	for(int i=m; i>1; i--) {
    		result = result.divide(BigInteger.valueOf(i));
    	}
    	return result.intValue();
    }*/
    
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> result = new ArrayList<>();
    	if(rowIndex < 0) return result;
    	int i=0;
        result.add(1);
    	for(i=1; i<=rowIndex/2 ; i++) {
    		//result.add(combinations(rowIndex, i));
            result.add((int)((long)result.get(i-1) * (rowIndex - i + 1) / i));
    	}
    	for(; i<=rowIndex ; i++) {
    		result.add(result.get(rowIndex - i));
    	}
    	return result;
    }

    public static void main(String[] args) {
    	PascalsTriangle p = new PascalsTriangle();
    	System.out.println(p.generate(5));
    	System.out.println(p.getRow(0));
    	System.out.println(p.getRow(4));
    	System.out.println(p.getRow(5));
    	System.out.println(p.getRow(30));
    }
}
