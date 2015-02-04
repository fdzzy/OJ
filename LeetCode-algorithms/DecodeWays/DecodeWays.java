/*
 * Decode Ways 
 * 
 * A message containing letters from A-Z is being encoded to numbers using the 
 * following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of ways 
 * to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */
import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
	private Map<String, Integer> map = new HashMap<>();
	
    public int numDecodings(String s) {
    	if(s == null || s.isEmpty()) return 0;
    	if(s.charAt(0) == '0') return 0; 
    	if(s.length() == 1) return 1; 
    	
    	Integer result = map.get(s);
    	if(result != null) return result;

    	// at least two chars
    	char first = s.charAt(0);
    	char second = s.charAt(1);
    	int sum;
    	if(first == '1') {
    		if(second > '0') {
    			if(s.length() == 2) sum = 2;
    			else sum = numDecodings(s.substring(1)) + numDecodings(s.substring(2));
    		} else {
    			if(s.length() == 2) sum = 1;
    			else sum = numDecodings(s.substring(2));
    		}
    	} else if(first == '2') {
    		if(second > '0' && second <= '6') {
    			if(s.length() == 2) sum = 2;
    			else sum = numDecodings(s.substring(1)) + numDecodings(s.substring(2));
    		} else if(second == '0') {
    			if(s.length() == 2) sum = 1;
    			else sum = numDecodings(s.substring(2));
    		} else {
    			sum = numDecodings(s.substring(1));
    		}
    	} else {
    		sum = numDecodings(s.substring(1));
    	}
    	map.put(s, sum);
    	return sum;
    }
    
    public static void main(String[] args) {
    	DecodeWays d = new DecodeWays();
    	System.out.println(d.numDecodings("010"));	// expect 0
    	System.out.println(d.numDecodings("10"));	// expect 1
    	System.out.println(d.numDecodings("11"));	// expect 2
    	System.out.println(d.numDecodings("01"));	// expect 0
    	System.out.println(d.numDecodings(""));		// expect 0
    	System.out.println(d.numDecodings("0"));	// expect 0
    	System.out.println(d.numDecodings(
    			"9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
    }
}
