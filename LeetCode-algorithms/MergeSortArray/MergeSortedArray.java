/*
 * Merge Sorted Array
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from B. The number of elements initialized in A and B 
 * are m and n respectively.
 */
import java.util.Arrays;



public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
    	int k = m + n -1;
    	int i = m - 1;
    	int j = n - 1;
    	while(i >= 0 && j >= 0) {
    		if(A[i] > B[j]) A[k--] = A[i--];
    		else A[k--] = B[j--];
    	}
    	while(j >= 0) {
    		A[k--] = B[j--];
    	}
    }
    
    public static void main(String[] args) {
    	int[] A = {8,10,0,0,0,0,0,0,0};
    	int[] B = {3,5,7};
    	MergeSortedArray m = new MergeSortedArray();
    	m.merge(A, 2, B, 3);
    	System.out.println(Arrays.toString(A));
    	
    }
}
