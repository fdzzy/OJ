/*
 * Add Binary 
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
import java.util.ArrayList;
import java.util.List;


public class AddBinary {

    public String addBinary(String a, String b) {
        if(a == null || b == null) return null;
        char[] digitsA = a.toCharArray();
        char[] digitsB = b.toCharArray();
        List<Integer> reverse = new ArrayList<>();
        
        int i = digitsA.length - 1;
        int j = digitsB.length - 1;
        int carry = 0;
        while(i >= 0 && j >= 0) {
        	int sum = digitsA[i] - '0' + digitsB[j] - '0' + carry;
        	carry = sum / 2;
        	reverse.add(sum % 2);
        	--i; --j;
        }
        while(i >= 0) {
        	int sum = digitsA[i] - '0' + carry;
        	carry = sum / 2;
        	reverse.add(sum % 2);
        	--i;
        }
        while(j >= 0) {
        	int sum = digitsB[j] - '0' + carry;
        	carry = sum / 2;
        	reverse.add(sum % 2);
        	--j;
        }
        StringBuilder sb = new StringBuilder();
        if(carry != 0) sb.append('1');
        for(i=reverse.size()-1; i>=0 ; i--) {
        	sb.append((char)('0' + reverse.get(i)));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	AddBinary add = new AddBinary();
    	String[] a = {"11", "111"};
    	String[] b = {"1", "11"};
    	for(int i=0; i<a.length ; i++) {
    		System.out.println(a[i] + " + " + b[i] + " = " + add.addBinary(a[i], b[i]));
    	}
    }

}
