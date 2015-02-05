/*
 * Given a list of non negative integers, arrange them such that they form the largest 
 * number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an 
 * integer.
 */
import java.util.Arrays;


public class LargestNumber {
	private int compare(int a, int b) {
		String aStr = "" + a;
		String bStr = "" + b;
		if(aStr.length() == bStr.length()) {
			return a - b;
		} else {
			String a_b = aStr + bStr;
			String b_a = bStr + aStr;
			return a_b.compareTo(b_a);
		}
	}
	
	private void quickSort(int[] num, int low, int high) {
		if(num.length <= 1 || low >= high) return;
		int target = num[low];
		int i=low, j=high;
		while(i<j) {
			while(i<j && (compare(num[j], target) >= 0)) j--;
			if(i<j) {
				num[i] = num[j];
				i++;
			}
			while(i<j && (compare(num[i], target) < 0)) i++;
			if(i<j) {
				num[j] = num[i];
				j--;
			}
		}
		num[i] = target;
		quickSort(num, low, i-1);
		quickSort(num, i+1, high);
	}
	
    public String largestNumber(int[] num) {
    	System.out.println(Arrays.toString(num));
    	quickSort(num, 0, num.length-1);
    	System.out.println(Arrays.toString(num));
    	StringBuilder sb = new StringBuilder();
    	boolean start = false;
    	for(int i=num.length-1; i>=0 ; i--) {
    		if(!start && num[i]==0) continue; 
    		else start = true;
    		sb.append("" + num[i]);
    	}
    	if(sb.toString().isEmpty()) sb.append("0");
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	int[] num = {3, 30, 34, 5, 9, 45, 454};
    	//int[] num = {0,0};
    	LargestNumber l = new LargestNumber();
    	System.out.println(l.largestNumber(num));
    }
}
