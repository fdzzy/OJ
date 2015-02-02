/*
 * Remove Duplicates from Sorted Array 
 * 
 * I.
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear 
 * only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with 
 * constant memory.
 * 
 * For example,
 * 
 * Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 * II.
 * 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
    	if(A.length <= 1) return A.length;
    	int fast, slow;
    	fast = slow = 0;
    	while(fast < A.length) {
    		while(fast < A.length && A[fast] == A[slow]) fast++;
    		if(fast >= A.length) break;
    		A[++slow] = A[fast++];
    	}
    	return slow+1;
    }
    
    public int removeDuplicatesII(int[] A) {
    	if(A.length <= 2) return A.length;
    	final int MAX_COUNT = 2;
    	int fast, slow;
    	slow = fast = 0;
    	while(fast < A.length) {
    		int count = 0;
    		int current = A[fast];
    		while(fast < A.length && A[fast] == current && count < MAX_COUNT) {
    			A[slow++] = A[fast++];
    			count++;
    		}
    		while(fast < A.length && A[fast] == current) fast++;
    		if(fast >= A.length) break;
    	}
    	return slow;
    }
    
    public static void main(String[] args) {
    	RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
    	int[] A = {1,1,2,2,2,3,4,4,5};
    	int len = r.removeDuplicatesII(A);
    	System.out.println(len);
    	System.out.println(Arrays.toString(A));
    }
}
