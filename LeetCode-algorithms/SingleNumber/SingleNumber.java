/*
 * Single Number
 * 
 * I.
 * 
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement 
 * it without using extra memory?
 * 
 * II.
 * 
 * Given an array of integers, every element appears three times except for one. 
 * Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement 
 * it without using extra memory?
 */

public class SingleNumber {

	public int singleNumber(int[] A) {
        int num = 0;
        for(int ele : A) {
        	num ^= ele;
        }
        return num;
    }
	
	public int singleNumberII(int[] A) {
        int num = 0;
        for(int i=0; i<32; i++) {
        	int ones = 0;
        	for(int j=0; j<A.length ; j++) {
        		if(((A[j] >> i) & 1) == 1) ones++;
        	}
        	if(ones % 3 != 0) {
        		num += (1 << i);
        	}
        }
        return num;
    }
	
	public static void main(String[] args) {
		SingleNumber s = new SingleNumber();
		//int[] array = {1,3,5,4,-9,7,4,3,2,-9,5,7,1};  
		//System.out.println(s.singleNumber(array));
		int[] array = {1,-9,3,-9,7,3,3,1,7,-9,5,7,1};  
		System.out.println(s.singleNumberII(array));
	}
}
